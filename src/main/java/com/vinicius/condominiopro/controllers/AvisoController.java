package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.aviso.Aviso;
import com.vinicius.condominiopro.aviso.DadosCadastrarAviso;
import com.vinicius.condominiopro.aviso.ListarTodosAvisos;
import com.vinicius.condominiopro.repository.AvisoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/avisos")
public class AvisoController {

	@Autowired
	private AvisoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarAviso dados) {
		repository.save(new Aviso(dados));
	}
	
	@GetMapping
	public List<ListarTodosAvisos> listar(){
		return repository.findAll().stream().map(ListarTodosAvisos::new).toList();
	}
}
