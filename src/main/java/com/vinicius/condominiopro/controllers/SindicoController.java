package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.SindicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.repository.SindicoRepository;
import com.vinicius.condominiopro.sindico.Sindico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sindico")
@CrossOrigin(origins = "*")
public class SindicoController {

	@Autowired
	private SindicoRepository repository;

	@Autowired
	private SindicoService service;

	@Autowired
	private CondominoService condominoService;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Sindico dados) {
		service.salvar(dados);
	}
	
	@GetMapping
	public List<Sindico> listar(){

		return repository.findAll().stream().toList();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody	Sindico dados, @PathVariable Long id) {

		Optional<Sindico> sindicoExistente = repository.findById(id);
		if (sindicoExistente.isPresent()) {
			Sindico sindico = sindicoExistente.get();

			sindico.setData_inicial(dados.getData_inicial());
			sindico.setData_final_prevista(dados.getData_final_prevista());
			sindico.setData_final(dados.getData_final());
			sindico.setNome(dados.getNome());

			sindico.setAtivo(dados.getAtivo());

			service.salvar(sindico);
			return ResponseEntity.ok("Síndico atualizado com sucesso!");
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
