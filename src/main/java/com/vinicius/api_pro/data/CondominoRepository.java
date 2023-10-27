
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CondominoRepository extends JpaRepository<CondominoEntity, Long>{
    CondominoEntity findByNome(String nome);

    CondominoEntity findByCpf(String cpf);
}
