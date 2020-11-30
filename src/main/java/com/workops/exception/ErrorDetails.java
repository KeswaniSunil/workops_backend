package com.workops.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ErrorDetails  extends Exception{
	
	public ErrorDetails(String message)
	{
		super(message);
	}
	
}
