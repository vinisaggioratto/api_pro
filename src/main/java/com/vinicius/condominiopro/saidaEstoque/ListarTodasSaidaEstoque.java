package com.vinicius.condominiopro.saidaEstoque;

import java.sql.Date;

public record ListarTodasSaidaEstoque(
		long saidaEstoque_id,
		String itemEstoque,
		Integer quantidade,
		Date data_saida
		) {

	public ListarTodasSaidaEstoque(SaidaEstoque saidaEstoque) {
		this(
				saidaEstoque.getSaidaEstoque_id(),
				saidaEstoque.getItemEstoque().getItemEstoque_descricao(),
				saidaEstoque.getQuantidade(), saidaEstoque.getData_saida()
				);
	}
}
