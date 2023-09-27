package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.apartamento.Apartamento;
import com.vinicius.condominiopro.apartamento.DadosCadastrarApartamento;
import com.vinicius.condominiopro.apartamento.ListarTodosApartamentos;
import com.vinicius.condominiopro.repository.ApartamentoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/apartamentos")
public class ApartamentoController {

	@Autowired
	private ApartamentoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarApartamento dados) {
		repository.save(new Apartamento(dados));
	}
	
	
	@GetMapping
	public List<ListarTodosApartamentos> listar(){
		return repository.findAll().stream().map(ListarTodosApartamentos::new).toList();
	}
}
