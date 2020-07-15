package com.humanresource.core.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.humanresource.core.model.Employees;
import com.humanresource.core.repository.EmployeesRepository;
import com.humanresource.core.service.EmployeesService;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class EmployeesServiceImp implements EmployeesService{
	
	@Inject
	private EmployeesRepository employeesRepository;
	
	@Override
	public Employees save(Employees employees) {
		return employeesRepository.save(employees);
	}

	@Override
	public void delete(Long id) {
		employeesRepository.deleteById(id);
	}

	@Override
	public Employees findByEmail(String email) {
		return employeesRepository.findByEmail(email);
	}

	@Override
	public Employees findById(Long id) {
		return employeesRepository.findById(id);
	}

	@Override
	public List<Employees> findAll() {
		return employeesRepository.findAll();
	}
}
