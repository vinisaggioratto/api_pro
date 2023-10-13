package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.dependentes.Dependente;
import com.vinicius.condominiopro.estado.Estado;
import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.vinicius.condominiopro.repository.VeiculoRepository;
import com.vinicius.condominiopro.veiculo.Veiculo;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService service;
	@Autowired
	private VeiculoRepository repository;
	@Autowired
	private CondominoService condominoService;


	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Veiculo dados) {

		dados.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
		service.salvar(dados);
	}
	@GetMapping
	public List<Veiculo> list() {
		return repository.findAll().stream().toList();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Veiculo dados, @PathVariable Long id) {

		Optional<Veiculo> veiculoExistente = repository.findById(id);
		if (veiculoExistente.isPresent()) {
			Veiculo veiculo = veiculoExistente.get();
			veiculo.setPlaca(dados.getPlaca());
			veiculo.setMarca(dados.getMarca());
			veiculo.setCor(dados.getCor());
			veiculo.setAtivo(dados.getAtivo());
			veiculo.setModelo(dados.getModelo());
			veiculo.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));

			service.salvar(veiculo);
			return ResponseEntity.ok("Veículo atualizado com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		service.deletar(id);
	}
	
}
