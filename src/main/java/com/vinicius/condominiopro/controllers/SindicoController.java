package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.repository.SindicoRepository;
import com.vinicius.condominiopro.sindico.DadosCadastrarSindico;
import com.vinicius.condominiopro.sindico.ListarTodosSindicos;
import com.vinicius.condominiopro.sindico.Sindico;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/sindico")
public class SindicoController {

	@Autowired
	private SindicoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarSindico dados) {
		repository.save(new Sindico(dados));
	}
	
	@GetMapping
	public List<ListarTodosSindicos> listar(){
		return repository.findAll().stream().map(ListarTodosSindicos::new).toList();
	}
}
