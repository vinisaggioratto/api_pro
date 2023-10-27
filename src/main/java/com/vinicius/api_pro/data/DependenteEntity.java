package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "dependentes")
public class DependenteEntity {

    public DependenteEntity() {
    }

    public DependenteEntity(String nome) {
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
    
    @NotBlank(message = "Campo telefone é obrigatório.")
    private String telefone_celular;
    
    @NotBlank(message = "Campo morador é obrigatório.")
    private String morador;

    @ManyToOne
    @JoinColumn(name = "tipo_dependente_id")
    private TipoDependenteEntity tipoDependente;

    @ManyToOne
    @JoinColumn(name = "condomino_id")
    private CondominoEntity condomino;

}
