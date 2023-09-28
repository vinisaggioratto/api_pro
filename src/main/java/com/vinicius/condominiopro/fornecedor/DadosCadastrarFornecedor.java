package com.vinicius.condominiopro.fornecedor;

import com.vinicius.condominiopro.cidade.Cidade;
import com.vinicius.condominiopro.estado.Estado;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastrarFornecedor(
		@NotBlank
		String nome,
		@NotBlank
		String cpfCnpj,
		@NotBlank
		String telefone_celular,
		@NotBlank
	    String especialidade,
	    @NotBlank
	    String rua,
	    @NotBlank
	    String bairro,
	    int numero,
	    Cidade cidade,
	    Estado estado
		) {

}
