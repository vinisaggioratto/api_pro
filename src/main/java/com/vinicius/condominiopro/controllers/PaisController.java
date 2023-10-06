package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.pais.Pais;
import com.vinicius.condominiopro.repository.PaisRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pais")
@CrossOrigin(origins = "*")
public class PaisController {

	@Autowired
	private PaisRepository repository;

	@Autowired
	private PaisService service;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Pais dados) {
		service.salvar(dados);
	}

	@GetMapping
	public List<Pais> listar(){
		List<Pais> pais = service.listar();
		return pais;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Pais dados, @PathVariable Long id) {

		Optional<Pais> paisExistente = repository.findById(id);
		if (paisExistente.isPresent()) {
			Pais pais = paisExistente.get();
			pais.setNome(dados.getNome());
			service.salvar(pais);
			return ResponseEntity.ok("País atualizado com sucesso!");
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
