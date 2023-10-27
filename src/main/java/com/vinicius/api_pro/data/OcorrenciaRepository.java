
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface OcorrenciaRepository extends JpaRepository<OcorrenciaEntity, Long>{
OcorrenciaEntity findByNome(String nome);
}
