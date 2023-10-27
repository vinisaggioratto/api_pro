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
@Table(name = "ocorrencias")
public class OcorrenciaEntity {

    public OcorrenciaEntity() {
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Campo descrição é obrigatório.")
    private String descricao;
    private Date data_ocorrencia;

    @ManyToOne
    @JoinColumn(name = "sindico_id")
    private SindicoEntity sindico;

    @ManyToOne
    @JoinColumn(name = "condomino_id")
    private CondominoEntity condomino;

}
