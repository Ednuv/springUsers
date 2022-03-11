package com.example.springUsers.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.springUsers.services.UserDetailsServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class jwtAuthenticationFilter extends OncePerRequestFilter{
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private JwtUtils jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print(request.getHeader("Authorization"));
		final String requestTokenHeader = request.getHeader("Authorization");
		System.out.println(requestTokenHeader);
		String username= null;
		String jwtToken = null;
		
		if(requestTokenHeader!= null && requestTokenHeader.startsWith("Bearer "))
		{
			jwtToken = requestTokenHeader.substring(7);
			
			try {
				System.out.println(jwtToken);
				username = this.jwtUtil.extractUsername(jwtToken);
				System.out.println(username);
				
			}catch(ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("jwt token has expired");
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("error");
			}
		}else {
			System.out.println("Invalid Token, not start with Bearer");
		}
		if(username!= null && SecurityContextHolder.getContext().getAuthentication()==null) {
			final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
			if(this.jwtUtil.validateToken(jwtToken, userDetails)) {
				System.out.print("greats");
				UsernamePasswordAuthenticationToken usernamePasswordAuthentication =new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				System.out.print(usernamePasswordAuthentication);
				usernamePasswordAuthentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthentication);
			}
		}else {
			System.out.println("Token is not valid");
		}
		filterChain.doFilter(request, response);
	}

}
