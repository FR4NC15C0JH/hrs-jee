package com.humanresource.core.repository;

import com.humanresource.core.model.Employees;
import com.humanresource.core.persistence.GenericDAO;

public interface EmployeesRepository extends GenericDAO<Employees, Long>{
	
	public Employees findByEmail(String email);
}
