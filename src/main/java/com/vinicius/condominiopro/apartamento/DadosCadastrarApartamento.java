package com.vinicius.condominiopro.apartamento;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarApartamento(
		
	    Integer numero,
	    Integer andar,
	    @NotBlank
	    String bloco,
	    @NotBlank
	    String status
	    ) {
}
