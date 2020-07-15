package com.humanresource.core.repository.impl;

import javax.ejb.Stateless;

import com.humanresource.core.model.Employees;
import com.humanresource.core.persistence.impl.GenericDAOImpl;
import com.humanresource.core.repository.EmployeesRepository;

@Stateless
@SuppressWarnings("serial")
public class EmployeesRepositoryImpl extends GenericDAOImpl<Employees, Long> implements EmployeesRepository{
	
	private static StringBuilder QUERY = new StringBuilder();
	
	static {
		QUERY
		.append("Select e from Employees e")
		.append("where e.email = :email ");
	}
	
	
	@Override
	public Employees findByEmail(String email) {
		return (Employees) this.createQuery(QUERY.toString())
				.setParameter("email", email)
				.getSingleResult();
	}

}
