package com.vinicius.condominiopro.controllers;

import java.util.List;

import com.vinicius.condominiopro.dependentes.Dependente;
import com.vinicius.condominiopro.services.CondominoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.repository.CondominoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/condomino")
@CrossOrigin(origins = "*")
public class CondominoController {

	@Autowired
	private CondominoRepository repository;
	@Autowired
	private CondominoService service;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Condomino dados) {
		service.salvar(dados);
	}
	
	@GetMapping  //vai fazer a leitura e trazer os dados
	public List<Condomino> listar() {
		List<Condomino> condomino = service.listar();
		return condomino;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Condomino dados, @PathVariable Long id) {

		Condomino condominoExistente = repository.findByCpf(dados.getCpf());

		if (condominoExistente != null) {
			condominoExistente.setNome(dados.getNome());
			condominoExistente.setRg(dados.getRg());
			condominoExistente.setTelefone_celular(dados.getTelefone_celular());
			condominoExistente.setProprietario(dados.getProprietario());
			condominoExistente.setMorador(dados.getMorador());
			service.salvar(condominoExistente);
			return ResponseEntity.ok("Condômino atualizado com sucesso!");
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
