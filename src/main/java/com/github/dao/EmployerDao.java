package com.github.dao;

import java.util.List;

import com.github.domain.Employer;

public interface EmployerDao {
	
	public int insertEmployer(Employer employer) throws Exception;
	
	public List<Employer> checkEmployer(String email);

}
