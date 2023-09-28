package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.fornecedor.DadosCadastrarFornecedor;
import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.fornecedor.ListarTodosFornecedores;
import com.vinicius.condominiopro.repository.FornecedorRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarFornecedor dados) {
		repository.save(new Fornecedor(dados));
	}
	
	@RequestMapping
	public List<ListarTodosFornecedores> listar(){
		return repository.findAll().stream().map(ListarTodosFornecedores::new).toList();
	}
	
}
