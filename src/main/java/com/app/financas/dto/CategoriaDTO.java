package com.app.financas.dto;

import java.io.Serializable;

import com.app.financas.enums.TipoEnum;
import com.app.financas.models.Categoria;


public class CategoriaDTO implements Serializable {
	
	private static final long serailVersionUID = 1L;
	
	
	private Long id;	
	private TipoEnum tipo;
	private String descricao;
	
	
	public CategoriaDTO(Categoria obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.descricao = obj.getDescricao();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TipoEnum getTipo() {
		return tipo;
	}
	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerailversionuid() {
		return serailVersionUID;
	}
	
	
	
	

}
