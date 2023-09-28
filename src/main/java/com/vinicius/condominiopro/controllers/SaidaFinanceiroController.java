package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.repository.SaidaFinanceiroRepository;
import com.vinicius.condominiopro.saidaFinanceiro.DadosCadastrarSaidaFinanceiro;
import com.vinicius.condominiopro.saidaFinanceiro.ListarTodasSaidaFinanceiro;
import com.vinicius.condominiopro.saidaFinanceiro.SaidaFinanceiro;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/saidasfinanceiro")
public class SaidaFinanceiroController {

	@Autowired
	private SaidaFinanceiroRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarSaidaFinanceiro dados) {
		repository.save(new SaidaFinanceiro(dados));
	}
	
	@GetMapping
	public List<ListarTodasSaidaFinanceiro> listar(){
		return repository.findAll().stream().map(ListarTodasSaidaFinanceiro::new).toList();
	}
}
