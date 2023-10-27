
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CidadeRepository extends JpaRepository<CidadeEntity, Long> {
    CidadeEntity findByNome(String nome);
}
