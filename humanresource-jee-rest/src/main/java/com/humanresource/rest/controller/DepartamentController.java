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

import com.humanresource.core.mapper.DepartamentMapper;
import com.humanresource.core.model.Departament;
import com.humanresource.core.model.dto.DepartamentDTO;
import com.humanresource.core.service.DepartamentService;

@Path("departament")
public class DepartamentController {
	
	@EJB
	private DepartamentService departamentService;
	@Inject
	private DepartamentMapper departamentMapper;
	
	@POST
	@Path("/save")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(DepartamentDTO departamentDTO) {
		departamentService.save(departamentMapper.toEntity(departamentDTO));
		 return Response.ok(201).build(); 
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(@QueryParam("id") Long id) {
		departamentService.delete(id);
		return Response.ok(201).build(); 
	}
	
	@GET
	@Path("/findBy")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@QueryParam("id") Long id) {
		Departament departament = departamentService.findById(id);
		return Response.ok(departamentMapper.toDTO(departament)).build(); 
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAll() {
		List<Departament> departaments = departamentService.findAll();
		return Response.ok(departamentMapper.toDTO(departaments)).build(); 
	}
}
