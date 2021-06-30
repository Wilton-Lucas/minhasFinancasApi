package com.app.financas.resources.exceptions;

import java.io.Serializable;

public class FieldMessage  implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private String nomeCampo;
	private String message;
	
	
	
	public FieldMessage(String nomeCampo, String message) {
		super();
		this.nomeCampo = nomeCampo;
		this.message = message;
	}
	public String getNomeCampo() {
		return nomeCampo;
	}
	public void setNomeCampo(String nomeCampo) {
		this.nomeCampo = nomeCampo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
