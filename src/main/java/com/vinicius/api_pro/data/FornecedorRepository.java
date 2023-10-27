
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FornecedorRepository extends JpaRepository<FornecedorEntity, Long>{
    FornecedorEntity findByNome(String nome);
}
