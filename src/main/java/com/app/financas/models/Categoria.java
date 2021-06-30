package com.app.financas.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.app.financas.enums.TipoEnum;



@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria")
	private Long id;	
	
	@Enumerated(EnumType.STRING)	
	private TipoEnum tipo;
	
	@NotEmpty(message="Campo DESCRICAO é requerido")
	@Size(min=3, max=100, message="O campo DESCRICAO deve ter entre 3 e 100 caracteres")
	private String descricao;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="categoria")
	private List<ItemFinanceiro> listaItens;
	
	public Categoria() {}
	
	
	
	public Categoria(Long id, TipoEnum tipo, String descricao, List<ItemFinanceiro> listaItens) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descricao = descricao;
		this.listaItens = listaItens;
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


	public List<ItemFinanceiro> getListaItens() {
		return listaItens;
	}



	public void setListaItens(List<ItemFinanceiro> listaItens) {
		this.listaItens = listaItens;
	}
	
	
	
}
