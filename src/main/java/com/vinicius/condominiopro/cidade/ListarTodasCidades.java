package com.vinicius.condominiopro.cidade;

public record ListarTodasCidades(
		long cidade_id,
		String cidade_nome,
		String estado
		) {
	
	public ListarTodasCidades(Cidade cidade) {
		this(cidade.getCidade_id(), cidade.getNome(), cidade.getEstado().getNome());
	}

}
