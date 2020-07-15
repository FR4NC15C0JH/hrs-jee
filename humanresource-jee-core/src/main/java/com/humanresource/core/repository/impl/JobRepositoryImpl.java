package com.humanresource.core.repository.impl;

import javax.ejb.Stateless;

import com.humanresource.core.model.Job;
import com.humanresource.core.persistence.impl.GenericDAOImpl;
import com.humanresource.core.repository.JobRepository;

@Stateless
@SuppressWarnings("serial")
public class JobRepositoryImpl extends GenericDAOImpl<Job, Long> implements JobRepository{

}
