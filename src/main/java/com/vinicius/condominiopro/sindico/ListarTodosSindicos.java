package com.vinicius.condominiopro.sindico;

import java.sql.Date;

public record ListarTodosSindicos(
		
		long sindico_id,
		Date data_inicial,
		Date data_final_prevista,
		Date data_final,
		String condomino,
		String ativo
		) {

	public ListarTodosSindicos(Sindico sindico) {
		this(
				sindico.getSindico_id(),
				sindico.getData_inicial(), sindico.getData_final_prevista(), sindico.getData_final(),
				sindico.getCondomino().getNome(), sindico.getAtivo()
				);
	}
}
