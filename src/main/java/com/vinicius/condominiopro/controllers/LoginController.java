package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.cidade.Cidade;
import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.login.Login;
import com.vinicius.condominiopro.repository.LoginRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	private LoginRepository repository;

	@Autowired
	private LoginService service;

	@Autowired
	private CondominoService condominoService;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Login dados) {
		service.salvar(dados);
	}
	
	@GetMapping
	public List<Login> listar(){
		List<Login> login = service.listar();
		return  login;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Login dados, @PathVariable Long id) {

		Optional<Login> loginExistente = repository.findById(id);
		if (loginExistente.isPresent()) {
			Login login = loginExistente.get();
			login.setUsuario(dados.getUsuario());
			login.setSenha(dados.getSenha());
			login.setCondomino(condominoService.retornarIdCondomino(dados.getCondomino().getNome()));

			service.salvar(login);
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
