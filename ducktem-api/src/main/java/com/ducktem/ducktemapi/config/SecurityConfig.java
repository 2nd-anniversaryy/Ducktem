package com.ducktem.ducktemapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.jwt.JwtFilter;
import com.ducktem.ducktemapi.service.MemberService;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final MemberService memberService;
	@Value("${jwt.secret}")
	private String secretKey;

	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


		return http
			.csrf().disable()
			.formLogin().disable()  //formLogin 페이지를 사용하지 않음.
			.httpBasic().disable()  //http 기본 검증을 사용하지 않음. Bearer 사용
			.cors().and()  // cors 설정
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeHttpRequests()
			.requestMatchers("/members/test").authenticated()
			.anyRequest().permitAll()
			.and()
			// username,password로 인증하지않고, token 방식으로 하기위해 JwtFilter를 usernamepassword 필터 이전에 실행.
			.addFilterBefore(new JwtFilter(memberService,secretKey), UsernamePasswordAuthenticationFilter.class)
			.build();
	}
}
