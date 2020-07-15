package com.humanresource.core.repository.impl;

import javax.ejb.Stateless;

import com.humanresource.core.model.Departament;
import com.humanresource.core.persistence.impl.GenericDAOImpl;
import com.humanresource.core.repository.DepartamentRepository;

@Stateless
@SuppressWarnings("serial")
public class DepartamentRepositoryImpl extends GenericDAOImpl<Departament, Long> implements DepartamentRepository{

}
