package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    Usuario findByLogin(String login);
}
