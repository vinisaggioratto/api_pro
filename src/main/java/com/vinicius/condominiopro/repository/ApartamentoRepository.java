package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.apartamento.Apartamento;

public interface ApartamentoRepository extends JpaRepository<Apartamento, Long> {

}
