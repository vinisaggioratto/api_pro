
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EstadoRepository extends JpaRepository<EstadoEntity, Long>{

    EstadoEntity findByNome(String nome);
}
