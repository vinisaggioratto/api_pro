package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.pais.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>{

    Pais findByNome(String nome);
}
