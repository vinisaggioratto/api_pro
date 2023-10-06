package com.vinicius.condominiopro.estado;

public record ListarTodosEstados(
		long estado_id,
		String estado_nome,
		String pais
		) {

	public ListarTodosEstados(Estado estado) {
		this(estado.getEstado_id(),
				estado.getEstado_nome(),
				estado.getPais().getNome());
	}
}
