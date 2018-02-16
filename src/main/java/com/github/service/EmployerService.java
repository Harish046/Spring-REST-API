package com.github.service;

import org.springframework.validation.BindingResult;

import com.github.domain.Employer;

public interface EmployerService {
	
	public void createEmployer(Employer employer,BindingResult result) throws Exception;

}
