package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.ocorrencia.Ocorrencia;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>{

}
