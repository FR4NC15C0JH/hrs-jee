package com.humanresource.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.humanresource.core.model.Job;
import com.humanresource.core.repository.JobRepository;
import com.humanresource.core.service.impl.JobServiceImpl;

public class JobEJBTest extends Mockito{
	
	@Mock
	private EntityManager entityManager;
	@Mock
	private JobRepository jobRepository;
	@InjectMocks
	@EJB
	private JobServiceImpl services;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		 Mockito.reset(entityManager);
	}
	
	@Test
	public void findById() {
		Job jobStub = new Job();
		jobStub.setName("Financeiro");
		when(entityManager.find(Job.class, 2L)).thenReturn(jobStub);
		
		Job nameJob = services.findById(2L);
		assertNotNull("Name: " + nameJob.getName());
	}
	
	@Test
	public void findAll() {
		Job job1 = new Job();
		job1.setName("Analista");
		Job job2 = new Job();
		job2.setName("Contador");
		List<Job> jobs = new ArrayList<>();
		jobs.add(job1);
		jobs.add(job2);
		when(entityManager.createQuery("select j from Job j ", Job.class).getResultList()).thenReturn(jobs);
		//List<Job> jobs = services.findAll();
		assertNotNull(jobs);
	}
}
