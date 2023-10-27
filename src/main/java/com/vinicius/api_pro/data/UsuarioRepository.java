
package com.vinicius.api_pro.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{
    List<UsuarioEntity> findByLoginAndPassword(String login, String password);
    List<UsuarioEntity> findByLogin(String login); 
    
}
