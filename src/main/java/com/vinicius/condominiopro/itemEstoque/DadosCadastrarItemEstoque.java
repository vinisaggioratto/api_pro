package com.vinicius.condominiopro.itemEstoque;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarItemEstoque(
		@NotBlank
		String itemEstoque_descricao,
		Integer estoque
		) {

}
