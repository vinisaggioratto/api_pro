package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.estado.Estado;
import com.vinicius.condominiopro.services.CidadeService;
import com.vinicius.condominiopro.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.cidade.Cidade;
import com.vinicius.condominiopro.cidade.DadosCadastrarCidade;
import com.vinicius.condominiopro.cidade.ListarTodasCidades;
import com.vinicius.condominiopro.repository.CidadeRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cidades")
@CrossOrigin(origins = "*")
public class CidadeController {

	
	@Autowired
	private CidadeRepository repository;

	@Autowired
	private CidadeService service;

	@Autowired
	private EstadoService estadoService;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Cidade dados) {
		service.salvar(dados);
	}
		
	@GetMapping
	public List<Cidade> listar(){
		List<Cidade> cidade = service.listar();
		return  cidade;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Cidade dados, @PathVariable Long id) {

		Optional<Cidade> cidadeExistente = repository.findById(id);
		if (cidadeExistente.isPresent()) {
			Cidade cidade = cidadeExistente.get();
			cidade.setNome(dados.getNome());
			cidade.setEstado(estadoService.retornarIdEstado(cidade.getEstado().getNome()));

			service.salvar(cidade);
			return ResponseEntity.ok("Cidade atualizado com sucesso!");
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
