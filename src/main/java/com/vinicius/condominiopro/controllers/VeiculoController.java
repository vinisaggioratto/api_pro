package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vinicius.condominiopro.repository.VeiculoRepository;
import com.vinicius.condominiopro.veiculo.DadosCadastrarVeiculo;
import com.vinicius.condominiopro.veiculo.ListarTodosVeiculos;
import com.vinicius.condominiopro.veiculo.Veiculo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarVeiculo dados) {
		repository.save(new Veiculo(dados));
	}
	
	@GetMapping
	public List<ListarTodosVeiculos> listar(){
		return repository.findAll().stream().map(ListarTodosVeiculos::new).toList();
	}
	
}
