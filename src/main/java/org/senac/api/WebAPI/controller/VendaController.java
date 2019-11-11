package org.senac.api.WebAPI.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.senac.api.WebAPI.domain.Venda;
import org.senac.api.WebAPI.repository.VendaRepository;
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
@RequestMapping("/venda")
@CrossOrigin(origins="*")
public class VendaController {
	@Autowired
	private VendaRepository repository;
	
	@GetMapping
	public List<Venda> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Venda salvar(@RequestBody @Valid Venda venda) {
		return repository.save(venda);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Venda> venda = repository.findById(id);
		if (venda.isPresent()) {
			return ResponseEntity.ok(venda.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}	
}
