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
@Table(name = "saida_estoque")
public class SaidaEstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo item é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "item_estoque_id")
    private ItemEstoqueEntity itemEstoque;

    @NotBlank(message = "Campo quantidade é obrigatório.")
    private Integer quantidade;
    @NotBlank(message = "Campo data de saída é obrigatório.")
    private Date data_saida;
}
