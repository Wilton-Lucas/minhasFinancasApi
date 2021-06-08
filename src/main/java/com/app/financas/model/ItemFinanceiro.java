package com.app.financas.model;

import com.app.financas.enums.TipoEnum;

public class ItemFinanceiro {

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
	
	
	
	

}
