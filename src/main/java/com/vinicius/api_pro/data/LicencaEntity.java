package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "licencas")
public class LicencaEntity {

    public LicencaEntity() {
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome é obrigatório.")
    private String nome;
    @NotBlank(message = "Campo descrição é obrigatório.")
    private String descricao;
    @NotBlank(message = "Campo número é obrigatório.")
    private String numero;
    @NotBlank(message = "Campo emissor é obrigatório.")
    private String emissor;

    private Date data_emissao;

    private Date data_validade;
    @NotBlank(message = "Campo válido é obrigatório.")
    private String valido;
}
