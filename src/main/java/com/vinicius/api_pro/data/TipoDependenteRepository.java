
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TipoDependenteRepository extends JpaRepository<TipoDependenteEntity, Long>{
    TipoDependenteEntity findByDescricao(String descricao);
}
