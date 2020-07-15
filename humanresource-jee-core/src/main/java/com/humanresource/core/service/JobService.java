package com.humanresource.core.service;

import java.util.List;

import javax.ejb.Local;

import com.humanresource.core.model.Job;

@Local
public interface JobService {
	
	public void save(Job job);
	public void delete(Long id);
	public Job findById(Long id);
	public List<Job> findAll();
}
