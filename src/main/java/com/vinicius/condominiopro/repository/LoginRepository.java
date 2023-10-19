package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.login.Login;

import java.util.List;

public interface LoginRepository extends JpaRepository<Login, Long>{
    Login findByUsuario(String usuario);
}
