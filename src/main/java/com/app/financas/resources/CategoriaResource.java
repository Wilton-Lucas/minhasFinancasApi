package com.app.financas.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.financas.dto.CategoriaDTO;
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
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		List<Categoria> list = categoriaService.findAll();
		List<CategoriaDTO> listDTO = list.stream().map(e -> new CategoriaDTO(e)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDTO);
	
	} 
	
	//inserir nova categoria
	
	//excluir categoria
	
	// alterar categoria
	
	

}
