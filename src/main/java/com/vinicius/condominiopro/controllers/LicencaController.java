package com.vinicius.condominiopro.controllers;

import java.util.List;

import com.vinicius.condominiopro.saidaFinanceiro.SaidaFinanceiro;
import com.vinicius.condominiopro.services.LicencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.licenca.Licenca;
import com.vinicius.condominiopro.repository.LicencaRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/licencas")
@CrossOrigin(origins = "*")
public class LicencaController {

	@Autowired
	private LicencaRepository repository;

	@Autowired
	private LicencaService service;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Licenca dados) {
		service.salvar(dados);
	}

	@GetMapping
	public List<Licenca> listar(){
		return repository.findAll().stream().toList();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Licenca dados, @PathVariable Long id) {

		Licenca licencaExistente = service.buscarPorId(id);
		if (licencaExistente!=null) {

			licencaExistente.setNome(dados.getNome());
			licencaExistente.setDescricao(dados.getDescricao());
			licencaExistente.setNumero(dados.getNumero());
			licencaExistente.setEmissor(dados.getEmissor());
			licencaExistente.setData_emissao(dados.getData_emissao());
			licencaExistente.setData_validade(dados.getData_validade());
			licencaExistente.setValido(dados.getValido());

			service.salvar(licencaExistente);
			return ResponseEntity.ok("Licença atualizada com sucesso!");
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
