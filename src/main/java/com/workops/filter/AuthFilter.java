package com.workops.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

public class AuthFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest=(HttpServletRequest)request;
		HttpServletResponse httpResponse=(HttpServletResponse)response;
		String authHeader=httpRequest.getHeader("Authorization");
		if(!httpRequest.getRequestURI().toString().startsWith("/api/signin")&&!httpRequest.getRequestURI().toString().startsWith("/api/signup"))
		{
			if(authHeader==null)
			{
			httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be provided");
            return;
			}
		}
		else
		{
			
			chain.doFilter(httpRequest, httpResponse);
		}
	}

}

