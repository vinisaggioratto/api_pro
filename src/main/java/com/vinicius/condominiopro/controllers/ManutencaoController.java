package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.manutencao.DadosCadastrarManutencao;
import com.vinicius.condominiopro.manutencao.ListarTodasManutencoes;
import com.vinicius.condominiopro.manutencao.Manutencao;
import com.vinicius.condominiopro.repository.ManutencaoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/manutencoes")
public class ManutencaoController {

	@Autowired
	private ManutencaoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarManutencao dados) {
		repository.save(new Manutencao(dados));
	}
	
	@GetMapping
	public List<ListarTodasManutencoes> listar(){
		return repository.findAll().stream().map(ListarTodasManutencoes::new).toList();
	}
}
