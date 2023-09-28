package com.vinicius.condominiopro.cidade;

public record ListarTodasCidades(
		long cidade_id,
		String cidade_nome,
		String estado
		) {
	
	public ListarTodasCidades(Cidade cidade) {
		this(cidade.getCidade_id(), cidade.getCidade_nome(), cidade.getEstado().getEstado_nome());
	}

}
