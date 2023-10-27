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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Campo descrição é obrigatório.")
    private String descricao;
    @NotBlank(message = "Campo data do aviso é obrigatório.")
    private Date data_aviso;

    @NotBlank(message = "Campo síndico é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "sindico_id")
    private SindicoEntity sindico;
}
