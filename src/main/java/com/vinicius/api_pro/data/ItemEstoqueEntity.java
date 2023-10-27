package com.vinicius.api_pro.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
@Table(name = "item_estoque")
public class ItemEstoqueEntity {

    public ItemEstoqueEntity() {
    }

    public ItemEstoqueEntity(String descricao) {
        this.descricao = descricao;
    }

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Campo descrição é obrigatório.")
    private String descricao;
    @NotBlank(message="Campo estoque é obrigatório.")
    private Integer estoque;
}
