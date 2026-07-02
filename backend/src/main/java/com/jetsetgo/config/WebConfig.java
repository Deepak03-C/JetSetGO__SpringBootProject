package com.jetsetgo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(false);
    }

    /**
     * Handles Chrome's Private Network Access (PNA) policy.
     * Browsers block public HTTPS origins (e.g. Vercel) from fetching loopback
     * addresses (localhost) unless the server responds to the OPTIONS preflight
     * with the "Access-Control-Allow-Private-Network: true" header.
     */
    @Bean
    public OncePerRequestFilter privateNetworkAccessFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain filterChain)
                    throws ServletException, IOException {

                if ("OPTIONS".equalsIgnoreCase(request.getMethod())
                        && request.getHeader("Access-Control-Request-Private-Network") != null) {
                    response.setHeader("Access-Control-Allow-Private-Network", "true");
                }
                filterChain.doFilter(request, response);
            }
        };
    }
}
