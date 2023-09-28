package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.cidade.Cidade;
import com.vinicius.condominiopro.cidade.DadosCadastrarCidade;
import com.vinicius.condominiopro.cidade.ListarTodasCidades;
import com.vinicius.condominiopro.repository.CidadeRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	
	@Autowired
	private CidadeRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarCidade dados) {
		repository.save(new Cidade(dados));
	}
		
	@GetMapping
	public List<ListarTodasCidades> listar(){
		return repository.findAll().stream().map(ListarTodasCidades::new).toList();
	}
}
