package com.vinicius.condominiopro.saidaEstoque;

import java.sql.Date;

import com.vinicius.condominiopro.itemEstoque.ItemEstoque;

public record DadosCadastrarSaidaEstoque(
		
		ItemEstoque itemEstoque,
		Integer quantidade,
		Date data_saida
		) {

}
