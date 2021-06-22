package com.app.financas.services;

import java.util.List;
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
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria save(Categoria categoria) {
		categoria.setId(null);
		return categoriaRepository.save(categoria);
	}
	
	public Categoria delete(Categoria categoria) {		
		categoriaRepository.delete(categoria);
		return categoria;
	}
	
	public Categoria update (Long id, Categoria categoria) {
		categoria.setId(id);
		return categoriaRepository.save(categoria);
	}
	

}
