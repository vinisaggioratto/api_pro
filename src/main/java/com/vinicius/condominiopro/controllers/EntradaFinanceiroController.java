package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.EntradaFinanceiroService;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.entradaFinanceiro.EntradaFinanceiro;
import com.vinicius.condominiopro.repository.EntradaFinanceiroRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/entradafinanceiro")
@CrossOrigin(origins = "*")
public class EntradaFinanceiroController {

	@Autowired
	private EntradaFinanceiroService service;
	@Autowired
	private EntradaFinanceiroRepository repository;

	@Autowired
	private CondominoService condominoService;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid EntradaFinanceiro dados) {

		dados.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));

		System.out.println(dados.getCondomino().getNome());
		service.salvar(dados);
	}

	@GetMapping
	public List<EntradaFinanceiro> listar(){

		return repository.findAll().stream().toList();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody	EntradaFinanceiro dados, @PathVariable Long id) {

		Optional<EntradaFinanceiro> entradaFinanceiroExistente = repository.findById(id);
		if (entradaFinanceiroExistente.isPresent()) {
			EntradaFinanceiro entradaFinanceiro = entradaFinanceiroExistente.get();

			entradaFinanceiro.setData_operacao(dados.getData_operacao());
			entradaFinanceiro.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
			entradaFinanceiro.setValor(dados.getValor());
			entradaFinanceiro.setParcelamento(dados.getParcelamento());
			entradaFinanceiro.setDescricao(dados.getDescricao());

			service.salvar(entradaFinanceiro);
			return ResponseEntity.ok("Entrada Financeira atualizada com sucesso!");
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
