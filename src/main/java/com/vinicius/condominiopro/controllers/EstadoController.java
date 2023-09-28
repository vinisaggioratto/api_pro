package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.estado.DadosCadastrarEstado;
import com.vinicius.condominiopro.estado.Estado;
import com.vinicius.condominiopro.estado.ListarTodosEstados;
import com.vinicius.condominiopro.repository.EstadoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarEstado dados) {
		repository.save(new Estado(dados));
	}
	
	@GetMapping
	public List<ListarTodosEstados> listar(){
		return repository.findAll().stream().map(ListarTodosEstados::new).toList();
	}
}
