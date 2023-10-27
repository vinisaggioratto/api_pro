
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemEstoqueRepository extends JpaRepository<ItemEstoqueEntity, Long>{
    ItemEstoqueEntity findByDescricao(String descricao);
}
