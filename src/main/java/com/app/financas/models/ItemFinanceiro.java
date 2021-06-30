package com.app.financas.models;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.app.financas.enums.TipoEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class ItemFinanceiro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_item_financeiro")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoEnum tipo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", columnDefinition = "DATE")
	private Calendar data;
	
	
	@Column
	private Double valor;	
	
	@NotEmpty(message="campo DESCRICAO deve ser preenchido")
	@Size(min=3, max=200, message="Campo descricao deve ter entre 3 e 200 caracteres")
	private String descricao;
	
	
	private short qtdParcelas;
	private short parcelaAtual;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	
	
	

	public ItemFinanceiro(Long id, TipoEnum tipo, Calendar data, Double valor, String descricao, short qtdParcelas,
			short parcelaAtual, Categoria categoria) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.data = data;
		this.valor = valor;
		this.descricao = descricao;
		this.qtdParcelas = qtdParcelas;
		this.parcelaAtual = parcelaAtual;
		this.categoria = categoria;
	}

	public ItemFinanceiro() {
		
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public short getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(short qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	public short getParcelaAtual() {
		return parcelaAtual;
	}
	public void setParcelaAtual(short parcelaAtual) {
		this.parcelaAtual = parcelaAtual;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemFinanceiro other = (ItemFinanceiro) obj;
		if (id != other.id)
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}
	
	
	
	

}
