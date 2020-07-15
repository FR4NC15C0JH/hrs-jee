package com.humanresource.core.model.dto;

import java.util.Date;
import java.util.List;

public class MessageHandlerDTO {

	private List<String> messages;
	private Date dateError;

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public Date getDateError() {
		return dateError;
	}

	public void setDateError(Date dateError) {
		this.dateError = dateError;
	}

	public static MessageHandlerDTO build(List<String> mensagens) {
		MessageHandlerDTO messageHandlerDTO = new MessageHandlerDTO();
		messageHandlerDTO.setMessages(mensagens);
		messageHandlerDTO.setDateError(new Date());
		return messageHandlerDTO;
	}
}
