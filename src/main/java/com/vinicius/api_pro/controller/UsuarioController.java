package com.vinicius.api_pro.controller;

import com.vinicius.api_pro.data.UsuarioEntity;
import com.vinicius.api_pro.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public ResponseEntity<List> getAllUsuarios() {
        List<UsuarioEntity> usuarios = service.listarTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<UsuarioEntity> getUsuarioById(@PathVariable Long id) {
        UsuarioEntity usuario = service.getUsuarioId(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioEntity> addUsuario(@Valid @RequestBody UsuarioEntity usuario) {
        var novoUsuario = service.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioEntity> atualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        var usuarioAtualizado = service.atualizarUsuario(id, usuario);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletarUsuario(@PathVariable Long id) {
        service.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/validar-login")
    public Map<String, Object> getPesquisarPorLoginAndPassword(@RequestBody UsuarioEntity usuario) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        List<UsuarioEntity> usuarios = service.retornarUsuarioList(usuario.getLogin());
        if (usuarios.isEmpty()) {
            return Collections.singletonMap("valido", false);
        } else {
            UsuarioEntity usuarioSalvo = usuarios.get(0);
            String perfil = usuarioSalvo.getPerfil();
            System.out.println("Perfil: " + perfil);
            Map<String, Object> resultado = new HashMap<>();
            resultado.put("valido", passwordEncoder.matches(usuario.getPassword(), usuarioSalvo.getPassword()));
            resultado.put("perfil", perfil);
            return resultado;
        }
    }
}
