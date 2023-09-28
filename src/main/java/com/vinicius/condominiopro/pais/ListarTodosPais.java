package com.vinicius.condominiopro.pais;

public record ListarTodosPais(
		long pais_id,
		String pais_nome
		) {

	public ListarTodosPais(Pais pais) {
		this(pais.getPais_id(), pais.getPais_nome());
	}
}
