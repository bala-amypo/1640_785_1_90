package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth

                // ✅ PUBLIC ENDPOINTS
                .requestMatchers("/api/users/register").permitAll()
                .requestMatchers("/api/auth/**").permitAll()

                // 🔐 PROTECTED ENDPOINTS
                .requestMatchers("/api/users/**").authenticated()
                .requestMatchers("/api/tickets/**").authenticated()
                .requestMatchers("/api/categories/**").authenticated()
                .requestMatchers("/api/rules/**").authenticated()
                .requestMatchers("/api/duplicates/**").authenticated()

                .anyRequest().authenticated()
            )
            .oauth2ResourceServer(oauth2 -> oauth2.jwt());

        return http.build();
    }
}
