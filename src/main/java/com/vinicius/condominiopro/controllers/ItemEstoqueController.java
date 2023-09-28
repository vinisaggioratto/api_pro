package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.itemEstoque.DadosCadastrarItemEstoque;
import com.vinicius.condominiopro.itemEstoque.ItemEstoque;
import com.vinicius.condominiopro.itemEstoque.ListarTodosItemEstoque;
import com.vinicius.condominiopro.repository.ItemEstoqueRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/itensestoque")
public class ItemEstoqueController {

	@Autowired
	private ItemEstoqueRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarItemEstoque dados) {
		repository.save(new ItemEstoque(dados));
	}
	
	@GetMapping
	public List<ListarTodosItemEstoque> listar(){
		return repository.findAll().stream().map(ListarTodosItemEstoque::new).toList();
	}
	
}
