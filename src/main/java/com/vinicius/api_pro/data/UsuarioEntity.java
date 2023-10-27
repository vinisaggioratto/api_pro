package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    public UsuarioEntity() {
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message="Campo login é obrigatório.")
    @Size(min=4, message="Informe ao menos 4 caracteres para o campo login.")
    private String login;
    @NotBlank(message="Campo senha é obrigatório.")
    @Size(min=6, message="Informe ao menos 6 caracteres para o campo senha.")
    private String password;
    @NotBlank(message="Campo perfil é obrigatório.")
    private String perfil;
}
