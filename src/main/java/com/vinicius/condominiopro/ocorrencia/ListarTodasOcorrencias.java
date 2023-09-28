package com.vinicius.condominiopro.ocorrencia;

import java.sql.Date;

public record ListarTodasOcorrencias(
		long ocorrencia_id,
		String ocorrencia_nome,
		String ocorrencia_descricao,
		Date data_ocorrencia,
		String sindico,
		String codomino
		) {

	public ListarTodasOcorrencias(Ocorrencia ocorrencia) {
		this(
				ocorrencia.getOcorrencia_id(), ocorrencia.getOcorrencia_nome(), ocorrencia.getOcorrencia_descricao(),
				ocorrencia.getData_ocorrencia(), ocorrencia.getSindico().getCondomino().getNome(),
				ocorrencia.getCondomino().getNome()
				);
		}
}
