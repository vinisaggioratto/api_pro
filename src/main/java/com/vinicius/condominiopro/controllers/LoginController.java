package com.vinicius.condominiopro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vinicius.condominiopro.login.DadosCadastrarLogin;
import com.vinicius.condominiopro.login.ListarTodosLogin;
import com.vinicius.condominiopro.login.Login;
import com.vinicius.condominiopro.repository.LoginRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastrarLogin dados) {
		repository.save(new Login(dados));
	}
	
	@GetMapping
	public List<ListarTodosLogin> listar(){
		return repository.findAll().stream().map(ListarTodosLogin::new).toList();
	}
}
