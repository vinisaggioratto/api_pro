package com.vinicius.condominiopro.controllers;

import java.util.List;
import java.util.Optional;

import com.vinicius.condominiopro.services.CondominoService;
import com.vinicius.condominiopro.services.UsuarioService;
import com.vinicius.condominiopro.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.vinicius.condominiopro.repository.UsuarioRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private UsuarioService service;

	@Autowired
	private CondominoService condominoService;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid Usuario dados) {
		service.salvar(dados);
	}
	
	@GetMapping
	public List<Usuario> listar(){
		List<Usuario> usuario = service.listar();
		return usuario;
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<String> atualizar(@Valid @RequestBody Usuario dados, @PathVariable Long id) {

		Optional<Usuario> loginExistente = repository.findById(id);
		if (loginExistente.isPresent()) {
			Usuario usuario = loginExistente.get();
			usuario.setLogin(dados.getLogin());
			usuario.setPassword(dados.getPassword());

			service.salvar(usuario);
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




