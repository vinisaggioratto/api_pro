package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.entradaEstoque.DadosCadastrarEntradaEstoque;
import com.vinicius.condominiopro.entradaEstoque.EntradaEstoque;
import com.vinicius.condominiopro.entradaEstoque.ListarTodasEntradaEstoque;
import com.vinicius.condominiopro.repository.EntradaEstoqueRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/entradaestoque")
public class EntradaEstoqueController {

	@Autowired
	private EntradaEstoqueRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarEntradaEstoque dados) {
		repository.save(new EntradaEstoque(dados));
	}
	
	@GetMapping
	public List<ListarTodasEntradaEstoque> list(){
		return repository.findAll().stream().map(ListarTodasEntradaEstoque::new).toList();
	}
}
