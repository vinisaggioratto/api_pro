package com.vinicius.condominiopro.controllers;

import com.vinicius.condominiopro.repository.UsuarioRepository;
import com.vinicius.condominiopro.usuario.AuthenticationDTO;
import com.vinicius.condominiopro.usuario.RegisterDTO;
import com.vinicius.condominiopro.usuario.Usuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO dados){
        var usernamePassword = new UsernamePasswordAuthenticationToken(dados.usuario(), dados.senha());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO dados){
        if(this.repository.findByUsuario(dados.usuario())!= null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dados.senha());
        Usuario usuario = new Usuario(dados.usuario(),encryptedPassword, dados.role());

        this.repository.save(usuario);
        return ResponseEntity.ok().build();
    }
}
