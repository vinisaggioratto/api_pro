package com.vinicius.condominiopro.tipoDependente;

public record ListarTodosTipoDependente(
		long tipoDepend_id,
		String tipoDepend_descricao
		) {

	public ListarTodosTipoDependente(TipoDependente tipo) {
		this(tipo.getTipoDepend_id(), tipo.getTipoDepend_descricao());
	}
}
