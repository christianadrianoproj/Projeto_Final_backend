package org.senac.api.WebAPI.controller;

import java.util.List;
import java.util.Optional;

import org.senac.api.WebAPI.domain.VendaItem;
import org.senac.api.WebAPI.repository.VendaItemRepository;
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
@CrossOrigin(origins = "*")
public class VendaController {
	@Autowired
	private VendaRepository repository;

	@Autowired
	private VendaItemRepository repositoryVendaItem;

	@GetMapping
	public List<Venda> findAll() {
		return repository.findAll();
	}

	@PostMapping("/cancelaVendaIniciada/{idvenda}")
	public void cancelaVendaIniciada(@PathVariable("idvenda") Integer idvenda) {
		Venda venda = repository.findById(idvenda).get();
		if (venda.getCliente() == null) {
			repository.deleteById(idvenda);
		}
	}

	@PostMapping("/atualizaCliente")
	public Venda atualizaCliente(@RequestBody Venda venda) {
		Venda v = repository.findById(venda.getIdVenda()).get();
		if (v.getCliente() != null) {
			if (venda.getCliente().getIdCliente() != v.getCliente().getIdCliente()) {

				return repository.save(venda);
			} else {
				return venda;
			}
		} else {
			if (venda.getCliente() != null) {
				return repository.save(venda);
			} else {
				return venda;
			}
		}
	}

	@PostMapping("/salvaVenda")
	public Venda salvaVenda(@RequestBody Venda venda) {
		return repository.save(venda);
	}

	@PostMapping("/adicionaItem/{idvenda}")
	public Venda adicionaItem(@PathVariable("idvenda") Integer idvenda, @RequestBody VendaItem item) {
		Venda venda = repository.findById(idvenda).get();
		item.setVenda(venda);
		repositoryVendaItem.save(item);
		return venda;
	}

	@PostMapping("/deleteItem/{idvenda}")
	public Venda deleteItem(@PathVariable("idvenda") Integer idvenda, @RequestBody VendaItem item) {
		repositoryVendaItem.deleteById(item.getIdVendaItem());
		return repository.findById(idvenda).get();
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
		Venda venda = repository.findById(id).get();
		for (VendaItem i : venda.getItens()) {
			repositoryVendaItem.deleteById(i.getIdVendaItem());
		}
		repository.deleteById(id);
	}
}
