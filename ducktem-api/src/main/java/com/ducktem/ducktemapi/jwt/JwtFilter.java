package com.ducktem.ducktemapi.jwt;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ducktem.ducktemapi.entity.Member;
import com.ducktem.ducktemapi.service.MemberService;

import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final MemberService memberService;

	private final String secretKey;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		String authorization = request.getHeader(HttpHeaders.AUTHORIZATION);

		// 토큰이 없거나 잘못된 토큰은 거부
		if(authorization == null || !authorization.startsWith("Bearer ")) {
			filterChain.doFilter(request,response);
			return;
		}
		// Token 꺼내기
		String token = authorization.split(" ")[1];
		System.out.println(token);
		//토큰 유효시간 검사
		Boolean isExpired = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration().before(new Date());
		if(isExpired) {
			filterChain.doFilter(request,response);
			return;
		}


		//UserName Token에서 꺼내기
		String userId = Jwts.parser()
			.setSigningKey(secretKey)
			.parseClaimsJws(token)
			.getBody()
			.get("userId", String.class);
		Member member = memberService.get(userId);
		String member_ = null;
		if(member != null) {
			member_ = member.getUserId();

			if(member_.equals(userId)) {
				// 권한 부여
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userId,
					null, List.of(new SimpleGrantedAuthority("ROLE_MEMBER")));
				// userDetail 작성
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}

		filterChain.doFilter(request,response);
	}
}
