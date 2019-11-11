package org.senac.api.WebAPI.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.senac.api.WebAPI.domain.Produto;
import org.senac.api.WebAPI.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* @author Christian
*/

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins="*")
public class ProdutoController {
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public List<Produto> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Produto salvar(@RequestBody @Valid Produto produto) {
		return repository.save(produto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Produto> produto = repository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}	
}
