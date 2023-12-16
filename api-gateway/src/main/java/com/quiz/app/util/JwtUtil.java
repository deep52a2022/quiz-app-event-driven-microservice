package com.quiz.app.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET;

    private Key key;
    @Getter
    @Setter
    private Claims claims;

    @PostConstruct
    public void init(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public void extractAllClaims(String token) {
        try {
            claims = Jwts
                    .parser()
                    .setSigningKey(key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
        } catch (JwtException e) {
            log.error(e.getMessage());
            claims = null;
        } catch (Exception e) {
            log.error(e.getMessage());
            claims = null;
        }
    }

    private boolean isTokenExpired(String token) {
        if(getClaims() == null) return true;
        return getClaims().getExpiration().before(new Date());
    }

    public boolean isInvalid(String token) {
        if(claims == null) extractAllClaims(token);
        return this.isTokenExpired(token);
    }

    public void logUserId(String token){
        if(claims == null) extractAllClaims(token);
        int userId = (int) getClaims().get("userId");
        log.info(String.valueOf(userId));
    }

}
