package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.pais.DadosCadastrarPais;
import com.vinicius.condominiopro.pais.ListarTodosPais;
import com.vinicius.condominiopro.pais.Pais;
import com.vinicius.condominiopro.repository.PaisRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pais")
public class PaisController {

	@Autowired
	private PaisRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarPais dados) {
		repository.save(new Pais(dados));
	}
	
	@GetMapping
	public List<ListarTodosPais> listar(){
		return repository.findAll().stream().map(ListarTodosPais::new).toList();
	}
}
