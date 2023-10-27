
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartamentoRepository extends JpaRepository<ApartamentoEntity, Long> {

    ApartamentoEntity findByNumero(Integer numero);
}