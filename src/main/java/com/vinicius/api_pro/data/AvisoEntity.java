package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "avisos")
public class AvisoEntity {

    public AvisoEntity() {
    }

    public AvisoEntity(String nome) {
        this.nome = nome;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    private String descricao;
    private Date data_aviso;

    @ManyToOne
    @JoinColumn(name = "sindico_id")
    private SindicoEntity sindico;
}
