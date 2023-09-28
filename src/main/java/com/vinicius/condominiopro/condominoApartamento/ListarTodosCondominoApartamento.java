package com.vinicius.condominiopro.condominoApartamento;

import java.sql.Date;

public record ListarTodosCondominoApartamento(
		long id,
		String condomino,
		int apartamento,
		Date data_entrada,
		Date data_saida
		) {
	
	public ListarTodosCondominoApartamento(CondominoApartamento cond) {
		this(cond.getId(), cond.getCondomino().getNome(), cond.getApartamento().getNumero(), 
				cond.getData_entrada(), cond.getData_saida());
	}

}
