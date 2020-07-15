package com.humanresource.core.service;

import java.util.List;

import javax.ejb.Local;

import com.humanresource.core.model.Departament;

@Local
public interface DepartamentService {
	
	public void save(Departament departament);
	public void delete(Long id);
	public Departament findById(Long id);
	public List<Departament> findAll();
}
