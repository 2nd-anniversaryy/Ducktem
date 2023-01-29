package com.ducktem.ducktemapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ducktem.ducktemapi.exception.JwtAuthenticationEntryPoint;
import com.ducktem.ducktemapi.jwt.JwtFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtFilter jwtFilter;

	private final ExceptionHandlerFilter exceptionHandlerFilter;

	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		return http
			.csrf().disable()
			.headers().frameOptions().disable().and() //h2-console 접속을 위해 임시 설정. 추후에 데이터베이스 변경시 삭제 예정
			.formLogin().disable()  //formLogin 페이지를 사용하지 않음.
			.httpBasic().disable()  //http 기본 검증을 사용하지 않음. Bearer 사용
			.cors().and()  // cors 설정
			.exceptionHandling()
			.authenticationEntryPoint(jwtAuthenticationEntryPoint)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeHttpRequests()
			.requestMatchers("/members/me").authenticated()
			.requestMatchers(HttpMethod.PUT,"/members").authenticated()
			.requestMatchers(HttpMethod.POST,"/products").authenticated()
			.requestMatchers("/mypage/**").authenticated()
			.anyRequest().permitAll()
			.and()
			// username,password로 인증하지않고, token 방식으로 하기위해 JwtFilter를 usernamepassword 필터 이전에 실행.
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			.addFilterBefore(exceptionHandlerFilter, JwtFilter.class)
			.build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
