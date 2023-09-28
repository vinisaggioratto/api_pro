package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.condominoApartamento.CondominoApartamento;
import com.vinicius.condominiopro.condominoApartamento.DadosCadastrarCondominoApartamento;
import com.vinicius.condominiopro.condominoApartamento.ListarTodosCondominoApartamento;
import com.vinicius.condominiopro.repository.CondominoApartamentoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ocupacao")
public class CondominoApartamentoController {

	@Autowired
	private CondominoApartamentoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarCondominoApartamento dados) {
		repository.save(new CondominoApartamento(dados));
	}
	
	
	@GetMapping
	public List<ListarTodosCondominoApartamento> list(){
		return repository.findAll().stream().map(ListarTodosCondominoApartamento::new).toList();
	}
}
