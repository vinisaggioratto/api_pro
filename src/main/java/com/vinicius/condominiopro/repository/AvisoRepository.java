package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.aviso.Aviso;

public interface AvisoRepository extends JpaRepository<Aviso, Long>{

}
