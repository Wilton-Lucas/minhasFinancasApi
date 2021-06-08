package com.app.financas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.app.financas.enums.TipoEnum;

@Entity
public class ItemFinanceiro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private TipoEnum tipo;
	private Double valor;
	private Categoria categoria;
	private short qtdParcelas;
	private short parcelaAtual;
	
	
	
	
	public ItemFinanceiro(long id, TipoEnum tipo, Double valor, Categoria categoria, short qtdParcelas, short parcelaAtual) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.categoria = categoria;
		this.qtdParcelas = qtdParcelas;
		this.parcelaAtual = parcelaAtual;
	}
	
	public ItemFinanceiro() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
