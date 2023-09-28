package com.vinicius.condominiopro.entradaEstoque;

import java.sql.Date;

public record ListarTodasEntradaEstoque(long entradaEstoque_id, String itemEstoque, String entradaEstoque_descricao,
		Integer quantidade, double valor_unitario, Date data_entrada, String fornecedor) {

	public ListarTodasEntradaEstoque(EntradaEstoque entradaEstoque) {
		this(entradaEstoque.getEntradaEstoque_id(), entradaEstoque.getItemEstoque().getItemEstoque_descricao(),
				entradaEstoque.getEntradaEstoque_descricao(), entradaEstoque.getQuantidade(),
				entradaEstoque.getValor_unitario(), entradaEstoque.getData_entrada(),
				entradaEstoque.getFornecedor().getNome());
	}
}
