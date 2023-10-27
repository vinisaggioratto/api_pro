
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PaisRepository extends JpaRepository<PaisEntity, Long>{
    PaisEntity findByNome(String nome);
}
