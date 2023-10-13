package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.condomino.Condomino;

public interface CondominoRepository extends JpaRepository<Condomino, Long>{
    Condomino findByNome(String nome);

    Condomino findByCpf(String cpf);
}
