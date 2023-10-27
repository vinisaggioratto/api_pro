
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ManutencaoRepository extends JpaRepository<ManutencaoEntity, Long>{
ManutencaoEntity findByNome(String nome);
}
