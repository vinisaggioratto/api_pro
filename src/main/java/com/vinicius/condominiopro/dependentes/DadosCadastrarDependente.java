package com.vinicius.condominiopro.dependentes;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.tipoDependente.TipoDependente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarDependente(
		
		@NotBlank
		String nome,
		@NotBlank
	    String cpf,
	    @NotBlank
	    String rg,
	    @NotBlank
	    String telefone_celular,
	    @NotBlank
	    String morador,
	    TipoDependente tipoDependente,
	    Condomino condomino
		) {

}
