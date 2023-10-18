package com.vinicius.condominiopro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vinicius.condominiopro.itemEstoque.ItemEstoque;

public interface ItemEstoqueRepository extends JpaRepository<ItemEstoque, Long>{

    ItemEstoque findByDescricao(String descricao);
}
