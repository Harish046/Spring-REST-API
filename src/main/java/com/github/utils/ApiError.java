package com.github.utils;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiError {
	
	private HttpStatus status;
    private String message;
    private List<FieldErrors> errors;
    
    public ApiError(HttpStatus status, String message, List<FieldErrors> errors) {
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<FieldErrors> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldErrors> errors) {
		this.errors = errors;
	}
    

}
