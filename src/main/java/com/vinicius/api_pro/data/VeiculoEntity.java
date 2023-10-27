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
@Table(name = "veiculos")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo placa é obrigatório.")
    private String placa;
    @NotBlank(message = "Campo marca é obrigatório.")
    private String marca;
    @NotBlank(message = "Campo cor é obrigatório.")
    private String cor;
    @NotBlank(message = "Campo ativo é obrigatório.")
    private String ativo;
    @NotBlank(message = "Campo modelo é obrigatório.")
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "condomino_id")
    private CondominoEntity condomino;
}
