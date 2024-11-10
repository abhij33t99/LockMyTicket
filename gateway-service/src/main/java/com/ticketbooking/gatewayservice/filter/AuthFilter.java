package com.ticketbooking.gatewayservice.filter;

import com.ticketbooking.gatewayservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class AuthFilter implements GlobalFilter {

    private final JwtService jwtService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        if(path.startsWith("/auth"))
            return chain.filter(exchange);

        // validate token
        String authHeader = request.getHeaders().getFirst("Authorization");
        if (!authHeader.startsWith("Bearer"))
            return errorResponse(exchange, chain);
        long userId = jwtService.isTokenValid(authHeader.substring(7));
        if (userId == 0)
            return errorResponse(exchange, chain);
        // set headers
        request.mutate()
                .header("X-User-Id", String.valueOf(userId))
                .build();
        ServerWebExchange authExchange = exchange.mutate().request(request).build();
        return chain.filter(authExchange);
    }

    private Mono<Void> errorResponse(ServerWebExchange exchange,GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(HttpStatusCode.valueOf(403));
        response.writeWith(Mono.just(response.bufferFactory().wrap("UnAuthorized".getBytes(StandardCharsets.UTF_8))));
        ServerWebExchange errorExchange = exchange.mutate().response(response).build();
        return chain.filter(errorExchange);
    }
}
