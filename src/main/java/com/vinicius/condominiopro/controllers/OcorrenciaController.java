package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.ocorrencia.DadosCadastrarOcorrencia;
import com.vinicius.condominiopro.ocorrencia.ListarTodasOcorrencias;
import com.vinicius.condominiopro.ocorrencia.Ocorrencia;
import com.vinicius.condominiopro.repository.OcorrenciaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarOcorrencia dados) {
		repository.save(new Ocorrencia(dados));
	}
	
	@GetMapping
	public List<ListarTodasOcorrencias> listar(){
		return repository.findAll().stream().map(ListarTodasOcorrencias::new).toList();
	}
	
}