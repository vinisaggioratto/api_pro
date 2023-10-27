
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface SindicoRepository extends JpaRepository<SindicoEntity, Long>{
    SindicoEntity findByNome(String nome);
}
