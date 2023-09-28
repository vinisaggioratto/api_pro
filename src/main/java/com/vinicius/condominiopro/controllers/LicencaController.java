package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.licenca.DadosCadastrarLicenca;
import com.vinicius.condominiopro.licenca.Licenca;
import com.vinicius.condominiopro.licenca.ListarTodasLicencas;
import com.vinicius.condominiopro.repository.LicencaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/licencas")
public class LicencaController {

	@Autowired
	private LicencaRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarLicenca dados) {
		repository.save(new Licenca(dados));
	}
	
	@GetMapping
	public List<ListarTodasLicencas> listar(){
		return repository.findAll().stream().map(ListarTodasLicencas::new).toList();
	}
}
