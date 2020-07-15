package com.humanresource.core.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.humanresource.core.model.Departament;
import com.humanresource.core.repository.DepartamentRepository;
import com.humanresource.core.service.DepartamentService;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class DepartamentServiceImpl implements DepartamentService{
	
	@Inject
	private DepartamentRepository departamentRepository;
	
	@Override
	public void save(Departament departament) {
		departamentRepository.save(departament);
	}

	@Override
	public void delete(Long id) {
		departamentRepository.deleteById(id);
	}

	@Override
	public Departament findById(Long id) {
		return departamentRepository.findById(id);
	}

	@Override
	public List<Departament> findAll() {
		return departamentRepository.findAll();
	}
	
	
	
			
}
