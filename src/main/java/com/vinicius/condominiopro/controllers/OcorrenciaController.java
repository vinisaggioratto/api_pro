package com.vinicius.condominiopro.controllers;

import java.util.List;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.OcorrenciaService;
import com.vinicius.condominiopro.services.SindicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.ocorrencia.Ocorrencia;
import com.vinicius.condominiopro.repository.OcorrenciaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/ocorrencias")
@CrossOrigin(origins = "*")
public class OcorrenciaController {

	@Autowired
	private OcorrenciaRepository repository;
	@Autowired
	private OcorrenciaService service;
	@Autowired
	private SindicoService sindicoService;
	@Autowired
	private CondominoService condominoService;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Ocorrencia dados) {

		dados.setSindico(sindicoService.buscarPorNome(dados.getSindico().getNome()));
		dados.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
		service.salvar(dados);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Ocorrencia dados, @PathVariable Long id) {

		Ocorrencia ocorrenciaExistente = service.buscarPorId(dados.getId());

		if (ocorrenciaExistente != null) {
			ocorrenciaExistente.setNome(dados.getNome());
			ocorrenciaExistente.setDescricao(dados.getDescricao());
			ocorrenciaExistente.setData_ocorrencia(dados.getData_ocorrencia());
			ocorrenciaExistente.setSindico(sindicoService.buscarPorNome(dados.getSindico().getNome()));
			ocorrenciaExistente.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));
			service.salvar(ocorrenciaExistente);
			return ResponseEntity.ok("Ocorrência atualizada com sucesso!");
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<Ocorrencia> listar(){
		List<Ocorrencia> ocorrencias = service.listar();
		return ocorrencias;
	}

	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id){
		service.excluir(id);
	}
	
}
