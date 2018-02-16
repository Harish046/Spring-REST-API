package com.github.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcCallOperations;
import org.springframework.stereotype.Repository;

import com.github.domain.Employer;

@Repository("employerDao")
public class EmployerDaoImpl implements EmployerDao {
	
	@Autowired
	DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@SuppressWarnings("unchecked")
	public int insertEmployer(Employer employer) throws Exception {
		// TODO Auto-generated method stub
		SimpleJdbcCall jdbcCall=new SimpleJdbcCall(dataSource)
				.withFunctionName("ADD_EMPLOYER")
				.withSchemaName("public")
				.withReturnValue();
		SqlParameterSource param = new MapSqlParameterSource()
		 		.addValue("str_companyname", employer.getCompanyName())
				.addValue("str_address1", employer.getAddress1())
				.addValue("str_address2", employer.getAddress2())
				.addValue("str_city", employer.getCity())
				.addValue("str_stat", employer.getState())
				.addValue("str_postcode", employer.getPostcode())
				.addValue("str_email", employer.getEmail())
				.addValue("str_mobile", employer.getMobile())
				.addValue("str_pwd", employer.getPassword());
		
		Map<String , Object> m=jdbcCall.execute(param);	
		return (Integer) m.get("returnvalue");
	}
	
	@SuppressWarnings("unchecked")
	public List<Employer> checkEmployer(String email) {
		List<Employer> list=new ArrayList<Employer>();
		SimpleJdbcCallOperations jdbcCall=new SimpleJdbcCall(dataSource)
				.withFunctionName("checkemail")
				.withSchemaName("public")
				.withReturnValue();


		SqlParameterSource param=new MapSqlParameterSource()
				.addValue("STR_EMAIL", email);
		
		Map<String , Object> m=jdbcCall.execute(param);
		boolean record=isResultSetEmpty(m,"str_erid");
		if(!record) {
			Employer empr=new Employer();
			empr.setErId(Integer.parseInt(m.get("str_erid").toString()));
			empr.setEmail(m.get("str_email").toString());
			list.add(empr);
		}
		return list;
	}
	private boolean isResultSetEmpty(Map<String, ?> map, String key) {
	    Object value = map.get(key);
	    return value == null ? true : false;
	}

}
