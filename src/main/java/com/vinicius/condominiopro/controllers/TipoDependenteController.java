package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.pais.Pais;
import com.vinicius.condominiopro.services.TipoDependenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.repository.TipoDependenteRepository;
import com.vinicius.condominiopro.tipoDependente.TipoDependente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipodependentes")
@CrossOrigin(origins = "*")
public class TipoDependenteController {

	@Autowired
	private TipoDependenteRepository repository;

	@Autowired
	private TipoDependenteService service;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid TipoDependente dados) {
		service.salvar(dados);
	}

	@GetMapping
	public List<TipoDependente> listar(){
		List<TipoDependente> tipoDependentes = service.listar();
		return tipoDependentes;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody TipoDependente dados, @PathVariable Long id) {

		Optional<TipoDependente> tipoDependenteExistente = repository.findById(id);
		if (tipoDependenteExistente.isPresent()) {
			TipoDependente tipoDependente = tipoDependenteExistente.get();
			tipoDependente.setDescricao(dados.getDescricao());
			service.salvar(tipoDependente);
			return ResponseEntity.ok("Tipo de dependente atualizado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		service.deletar(id);
	}
}
