package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.login.Login;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long>{
    UserDetails findByUsuario(String usuario);
}
