package com.app.financas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Categoria> create(@RequestBody Categoria categoria){
		categoria = categoriaService.save(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	//excluir categoria
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaService.delete(categoriaService.findById(id));
		return ResponseEntity.noContent().build();
		
		
	}
	
	// alterar categoria
	@PutMapping(value="/{id}")
	public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria){
		categoria = categoriaService.update(id, categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
		return ResponseEntity.created(uri).body(categoria);
	}
	
	

}
