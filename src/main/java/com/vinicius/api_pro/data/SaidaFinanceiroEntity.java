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
@Table(name = "saidas_financeiro")
public class SaidaFinanceiroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo data de operação é obrigatório.")
    private Date data_operacao;

    @NotBlank(message = "Campo fornecedor é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "fornecedor_id")
    private FornecedorEntity fornecedor;

    @NotBlank(message = "Campo nota fiscal é obrigatório.")
    private Integer nota_fiscal;
    @NotBlank(message = "Campo valor é obrigatório.")
    private double valor;
    @NotBlank(message = "Campo parcelamento é obrigatório.")
    private String parcelamento;
    @NotBlank(message = "Campo descrição é obrigatório.")
    private String descricao;
}
