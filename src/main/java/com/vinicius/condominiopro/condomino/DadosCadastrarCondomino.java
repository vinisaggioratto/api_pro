package com.vinicius.condominiopro.condomino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarCondomino(
		
		@NotBlank
		String nome,
		@NotBlank
		String cpf,
		@NotBlank
	    String rg,
	    @NotBlank
	    String proprietario,
	    @NotBlank
	    String telefone_celular,
	    @NotBlank
	    String morador
		) {

}
