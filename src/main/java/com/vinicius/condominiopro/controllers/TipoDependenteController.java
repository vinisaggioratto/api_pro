package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.repository.TipoDependenteRepository;
import com.vinicius.condominiopro.tipoDependente.DadosCadastrarTipoDependente;
import com.vinicius.condominiopro.tipoDependente.ListarTodosTipoDependente;
import com.vinicius.condominiopro.tipoDependente.TipoDependente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/tipodependentes")
public class TipoDependenteController {

	@Autowired
	private TipoDependenteRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarTipoDependente dados) {
		repository.save(new TipoDependente (dados));
	}
	
	@GetMapping
	public List<ListarTodosTipoDependente> listar(){
		return repository.findAll().stream().map(ListarTodosTipoDependente::new ).toList();
	}
}
