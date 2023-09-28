package com.vinicius.condominiopro.login;

import com.vinicius.condominiopro.condomino.Condomino;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarLogin(
		
		@NotBlank
	    String usuario,
	    @NotBlank
	    String senha,
	    Condomino condomino
	    ) {

}
