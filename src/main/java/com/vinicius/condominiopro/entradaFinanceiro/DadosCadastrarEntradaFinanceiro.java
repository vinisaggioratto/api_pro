package com.vinicius.condominiopro.entradaFinanceiro;

import java.sql.Date;

import com.vinicius.condominiopro.condomino.Condomino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarEntradaFinanceiro(
		
		Date data_operacao,
		Condomino condomino,
		double valor,
		@NotBlank
		String parcelamento,
		@NotBlank
		String recebCond_descricao
		) {

}
