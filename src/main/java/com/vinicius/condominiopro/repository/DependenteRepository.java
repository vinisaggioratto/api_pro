package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.dependentes.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long>{
    Dependente findByNome(String nome);
    Dependente findByCpf(String cpf);
}
