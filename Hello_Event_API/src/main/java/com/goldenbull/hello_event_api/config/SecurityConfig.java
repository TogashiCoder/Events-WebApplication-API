package com.goldenbull.hello_event_api.config;

import com.goldenbull.hello_event_api.filter.JwtAuthenticationFilter;
import com.goldenbull.hello_event_api.service.implementation.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final UserServiceImpl userServiceImp;
    private final CustomLogoutHandler logoutHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                //1
                .csrf(AbstractHttpConfigurer::disable)
                //2
                .authorizeHttpRequests(
                        req->req.requestMatchers("/login/**","/register/**","/api/contact/**")
                                .permitAll()
                                .requestMatchers("/api/event/admin/**","/api/user/admin/**").hasAuthority("ADMIN")
                                .anyRequest()
                                .authenticated()
                )
                //3
                .userDetailsService(userServiceImp)
                //4
                .sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                //5
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                //6
                .exceptionHandling(
                        e->e.accessDeniedHandler(
                                        (request, response, accessDeniedException)->response.setStatus(403)
                                )
                                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
                //7
                .logout(l->l
                        .logoutUrl("/logout")
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext()
                        ))
                .build();

    }


    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

}
