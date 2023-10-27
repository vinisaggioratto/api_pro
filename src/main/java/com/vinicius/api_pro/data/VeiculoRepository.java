
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface VeiculoRepository extends JpaRepository<VeiculoEntity, Long>{
VeiculoEntity findByPlaca(String nome);
}
