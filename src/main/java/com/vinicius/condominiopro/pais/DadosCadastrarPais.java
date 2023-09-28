package com.vinicius.condominiopro.pais;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarPais(
		@NotBlank
		String pais_nome
		) {

}
