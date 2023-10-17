package com.vinicius.condominiopro.controllers;

import java.util.List;

import com.vinicius.condominiopro.saidaFinanceiro.SaidaFinanceiro;
import com.vinicius.condominiopro.services.FornecedorService;
import com.vinicius.condominiopro.services.ManutencaoService;
import com.vinicius.condominiopro.sindico.Sindico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.manutencao.Manutencao;
import com.vinicius.condominiopro.repository.ManutencaoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/manutencoes")
@CrossOrigin(origins = "*")
public class ManutencaoController {

	@Autowired
	private ManutencaoRepository repository;

	@Autowired
	private ManutencaoService service;

	@Autowired
	private FornecedorService fornecedorService;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Manutencao dados) {
		dados.setFornecedor(fornecedorService.retornarIdFornecedor(dados.getFornecedor().getNome()));
		service.salvar(dados);
	}

	@GetMapping
	public List<Manutencao> listar(){
		return repository.findAll().stream().toList();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Manutencao dados, @PathVariable Long id) {

		Manutencao manutencaoExistente = service.buscarPorId(id);
		if (manutencaoExistente!=null) {

			manutencaoExistente.setManutencao_nome(dados.getManutencao_nome());
			manutencaoExistente.setManutencao_descricao(dados.getManutencao_descricao());
			manutencaoExistente.setValor(dados.getValor());
			manutencaoExistente.setData_inicial(dados.getData_inicial());
			manutencaoExistente.setData_final(dados.getData_final());
			manutencaoExistente.setFornecedor(fornecedorService.retornarIdFornecedor(dados.getFornecedor().getNome()));

			service.salvar(manutencaoExistente);
			return ResponseEntity.ok("Manutenção atualizada com sucesso!");
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
