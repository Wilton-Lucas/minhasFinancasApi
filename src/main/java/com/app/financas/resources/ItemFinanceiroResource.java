package com.app.financas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.financas.dto.ItemFinanceiroDTO;
import com.app.financas.models.ItemFinanceiro;
import com.app.financas.services.ItemFinanceiroService;

@CrossOrigin("*")
@RestController
@RequestMapping("itemFinanceiro")
public class ItemFinanceiroResource {
	
	@Autowired
	ItemFinanceiroService ifService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemFinanceiro> findById(@PathVariable(value="id") Long id){
		ItemFinanceiro item = ifService.findById(id);
		return ResponseEntity.ok().body(item);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemFinanceiroDTO>> findByCategoria(@RequestParam(value="categoria", defaultValue = "0") Long idCategoria){
		List<ItemFinanceiroDTO> listaDTO = ifService.findAllByCategoria(idCategoria).stream()
				.map(obj -> new ItemFinanceiroDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<Void> create(@Valid @RequestBody ItemFinanceiro item, @RequestParam(value="categoria" ,defaultValue="0") Long idCategoria){		
		ifService.save(item, idCategoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").replaceQuery("").buildAndExpand(item.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		ifService.delete(ifService.findById(id));
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemFinanceiro> update(@PathVariable Long id, @Valid @RequestBody ItemFinanceiro item){
		ItemFinanceiro ifatualizado = ifService.update(id, item);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
		return ResponseEntity.created(uri).body(ifatualizado);
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<ItemFinanceiro> updatePatch(@PathVariable Long id, @Valid @RequestBody ItemFinanceiro item){
		ItemFinanceiro ifatualizado = ifService.update(id, item);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().toUri();
		return ResponseEntity.created(uri).body(ifatualizado);
	}

}
