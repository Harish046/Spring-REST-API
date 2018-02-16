package com.github.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import com.github.dao.EmployerDao;
import com.github.domain.Employer;
import com.github.utils.EmployerValidator;
import com.github.utils.ValidationException;

@Service("employerService")
public class EmployerServiceImpl implements EmployerService {
	
	@Autowired
	private EmployerDao employerDao;
	
	@Autowired
	private EmployerValidator employerValidator;
	
	@Transactional
	public void createEmployer(Employer employer, BindingResult result) throws Exception {
		
		employerValidator.validate(employer, result);
		
		if(result.hasErrors())
			throw new ValidationException(result.getFieldErrors());
		
		int erID = employerDao.insertEmployer(employer);
		employer.setErId(erID);;
	}

}
