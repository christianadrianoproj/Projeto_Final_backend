package org.senac.api.WebAPI.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.senac.api.WebAPI.domain.Login;
import org.senac.api.WebAPI.repository.LoginRepository;
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
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {
	@Autowired
	private LoginRepository repository;

	@GetMapping
	public List<Login> findAll() {
		return repository.findAll();
	}

	@PostMapping
	public Login salvar(@RequestBody @Valid Login login) {
		return repository.save(login);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> find(@PathVariable("id") Integer id) {
		Optional<Login> login = repository.findById(id);
		if (login.isPresent()) {
			return ResponseEntity.ok(login.get());
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/autentica")
	public String validaLogin(@RequestBody Login login) {
		String retorno = "erro!";
		List<Login> lista = repository.findAll();
		for (Login l : lista) {
			if (l.getLogin().equalsIgnoreCase(login.getLogin())) {
				if (l.getSenha().equals(login.getSenha())) {
					retorno = "sucesso!";
				} else {
					retorno = "senha inválida!";
				}
				break;
			} else {
				retorno = "login Inválido!";
			}
		}
		return retorno;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		repository.deleteById(id);
	}

}
