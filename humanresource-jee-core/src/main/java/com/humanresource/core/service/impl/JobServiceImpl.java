package com.humanresource.core.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import com.humanresource.core.model.Job;
import com.humanresource.core.repository.JobRepository;
import com.humanresource.core.service.JobService;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class JobServiceImpl implements JobService{
	
	@Inject
	private JobRepository jobRepository;

	@Override
	public void save(Job job) {
		jobRepository.save(job);
	}

	@Override
	public void delete(Long id) {
		jobRepository.deleteById(id);
	}

	@Override
	public Job findById(Long id) {
		return jobRepository.findById(id);
	}

	@Override
	public List<Job> findAll() {
		return jobRepository.findAll();
	}
	
			
}
