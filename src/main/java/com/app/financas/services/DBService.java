package com.app.financas.services;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.financas.enums.TipoEnum;
import com.app.financas.models.Categoria;
import com.app.financas.models.ItemFinanceiro;
import com.app.financas.repositories.CategoriaRepository;
import com.app.financas.repositories.ItemFinanceiroRepository;

@Service
public class DBService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ItemFinanceiroRepository itemFinanceiroRepository;

	
	public void initDados() {

		Categoria c = new Categoria();
		c.setId(1L);
		c.setTipo(TipoEnum.RECEITA);
		c.setDescricao("Salario Mensal");		

		ItemFinanceiro item = new ItemFinanceiro(1L, TipoEnum.RECEITA, Calendar.getInstance(), 3590.28, "salario todo mes", (short) 0,
				(short) 0, c);


		List<ItemFinanceiro> lista = new ArrayList<>();
		lista.add(item);
		
		c.setListaItens(lista);
		categoriaRepository.save(c);
		
		Categoria c2 = new Categoria();		
		c2.setTipo(TipoEnum.DESPESA);
		c2.setDescricao("Gastos Mensais");
		
		categoriaRepository.save(c2);
		
		
		ItemFinanceiro item2 = new ItemFinanceiro(2L, TipoEnum.RECEITA, Calendar.getInstance(), 3590.28, "Conta de Agua", (short) 0,
				(short) 0, c2);
		
		itemFinanceiroRepository.save(item2);
		
		
	}

}
