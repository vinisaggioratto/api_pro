package com.vinicius.condominiopro.condomino;

public record ListarTodosCondomino(
		long condomino_id,
		String nome,
	    String cpf,
	    String rg,
		String telefone_celular,
	    String proprietario,
	    String morador
		) {
	
	public ListarTodosCondomino (Condomino condomino) {   //CONSTRUTOR PARA PEGAR OS DADOS
		this(condomino.getCondomino_id(), condomino.getNome(), condomino.getCpf(), condomino.getRg(),
				condomino.getTelefone_celular(), condomino.getProprietario(), condomino.getMorador());
	}

}
