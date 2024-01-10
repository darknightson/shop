package com.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage("/members/login") // 로그인 페이지
                .defaultSuccessUrl("/") // 로그인 성공시 URL
                .usernameParameter("email") // 로그인 페이지에서 사용할 파라미터
                .failureUrl("/members/login/error") // 로그인 실패시 URL
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout")) // 로그아웃 URL
                .logoutSuccessUrl("/") // 로그아웃 성공시 URL
        ;

        http.authorizeRequests()
                .mvcMatchers("/css/**", "/js/**", "/img/**").permitAll() // 특정 URL은 인증 없이 접근 가능
                .mvcMatchers("/", "/members/**", "/item/**", "/images/**").permitAll() // 특정 URL은 인증 없이 접근 가능
                .mvcMatchers("/admin/**").hasRole("ADMIN") // 특정 URL은 ADMIN 권한을 가진 사용자만 접근 가능
                .anyRequest().authenticated() // 나머지 URL은 인증된 사용자만 접근 가능
        ;

        http.exceptionHandling()
                .authenticationEntryPoint(new CustomAuthenticationEntryPoint()) // 인증되지 않은 사용자가 접근 시도시 이동할 URL
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}



