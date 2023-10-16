package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.entradaFinanceiro.EntradaFinanceiro;
import com.vinicius.condominiopro.services.FornecedorService;
import com.vinicius.condominiopro.services.SaidaFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.repository.SaidaFinanceiroRepository;
import com.vinicius.condominiopro.saidaFinanceiro.SaidaFinanceiro;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/saidasfinanceiro")
@CrossOrigin(origins = "*")
public class SaidaFinanceiroController {

	@Autowired
	private SaidaFinanceiroRepository repository;

	@Autowired
	private SaidaFinanceiroService service;

	@Autowired
	private FornecedorService fornecedorService;

	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid SaidaFinanceiro dados) {

		dados.setFornecedor(fornecedorService.retornarIdFornecedor(dados.getFornecedor().getNome()));

		System.out.println("Saída Financeiro - Nome fornecedor: " + dados.getFornecedor().getNome());
		service.salvar(dados);
	}

	@GetMapping
	public List<SaidaFinanceiro> listar(){
		return repository.findAll().stream().toList();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody	SaidaFinanceiro dados, @PathVariable Long id) {

		SaidaFinanceiro saidaFinanceiroExistente = service.buscarPorId(id);
		if (saidaFinanceiroExistente!=null) {

			saidaFinanceiroExistente.setFornecedor(fornecedorService.retornarIdFornecedor(dados.getFornecedor().getNome()));
			saidaFinanceiroExistente.setDescricao(dados.getDescricao());
			saidaFinanceiroExistente.setData_operacao(dados.getData_operacao());
			saidaFinanceiroExistente.setValor(dados.getValor());
			saidaFinanceiroExistente.setValor(dados.getNota_fiscal());
			saidaFinanceiroExistente.setParcelamento(dados.getParcelamento());

			service.salvar(saidaFinanceiroExistente);
			return ResponseEntity.ok("Saída Financeira atualizada com sucesso!");
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
