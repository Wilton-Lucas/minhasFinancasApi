package com.app.financas.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long timestamp;
	private Integer status;
	private String errorMessage;
	
	public StandardError() {
		
	}	
	
	public StandardError(long timestamp, Integer status, String errorMessage) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.errorMessage = errorMessage;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
