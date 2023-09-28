package com.vinicius.condominiopro.licenca;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarLicenca(
		
		@NotBlank
	    String licenca_nome,
	    @NotBlank
	    String licenca_descricao,
	    @NotBlank
	    String numero,
	    @NotBlank
	    String emissor,
	    Date data_emissao,
	    Date data_validade,
	    @NotBlank
	    String valido
		) {
}
