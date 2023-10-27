
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DependenteRepository extends JpaRepository<DependenteEntity, Long>{
    DependenteEntity findByNome(String nome);
    DependenteEntity findByCpf(String cpf);
}
