package com.quiz.app.filter;

import com.quiz.app.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@RefreshScope
@Component
@Slf4j
public class AuthenticationFilter implements GatewayFilter {

    private final static Set<String> authCookies = Set.of(
            "token", "refreshId", "userId"
    );
    private final static Set<String> neededCookies = Set.of(
             "userId"
    );

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String endpointPath = request.getPath().toString();
        log.info("Endpoint Accessed: " + endpointPath);
        if ("/logout".equals(endpointPath)) {
            return handleLogout(exchange.getResponse())
                    .flatMap(responseEntity -> {
                        // modify if needed
                        return response.writeWith(Mono.empty());
                    });
        }
        MultiValueMap<String, HttpCookie> cookies = request.getCookies();
        final String token = cookies.get("token").get(0).getValue();
//        log.info("Token Value: {}", token);
        if (jwtUtil.isInvalid(token)) {
            log.info("Token is invalid");
            return this.onError(exchange, HttpStatus.FORBIDDEN);
        }
        exchange = this.updateRequest(exchange);
        jwtUtil.setClaims(null);
        return chain.filter(exchange);
    }


    private Mono<Void> onError(ServerWebExchange exchange, HttpStatus httpStatus) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(httpStatus);
        return response.setComplete();
    }

//    private ServerWebExchange updateRequest(ServerWebExchange exchange) {
//        exchange = deleteCookie(exchange, "token");
//        exchange = deleteCookie(exchange, "refreshId");
//        exchange = deleteCookie(exchange, "userId");
//        log.info("Removed auth related cookies");
//        return exchange;
//    }

    private ServerWebExchange updateRequest(ServerWebExchange exchange) {
        ServerHttpRequest request = exchange.getRequest();

        MultiValueMap<String, HttpCookie> requestCookies = request.getCookies(); // immutable
        Map<String, String> neededCookiesMap = new HashMap<>();

        // Preserving needed cookies to use them as headers later
        for(String key: neededCookies){
            if(requestCookies.containsKey(key)){
                neededCookiesMap.put(key, requestCookies.get(key).get(0).getValue());
            }
        }
        // adding needed cookies as headers
        ServerHttpRequest mutatedRequest = request.mutate()
                .headers(httpHeaders -> {
                    // Add headers from neededCookiesMap
                    for (Map.Entry<String, String> entry : neededCookiesMap.entrySet()) {
                        httpHeaders.add(entry.getKey(), entry.getValue());
                    }
                })
                .build();
//        ServerHttpRequest mutatedRequest = request.mutate()
//                .header(neededCookiesMap.getKey("userId"), neededCookiesMap.geValue("userId"))
//                .build();
        ServerWebExchange mutatedExchange = exchange.mutate().request(mutatedRequest).build();
        return mutatedExchange;
    }

    private String buildCookieHeaderValue(MultiValueMap<String, HttpCookie> cookies) {
        List<String> cookieStrings = cookies.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream().map(HttpCookie::toString))
                .collect(Collectors.toList());
        return String.join("; ", cookieStrings);
    }

    private Mono<ResponseEntity<Void>> handleLogout(ServerHttpResponse response) {
        deleteCookie(response, "token");
        deleteCookie(response, "refreshId");
        deleteCookie(response, "userId");
        return Mono.just(ResponseEntity.status(HttpStatus.OK).build());
    }

    private void deleteCookie(ServerHttpResponse response, String name) {
        ResponseCookie cookie = ResponseCookie.from(name, "")
                .maxAge(0)
                .httpOnly(true)
                .build();
        response.addCookie(cookie);
    }

}
