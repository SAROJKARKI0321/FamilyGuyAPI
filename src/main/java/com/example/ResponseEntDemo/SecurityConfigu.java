package com.example.ResponseEntDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigu {
    @Autowired
    private AppUserDetailService appUserDetailService;


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
/*
return

        http.csrf(csrf-> csrf.disable())
                .headers(headers-> headers
                        .frameOptions(frameOptionsConfig -> frameOptionsConfig.sameOrigin()))
                .authorizeHttpRequests(auth->  auth
                        .requestMatchers(HttpMethod.GET,"/api/users/**").permitAll()
                        .requestMatchers(HttpMethod.DELETE,"/api/users/**").hasRole("ADMIN")

                        .requestMatchers("/api/users/**").authenticated()
                        .anyRequest().permitAll()
                )
                .userDetailsService(appUserDetailService)
                .httpBasic(Customizer.withDefaults())
                .logout(logout->logout.permitAll())
                .build();



    }

}
*/


            return http
                    // Disable CSRF for testing APIs (Postman, curl)
                    .csrf(csrf -> csrf.disable())
                    // Allow frames from same origin to support H2 console UI
                    .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                    .authorizeHttpRequests(auth -> auth
                            // Public access to registration endpoints
                            .requestMatchers("/auth/**").permitAll()
                            // Allow anyone to GET users (no auth required)
                            .requestMatchers(HttpMethod.GET, "/api/users/**").permitAll()
                            // Only ADMIN can DELETE users
                            .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("ADMIN")
                            // Other /api/users/** endpoints require authentication
                            .requestMatchers("/api/users/**").authenticated()
                            // Allow all other requests (e.g., H2 console)
                            .anyRequest().permitAll()
                    )
                    // Use your custom UserDetailsService for authentication
                    .userDetailsService(appUserDetailService)
                    // Use HTTP Basic auth (for testing)
                    .httpBasic(Customizer.withDefaults())
                    // Allow logout for all
                    .logout(logout -> logout.permitAll())
                    .build();
        }
    }
