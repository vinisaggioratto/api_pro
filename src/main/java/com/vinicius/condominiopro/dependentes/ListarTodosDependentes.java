package com.vinicius.condominiopro.dependentes;

public record ListarTodosDependentes(
		long dependente_id,
		String nome,
	    String cpf,
	    String rg,
	    String telefone_celular,
	    String morador,
	    String tipoDependente,
	    String condomino
		) {
	
	public ListarTodosDependentes (Dependente dependente) {
		this(dependente.getDependente_id(), dependente.getNome(), dependente.getCpf(), dependente.getRg(),
				dependente.getTelefone_celular(), dependente.getMorador(),
				dependente.getTipoDependente().getTipoDepend_descricao(),
				dependente.getCondomino().getNome());
	}

}
