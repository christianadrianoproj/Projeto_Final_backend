package org.senac.api.WebAPI.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.senac.api.WebAPI.domain.Cliente;
import org.senac.api.WebAPI.repository.ClienteRepository;
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
@RequestMapping("/cliente")
@CrossOrigin(origins="*")
public class ClienteController {
	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	@PostMapping
	public Cliente salvar(@RequestBody @Valid Cliente cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}	
}
