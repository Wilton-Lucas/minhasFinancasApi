package com.app.financas.dto;

import java.io.Serializable;
import java.util.Calendar;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.app.financas.enums.TipoEnum;
import com.app.financas.models.ItemFinanceiro;

public class ItemFinanceiroDTO implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private long id;	
	private TipoEnum tipo;	
	private Calendar data;
	@NotEmpty(message="campo VALOR deve ser preenchido")
	private Double valor;	
	@NotEmpty(message="Campo DESCRICAO deve ser preenchido")
	@Size(min=3, max=200, message="Campo deve ter entre 3 e 200 caracteres")
	private String descricao;
	
	@NotBlank(message="Campo qtdParcelas deve ser preenchido")
	@Min(value=1, message="Quantidade de parcelas deve ter o valor minimo igual a 1")
	private short qtdParcelas;
	private short parcelaAtual;
	
	
	
	public ItemFinanceiroDTO(ItemFinanceiro obj) {
		super();
		this.id = obj.getId();
		this.tipo = obj.getTipo();
		this.data = obj.getData();
		this.valor = obj.getValor();
		this.descricao = obj.getDescricao();
		this.qtdParcelas = obj.getQtdParcelas();
		this.parcelaAtual = obj.getParcelaAtual();
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
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
