package com.vinicius.condominiopro.entradaFinanceiro;

import java.sql.Date;

public record ListarTodasEntradaFinanceiro(
		
		long recebCond_id,
		Date data_operacao,
		String condomino,
		String parcelamento,
		String recebCond_descricao
		) {
	
	public ListarTodasEntradaFinanceiro(EntradaFinanceiro entradaFinanceiro) {
		this(
				entradaFinanceiro.getRecebCond_id(),
				entradaFinanceiro.getData_operacao(),
				entradaFinanceiro.getCondomino().getNome(),
				entradaFinanceiro.getParcelamento(),
				entradaFinanceiro.getRecebCond_descricao()
				);
	}

}
