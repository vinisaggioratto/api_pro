package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.condomino.DadosTotalCondomino;
import com.vinicius.condominiopro.repository.CondominoRepository;

@RestController
@RequestMapping("/condomino")
public class CondominoController {

	@Autowired
	private CondominoRepository repository;
	
	@GetMapping  //vai fazer a leitura e trazer os dados
	public List<DadosTotalCondomino> listar() {
		return repository.findAll().stream().map(DadosTotalCondomino::new).toList();
	}
}
