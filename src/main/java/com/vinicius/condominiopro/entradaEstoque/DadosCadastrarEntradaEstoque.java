package com.vinicius.condominiopro.entradaEstoque;

import java.sql.Date;

import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.itemEstoque.ItemEstoque;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarEntradaEstoque(
		
		ItemEstoque itemEstoque,
		@NotBlank
	    String entradaEstoque_descricao,
	    Integer quantidade,
	    double valor_unitario,
	    Date data_entrada,
	    Fornecedor fornecedor
		) {

}
