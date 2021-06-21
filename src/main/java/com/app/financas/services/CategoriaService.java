package com.app.financas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.financas.exceptions.ObjectNotFoundException;
import com.app.financas.models.Categoria;
import com.app.financas.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException("Objeto não encontrado! id: "+id+" , Tipo: "+Categoria.class.getName()) ); //retorna o objeto, caso seja encontrado, ou nulo, caso não seja encontrado
	}
	

}
