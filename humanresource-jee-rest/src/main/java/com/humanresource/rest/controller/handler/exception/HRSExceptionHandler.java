package com.humanresource.rest.controller.handler.exception;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class HRSExceptionHandler extends Exception{

	private static final long serialVersionUID = 4312918465764410000L;
	
	private List<String> messages;
	
	public HRSExceptionHandler() {
		super();
		this.messages = new ArrayList<String>();
	}
	
	public HRSExceptionHandler(String mensagem) {
		super(mensagem);
		messages = new ArrayList<String>();
		messages.add(mensagem);
	}

	public List<String> getMensagens() {
		return messages;
	}

	public void addtMensagens(String mensagem) {
		this.messages.add(mensagem);
	}
}
