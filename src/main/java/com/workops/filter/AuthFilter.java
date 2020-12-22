package com.workops.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.workops.Constants;
import com.workops.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
@Component
public class AuthFilter extends GenericFilterBean {

	@Autowired
	UserService userservice;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		System.out.println("Filter Called");

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
			else
			{
				String[] authHeaderArr = authHeader.split("Bearer ");

//                System.out.println("Token coming="+authHeaderArr[1]);
	            if(authHeaderArr.length > 1 && authHeaderArr[1] != null) {
	                String token = authHeaderArr[1];
	                if(userservice.checkIfTokenExits(token))
	                {
	                try {
	                	Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY)
	                            .parseClaimsJws(token).getBody();
	                    
	                    httpRequest.setAttribute("email", claims.get("email"));
//	                    System.out.println("intry");

	        			chain.doFilter(httpRequest, httpResponse);
	                    
	                }catch (Exception e) {
	                    httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid/expired token="+e.getMessage());
	                    return;
	                }
	                }
	                else
	                {
	                	 httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Token Does Not Exists");
	 	                return; 	
	                }
	            } else {
	                httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization token must be Bearer");
	                return;
	            }
			}
		}
		else
		{
			System.out.println("Last Else");
			chain.doFilter(httpRequest, httpResponse);
		}
	}

}

