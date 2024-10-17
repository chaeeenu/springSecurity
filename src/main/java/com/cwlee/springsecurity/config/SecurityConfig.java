package com.cwlee.springsecurity.config;

import com.cwlee.springsecurity.filter.LoggingFilter;
import com.cwlee.springsecurity.filter.RequestValidationFilter;
import com.cwlee.springsecurity.filter.StaticKeyAuthenticationFilter;
import com.cwlee.springsecurity.filter.TestFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;
    private final TestFilter testFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.addFilterBefore(new RequestValidationFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new LoggingFilter(), BasicAuthenticationFilter.class)
                .addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class)
                .addFilterAt(testFilter, BasicAuthenticationFilter.class)
                .authorizeHttpRequests(c -> c.anyRequest().permitAll());

        return httpSecurity.build();
    }
}
