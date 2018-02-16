package com.github.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.domain.Employer;
import com.github.service.EmployerService;
import com.github.utils.ApiError;
import com.github.utils.Constants;
import com.github.utils.ValidationException;



@RestController
@RequestMapping(value=Constants.API_URI)
public class EmployerController {
	
	@Autowired
	private EmployerService employerService;
	
	@RequestMapping(value="/employers",method=RequestMethod.POST,consumes= {Constants.API_JSON_FORMAT},produces= {Constants.API_JSON_FORMAT})
	public ResponseEntity<?> createEmployer(@Valid @RequestBody Employer employer,BindingResult result,HttpServletRequest request) throws Exception
	{
		try {
			employerService.createEmployer(employer, result);
			
		} catch(ValidationException vexe) {
			ApiError error=new ApiError(HttpStatus.BAD_REQUEST, "Invalid Input", vexe.getErrors());
			return new ResponseEntity<ApiError>(error,error.getStatus());
		}catch(Exception exception)	{
			throw exception;
		}
		return new ResponseEntity<Employer>(employer, HttpStatus.OK);
		
	}

}
