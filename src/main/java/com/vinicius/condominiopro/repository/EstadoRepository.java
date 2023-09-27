package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.estado.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
