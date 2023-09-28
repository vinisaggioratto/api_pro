package com.vinicius.condominiopro.itemEstoque;

public record ListarTodosItemEstoque(
		long itemEstoque_id,
		String itemEstoque_descricao,
		Integer estoque
		) {

	public ListarTodosItemEstoque(ItemEstoque itemEstoque) {
		this(itemEstoque.getItemEstoque_id(), itemEstoque.getItemEstoque_descricao(), itemEstoque.getEstoque());
	}
}
