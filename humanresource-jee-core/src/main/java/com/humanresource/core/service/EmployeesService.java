package com.humanresource.core.service;

import java.util.List;

import javax.ejb.Local;

import com.humanresource.core.model.Employees;

@Local
public interface EmployeesService {
	
	public Employees save(Employees employees);
	public void delete(Long id);
	public Employees findByEmail(String email);
	public Employees findById(Long id);
	public List<Employees> findAll();
}
