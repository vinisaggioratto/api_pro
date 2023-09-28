package com.vinicius.condominiopro.saidaFinanceiro;

import java.sql.Date;

import com.vinicius.condominiopro.fornecedor.Fornecedor;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarSaidaFinanceiro(
		
		Date data_operacao,
		Fornecedor fornecedor,
		Integer nota_fiscal,
		double valor,
		@NotBlank
		String parcelamento,
		@NotBlank
		String saidaPag_descricao
		) {

}
