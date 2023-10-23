package com.vinicius.condominiopro.repository;

import com.vinicius.condominiopro.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    UserDetails findByUsuario(String usuario);
}
