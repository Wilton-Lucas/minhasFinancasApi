package com.app.financas.enums;

public enum TipoEnum {

		RECEITA(1,"RECEITA"),
		DESPESA(2,"DESPESA");
	
		private int id;
		private String descricao;
		
		TipoEnum(int id, String descricao) {
			this.id = id;
			this.descricao = descricao;
		}
		
		public int getId() {
			return this.id;
			
		}

		public String getDescricao() {
			return this.descricao;
		}
}

