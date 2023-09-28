package com.vinicius.condominiopro.manutencao;

import java.sql.Date;

public record ListarTodasManutencoes(
		long manutencao_id,
		String manutencao_nome,
		String manutencao_descricao,
		Double valor,
		Date data_inicial,
		Date data_final,
		String fornecedor		
		) {

	public ListarTodasManutencoes(Manutencao manutencao) {
		this(manutencao.getManutencao_id(), manutencao.getManutencao_nome(), manutencao.getManutencao_descricao(),
				manutencao.getValor(), manutencao.getData_inicial(), manutencao.getData_final(), 
				manutencao.getFornecedor().getNome()
				);
	}
}
