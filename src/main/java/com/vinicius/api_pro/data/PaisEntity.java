package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "Pais")
@Table(name = "pais")
public class PaisEntity {

    public PaisEntity() {
    }

    
    public PaisEntity(String nome) {
        this.nome = nome;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="Campo nome é obrigatório.")
    private String nome;
}
