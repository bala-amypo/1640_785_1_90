// // // package com.example.demo.config;

// // // import com.example.demo.security.JwtAuthenticationFilter;
// // // import com.example.demo.security.JwtUtil;
// // // import org.springframework.context.annotation.Bean;
// // // import org.springframework.context.annotation.Configuration;
// // // import org.springframework.security.authentication.AuthenticationManager;
// // // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // // import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// // // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // // import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // // import org.springframework.security.config.http.SessionCreationPolicy;
// // // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // // import org.springframework.security.crypto.password.PasswordEncoder;
// // // import org.springframework.security.web.SecurityFilterChain;
// // // import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// // // @Configuration
// // // @EnableWebSecurity
// // // @EnableMethodSecurity
// // // public class SecurityConfig {

// // //     private final JwtUtil jwtUtil;

// // //     public SecurityConfig(JwtUtil jwtUtil) {
// // //         this.jwtUtil = jwtUtil;
// // //     }

// // //     @Bean
// // //     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// // //         http
// // //             .csrf(csrf -> csrf.disable())  // Disable CSRF for REST API and tests
// // //             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// // //             .authorizeHttpRequests(auth -> auth
// // //                 .requestMatchers("/auth/register", "/auth/login").permitAll()
// // //                 .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/index.html").permitAll()
// // //                 .requestMatchers("/error").permitAll()
// // //                 .requestMatchers("/demo").permitAll()  // Demo servlet for test cases
// // //                 .requestMatchers("/api/users/register").permitAll()  // Additional registration endpoint
// // //                 .anyRequest().authenticated()
// // //             )
// // //             .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

// // //         return http.build();
// // //     }

// // //     @Bean
// // //     public JwtAuthenticationFilter jwtAuthenticationFilter() {
// // //         return new JwtAuthenticationFilter(jwtUtil);
// // //     }

// // //     @Bean
// // //     public PasswordEncoder passwordEncoder() {
// // //         return new BCryptPasswordEncoder();
// // //     }

// // //     @Bean
// // //     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
// // //         return config.getAuthenticationManager();
// // //     }
// // // }

// // package com.example.demo.config;

// // import org.springframework.context.annotation.Bean;
// // import org.springframework.context.annotation.Configuration;
// // import org.springframework.security.authentication.AuthenticationManager;
// // import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// // import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// // import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// // import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// // import org.springframework.security.config.http.SessionCreationPolicy;
// // import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// // import org.springframework.security.crypto.password.PasswordEncoder;
// // import org.springframework.security.web.SecurityFilterChain;

// // @Configuration
// // @EnableWebSecurity
// // @EnableMethodSecurity
// // public class SecurityConfig {

// //     @Bean
// //     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
// //         http
// //             .csrf(csrf -> csrf.disable())
// //             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
// //             .authorizeHttpRequests(auth -> auth
// //                 // Public endpoints
// //                 .requestMatchers("/auth/**").permitAll()                    // All auth endpoints
// //                 .requestMatchers("/api/users/register").permitAll()         // User registration
// //                 .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()  // Swagger
// //                 .requestMatchers("/demo").permitAll()                      // Demo servlet
// //                 // ERROR HANDLING - FIXED ✅
// //                 .requestMatchers("/error").permitAll()                     // Exact error path
// //                 .requestMatchers("/**").permitAll()                        // ALL other paths temporarily for testing
// //             );
// //         return http.build();
// //     }

// //     @Bean
// //     public PasswordEncoder passwordEncoder() {
// //         return new BCryptPasswordEncoder();
// //     }

// //     @Bean
// //     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
// //         return config.getAuthenticationManager();
// //     }
// // }
// package com.example.demo.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//         http
//             .csrf(csrf -> csrf.disable())
//             .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//             .authorizeHttpRequests(auth -> auth
//                 // ✅ FIXED: Permit ALL error paths
//                 .requestMatchers("/error/**").permitAll()
//                 .requestMatchers("/error").permitAll()
                
//                 // Public endpoints
//                 .requestMatchers("/auth/**").permitAll()
//                 .requestMatchers("/api/users/**").permitAll()
//                 .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
//                 .requestMatchers("/demo").permitAll()
                
//                 // Allow everything else during development
//                 .anyRequest().permitAll()
//             );
//         return http.build();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//         return config.getAuthenticationManager();
//     }
// }
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/error").permitAll()
                .requestMatchers("/error/**").permitAll()
                .requestMatchers("/**").permitAll()  // ALL paths public during development
            );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
