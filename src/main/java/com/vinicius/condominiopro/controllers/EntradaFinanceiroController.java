package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.entradaFinanceiro.DadosCadastrarEntradaFinanceiro;
import com.vinicius.condominiopro.entradaFinanceiro.EntradaFinanceiro;
import com.vinicius.condominiopro.entradaFinanceiro.ListarTodasEntradaFinanceiro;
import com.vinicius.condominiopro.repository.EntradaFinanceiroRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/entradafinanceiro")
public class EntradaFinanceiroController {

	@Autowired
	private EntradaFinanceiroRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarEntradaFinanceiro dados) {
		repository.save(new EntradaFinanceiro(dados));
	}
	
	@GetMapping
	public List<ListarTodasEntradaFinanceiro> listar(){
		return repository.findAll().stream().map(ListarTodasEntradaFinanceiro::new).toList();
	}
}
