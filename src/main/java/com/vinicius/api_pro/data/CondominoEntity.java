package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "condomino")
public class CondominoEntity {

    public CondominoEntity() {
    }

    public CondominoEntity(String nome) {
        this.nome = nome;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Campo CPF é obrigatório.")
    @CPF
    private String cpf;
    @NotBlank(message = "Campo RG é obrigatório.")
    private String rg;
    @NotBlank(message = "Campo proprietário é obrigatório.")
    private String proprietario;
    @NotBlank(message = "Campo telefone é obrigatório.")
    private String telefone_celular;
    @NotBlank(message = "Campo morador é obrigatório.")
    private String morador;

}
