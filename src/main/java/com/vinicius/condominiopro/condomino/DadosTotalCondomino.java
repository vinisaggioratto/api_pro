package com.vinicius.condominiopro.condomino;

public record DadosTotalCondomino(
		long condomino_id,
		String nome,
	    String cpf,
	    String rg,
	    String proprietario,
	    String morador
		) {
	
	public DadosTotalCondomino (Condomino condomino) {   //CONSTRUTOR PARA PEGAR OS DADOS
		this(condomino.getCondomino_id(), condomino.getNome(), condomino.getCpf(), condomino.getRg(), 
				condomino.getProprietario(), condomino.getMorador());
	}

}
