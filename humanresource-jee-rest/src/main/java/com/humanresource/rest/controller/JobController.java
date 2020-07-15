package com.humanresource.rest.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.humanresource.core.mapper.JobMapper;
import com.humanresource.core.model.Job;
import com.humanresource.core.model.dto.JobDTO;
import com.humanresource.core.service.JobService;

@Path("job")
public class JobController {
	
	@EJB
	private JobService jobService;
	@Inject
	private JobMapper jobMapper;
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(JobDTO jobDTO) {
		jobService.save(jobMapper.toEntity(jobDTO));
		return Response.ok(201).build(); 
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("id") Long id) {
		jobService.delete(id);
		return Response.ok(201).build(); 
	}
	
	@GET
	@Path("/findBy")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@QueryParam("id") Long id) {
		Job job = jobService.findById(id);
		return Response.ok(jobMapper.toDTO(job)).build(); 
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		List<Job> jobs = jobService.findAll();
		return Response.ok(jobMapper.toDTO(jobs)).build(); 
	}
}
