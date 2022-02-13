package com.manoj.gateway.filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.manoj.gateway.exception.JwtTokenMalformedException;
import com.manoj.gateway.exception.JwtTokenMissingException;
import com.manoj.gateway.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import io.jsonwebtoken.Claims;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GatewayFilter {
	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	@Autowired
	private JwtUtil jwtUtil;

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();

		final List<String> apiEndpoints = Collections.unmodifiableList(
				new ArrayList<String>((Arrays.asList("/health"))));

		Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
				.noneMatch(uri -> r.getURI().getPath().contains(uri));
		if (isApiSecured.test(request)) {
			if (!request.getHeaders().containsKey("Authorization")
					|| !request.getHeaders().getOrEmpty("Authorization").get(0).contains("Bearer ")) {
				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.UNAUTHORIZED);
				return response.setComplete();
			}

			final String token = request.getHeaders().getOrEmpty("Authorization").get(0).replace("Bearer ", "");
			try {
				jwtUtil.validateToken(token);
			} catch (JwtTokenMalformedException | JwtTokenMissingException e) {
				logger.error("JwtAuthenticationFilter filter() -> Error {}" + e.getMessage());
				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.UNAUTHORIZED);

				return response.setComplete();
			}
			Claims claims = jwtUtil.getClaims(token);
			exchange.getRequest().mutate().header("username", String.valueOf(claims.get("username"))).build();
		}
		return chain.filter(exchange);
	}

}
