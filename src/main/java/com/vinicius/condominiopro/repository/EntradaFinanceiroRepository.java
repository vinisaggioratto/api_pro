package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.entradaFinanceiro.EntradaFinanceiro;

public interface EntradaFinanceiroRepository extends JpaRepository<EntradaFinanceiro, Long>{

}
