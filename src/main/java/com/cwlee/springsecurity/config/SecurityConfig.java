package com.cwlee.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    /**
     * UserDetailsService 구성요소 재정의
     *
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {    // 로컬테스트용
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails local = User.builder().username("local").password("local").build();
        inMemoryUserDetailsManager.createUser(local);

        return inMemoryUserDetailsManager;
    }

    /**
     * PasswordEncoder 재정의
     * UserDetailsService를 커스텀했으므로, PasswordEncoder 역시 커스텀필요
     *
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();     // 암호화 적용X
        return new BCryptPasswordEncoder();
    }

    /**
     * 엔드포인트에 따른 접근 권한 부여 재정의
     *
     * @param httpSecurity
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests((auth) -> auth.anyRequest().authenticated())     // 모든 요청에 대한 인증요구
                .httpBasic(withDefaults());                                         // HTTP Basic 인증 

        return httpSecurity.build();
    }
}
