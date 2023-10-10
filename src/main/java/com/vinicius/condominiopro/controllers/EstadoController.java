package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.services.EstadoService;
import com.vinicius.condominiopro.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.estado.Estado;
import com.vinicius.condominiopro.repository.EstadoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estados")
@CrossOrigin(origins = "*")
public class EstadoController {

	@Autowired
	private EstadoRepository repository;

	@Autowired
	private EstadoService service;

	@Autowired
	private PaisService paisService;


	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Estado estado) {
		service.salvar(estado);
	}

	@GetMapping
	public List<Estado> listar(){
		List<Estado> estado = service.listar();
		return estado;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Estado dados, @PathVariable Long id) {

		Optional<Estado> estadoExistente = repository.findById(id);
		if (estadoExistente.isPresent()) {
			Estado estado = estadoExistente.get();
			estado.setNome(dados.getNome());
			estado.setPais(paisService.retornarIdPais(dados.getPais().getNome()));

			service.salvar(estado);
			return ResponseEntity.ok("Estado atualizado com sucesso!");
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
