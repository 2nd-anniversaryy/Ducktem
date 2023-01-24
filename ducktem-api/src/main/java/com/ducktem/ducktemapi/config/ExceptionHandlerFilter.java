package com.ducktem.ducktemapi.config;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExceptionHandlerFilter extends OncePerRequestFilter {
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {
		try{
			filterChain.doFilter(request, response);
  		}catch (RuntimeException e){
			response.setCharacterEncoding("UTF-8");
			response.setStatus(401);
			response.getWriter().write(e.getLocalizedMessage());
  		}
	}
}
