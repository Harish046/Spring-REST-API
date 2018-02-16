package com.github.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.github.dao.EmployerDao;
import com.github.domain.Employer;

@Component("employerValidator")
public class EmployerValidator implements Validator {
	
	@Autowired
	private EmployerDao employerDao;

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Employer empr = (Employer) target;
		List<Employer> list=null;
		if(!Utils.checkPattren(empr.getMobile(), Constants.MOBILE_REGEX))
			errors.rejectValue("mobile", "mobile", "Invalid Mobile Number");
		if(!Utils.checkPattren(empr.getPassword(), Constants.PWD_SPL_CHAR_REGEX))
			errors.rejectValue("password", "password", "Password must contain atleast 1 special character");
		if(!Utils.checkPattren(empr.getPassword(), Constants.PWD_NUMBER_REGEX))
			errors.rejectValue("password", "password", "Password must contain atleast 1 number");
		if(!Utils.checkPattren(empr.getPassword(), Constants.PWD_UPPER_REGEX))
			errors.rejectValue("password", "password", "Password must contain atleast 1 upper case character");
		if(!Utils.checkPattren(empr.getPassword(), Constants.PWD_LEN_REGEX))
			errors.rejectValue("password", "password", "Minumum password length 8 ");
		if(empr.getEmail()!=""||empr.getEmail()!=null) {
			list = employerDao.checkEmployer(empr.getEmail());
		}
		if(!list.isEmpty()) {
			errors.rejectValue("email", "email", "This Email has already got registered");
		}
	}
	
	
	

}
