package com.github.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class ValidationException extends RuntimeException {
	
	/**
	 *generated serial id
	 */
	private static final long serialVersionUID = 7101554112838072820L;
	
	List<FieldErrors> errors = new ArrayList<FieldErrors>();
	
	public ValidationException() {
	}
	public ValidationException(String msg) {
		super(msg);
	}
	public ValidationException(String msg,Throwable throwable) {
		super(msg,throwable);
	}
	public ValidationException(String msg, List<FieldErrors> errors) {
		super(msg);
		this.errors=errors;
	}
	public ValidationException(List<FieldError> fieldErrors) {
		for(FieldError fieldError:fieldErrors) {
			addError(fieldError.getField(), fieldError.getDefaultMessage());
		}
	}
	public List<FieldErrors> getErrors() {
		return this.errors;
	}
	public void addError(String field,String errmsg) {
		this.errors.add(new FieldErrors(field, errmsg));
	}

}
