package com.app.financas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.financas.models.Categoria;
import com.app.financas.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService;
	
	//End point para manipulação de categorias
	
	//consulta por id
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id){
		Categoria c = categoriaService.findById(id);
		return ResponseEntity.ok().body(c);
	}
	
	//listar todos
	
	//inserir nova categoria
	
	//excluir categoria
	
	// alterar categoria
	
	

}
