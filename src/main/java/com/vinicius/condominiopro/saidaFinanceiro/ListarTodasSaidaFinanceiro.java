package com.vinicius.condominiopro.saidaFinanceiro;

import java.sql.Date;

public record ListarTodasSaidaFinanceiro(
		long saidaPag_id,
		Date data_operacao,
		String fornecedor,
		Integer nota_fiscal,
		double valor,
		String parcelamento,
		String saidaPag_descricao
		) {

	public ListarTodasSaidaFinanceiro(SaidaFinanceiro saidaFinanceiro) {
		this(
				saidaFinanceiro.getSaidaPag_id(), saidaFinanceiro.getData_operacao(),
				saidaFinanceiro.getFornecedor().getNome(), saidaFinanceiro.getNota_fiscal(),
				saidaFinanceiro.getValor(), saidaFinanceiro.getParcelamento(), saidaFinanceiro.getSaidaPag_descricao()
				);
	}
}
