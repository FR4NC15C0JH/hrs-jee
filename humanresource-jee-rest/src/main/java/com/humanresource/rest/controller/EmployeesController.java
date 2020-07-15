package com.humanresource.rest.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.humanresource.core.mapper.EmployeesMapper;
import com.humanresource.core.model.Employees;
import com.humanresource.core.model.dto.EmployeesDTO;
import com.humanresource.core.service.EmployeesService;

@Path("employees")
public class EmployeesController {
	
	@EJB
	private EmployeesService employeesService;
	/*
	 * @EJB private ResourceConverterSupport converterSupport;
	 */
	@Inject
	private EmployeesMapper employeesMapper;
	/*
	 * 
	 * 
	 * public EmployeesController(EmployeesMapper employeesMapper) {
	 * this.employeesMapper = employeesMapper; }
	 */
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(EmployeesDTO employeesDTO) {
		employeesService.save(employeesMapper.toEntity(employeesDTO));
		 return Response.ok(201).build(); 
	}
	
	@GET
	@Path("/findBy")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@QueryParam("id") Long id) {
		Employees employees = employeesService.findById(id);
//		EmployeesDTO employeeDTO = converterSupport.copy(employees, EmployeesDTO.class);
		 return Response.ok(employeesMapper.toDTO(employees)).build(); 
		/* return Response.ok(employees).build(); */
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		List<Employees> employees = employeesService.findAll();
		 return Response.ok(employeesMapper.toDTO(employees)).build(); 
	}
}
