package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.manutencao.Manutencao;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long>{

}
