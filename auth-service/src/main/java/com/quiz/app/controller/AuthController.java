package com.quiz.app.controller;

import com.quiz.app.config.UserInfoUserDetails;
import com.quiz.app.dto.AuthRequest;
import com.quiz.app.entity.UserInfo;
import com.quiz.app.entity.UserRefreshToken;
import com.quiz.app.service.JwtService;
import com.quiz.app.service.RefreshTokenService;
import com.quiz.app.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@Slf4j
//@CrossOrigin(origins = "http://localhost:4200/", allowCredentials = "true")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenService refreshTokenService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome, this endpoint is not secure";
    }

    @PostMapping("/register")
    public ResponseEntity<?> addNewUser(@RequestBody UserInfo userInfo) {
        if (userService.getUserByName(userInfo.getName()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Username already taken");
        }
        userService.addUser(userInfo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/login")
    public ResponseEntity<Void> authenticateAndGetToken(@RequestBody AuthRequest authRequest,
                                                  HttpServletResponse response,
                                                  HttpServletRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(),
                            authRequest.getPassword()));

            if (!authentication.isAuthenticated()) {
                throw new BadCredentialsException("Invalid credentials");
            }

            UserInfoUserDetails userDetails = (UserInfoUserDetails) authentication.getPrincipal();
            // put needed claims
//            Map<String, Object> claims = new HashMap<>();
//            claims.put("userId", userDetails.getUserId());
//            claims.put("userName", userDetails.getUsername());

            // create refresh token
            UserRefreshToken refreshToken =refreshTokenService.createRefreshToken(userDetails.getUserId());

            // create access token (jwt)
            String accessToken = jwtService.generateToken(authRequest.getUsername(), null);

            // add cookies
            addHttpOnlyCookie(response, "token", accessToken);
            addHttpOnlyCookie(response, "refreshId", refreshToken.getRefreshId());
            addHttpOnlyCookie(response, "userId", userDetails.getUserId().toString());
            log.info("User successfully logged in");
            return ResponseEntity.status(HttpStatus.OK).build();

        } catch (AuthenticationException e) {
            // Handle authentication failure
            log.info("Authentication Failed");
            throw new RuntimeException("Authentication Failed");
        }
    }

    private void addHttpOnlyCookie(HttpServletResponse response, String name, String value) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);
        cookie.setSecure(true);
        cookie.setMaxAge(-1);
        response.addCookie(cookie);
    }

    @PostMapping("/refreshToken")
    public ResponseEntity<Void> refreshToken(HttpServletRequest request,
                                             HttpServletResponse response) {

        Map<String, String> cookieMap = new HashMap<>();
        Arrays.asList(request.getCookies()).forEach(cookie -> {
            cookieMap.put(cookie.getName(), cookie.getValue());
        });
        String refreshId = cookieMap.get("refreshId");
        log.info("RefeshId: " + refreshId);
        Optional<UserRefreshToken> userRefreshToken = refreshTokenService.findByToken(refreshId);
        if(userRefreshToken.isEmpty()){
            log.info("Invalid RefreshId");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        if(refreshTokenService.isExpired(userRefreshToken.get())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Optional<UserInfo> userInfo = userRefreshToken.map(UserRefreshToken::getUserInfo);
        String newAccessToken = jwtService.generateToken(userInfo.get().getName(), null);
        addHttpOnlyCookie(response, "token", newAccessToken);
        addHttpOnlyCookie(response, "refreshId", refreshId);
        log.info("Generated new token");
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
