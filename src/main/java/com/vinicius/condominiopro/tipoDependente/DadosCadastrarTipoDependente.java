package com.vinicius.condominiopro.tipoDependente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarTipoDependente(
		
		@NotBlank
		String tipoDepend_descricao
		) {

}
