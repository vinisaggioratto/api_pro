
package com.vinicius.api_pro.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicencaRepository extends JpaRepository<LicencaEntity, Long>{
    
}
