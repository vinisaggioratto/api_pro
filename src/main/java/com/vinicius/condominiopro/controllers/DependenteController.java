package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.dependentes.DadosCadastrarDependente;
import com.vinicius.condominiopro.dependentes.Dependente;
import com.vinicius.condominiopro.dependentes.ListarTodosDependentes;
import com.vinicius.condominiopro.repository.DependenteRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/dependentes")
public class DependenteController {

	@Autowired
	private DependenteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarDependente dados) {
		repository.save(new Dependente(dados));
	}
	
	@GetMapping
	public List<ListarTodosDependentes> list(){
		return repository.findAll().stream().map(ListarTodosDependentes::new).toList();
	}

}
