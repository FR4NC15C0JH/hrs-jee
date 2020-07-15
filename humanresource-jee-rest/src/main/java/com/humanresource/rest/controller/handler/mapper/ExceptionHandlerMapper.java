package com.humanresource.rest.controller.handler.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.humanresource.core.model.dto.MessageHandlerDTO;
import com.humanresource.rest.controller.handler.exception.HRSExceptionHandler;

@Provider
public class ExceptionHandlerMapper implements ExceptionMapper<HRSExceptionHandler>{

	@Override
	public Response toResponse(HRSExceptionHandler e) {		
		return Response
	            .status(Response.Status.BAD_REQUEST)
	            .entity(MessageHandlerDTO.build(e.getMensagens()))
	            .build();
	}

}
