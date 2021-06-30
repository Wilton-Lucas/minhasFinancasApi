package com.app.financas.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.financas.exceptions.ObjectNotFoundException;
import com.app.financas.models.Categoria;
import com.app.financas.models.ItemFinanceiro;
import com.app.financas.repositories.ItemFinanceiroRepository;

@Service
public class ItemFinanceiroService {

	@Autowired
	ItemFinanceiroRepository itemFinanceiroRepository;
	
	@Autowired
	CategoriaService categoriaService;

	public ItemFinanceiro findById(Long id) {

		Optional<ItemFinanceiro> optional = itemFinanceiroRepository.findById(id);
		return optional.orElseThrow(() -> new ObjectNotFoundException("Livro de id: " + id + " não foi encontrado!"));

	}

	public List<ItemFinanceiro> findAllByCategoria(Long idCategoria) {
		Categoria c = categoriaService.findById(idCategoria);
		return itemFinanceiroRepository.findAllByCategoria(idCategoria);
		
	}
	
	public ItemFinanceiro save(ItemFinanceiro item, Long idCategoria) {
		item.setId(null);
		item.setData(Calendar.getInstance());
		Categoria c = categoriaService.findById(idCategoria);
		item.setCategoria(c);
		return itemFinanceiroRepository.save(item);
	}
	
	public ItemFinanceiro delete (ItemFinanceiro item) {
		itemFinanceiroRepository.delete(item);
		return item;
	}
	
	public ItemFinanceiro update (Long id, ItemFinanceiro item) {
		item.setId(id);		
		return itemFinanceiroRepository.save(item);
	}
	
	

}
