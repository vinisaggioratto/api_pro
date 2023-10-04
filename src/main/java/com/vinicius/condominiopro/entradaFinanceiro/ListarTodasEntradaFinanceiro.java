package com.vinicius.condominiopro.entradaFinanceiro;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record ListarTodasEntradaFinanceiro(
		
		long recebCond_id,
		Date data_operacao,
		String condomino,
		Double valor,
		String parcelamento,
		String recebCond_descricao
		) {


	public ListarTodasEntradaFinanceiro(EntradaFinanceiro entradaFinanceiro) {
		this(
				entradaFinanceiro.getRecebCond_id(),
				entradaFinanceiro.getData_operacao(),
				entradaFinanceiro.getCondomino().getNome(),
				entradaFinanceiro.getValor(),
				entradaFinanceiro.getParcelamento(),
				entradaFinanceiro.getRecebCond_descricao()
				);
	}

}
