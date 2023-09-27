package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vinicius.condominiopro.repository.VeiculoRepository;
import com.vinicius.condominiopro.veiculo.ListarTodosVeiculos;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoRepository repository;
	
	@GetMapping
	public List<ListarTodosVeiculos> listar(){
		return repository.findAll().stream().map(ListarTodosVeiculos::new).toList();
	}
	
}
