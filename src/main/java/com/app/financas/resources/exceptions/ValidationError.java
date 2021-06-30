package com.app.financas.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{

	
	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError() {
		super();
		
	}

	public ValidationError(List<FieldMessage> erros) {
		super();
		this.erros = erros;
	}

	public List<FieldMessage> getErros() {
		return erros;
	}

	public void addError(String nomeCampo, String message) {
		this.erros.add(new FieldMessage(nomeCampo,message));
	}
	
	
	
	
	
	

}
