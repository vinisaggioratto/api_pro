package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.repository.CondominoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

	@Autowired
	private CondominoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Condomino dados) {
		repository.save(dados);
	}
	
	@GetMapping  //vai fazer a leitura e trazer os dados
	public List<Condomino> listar() {
		return repository.findAll().stream().toList();
	}
}
