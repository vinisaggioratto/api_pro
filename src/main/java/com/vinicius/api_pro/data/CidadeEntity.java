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

@Data
@Entity
@Table(name = "cidade")
public class CidadeEntity {

    public CidadeEntity() {
    }

    public CidadeEntity(String nome) {
        this.nome = nome;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoEntity estado;
}
