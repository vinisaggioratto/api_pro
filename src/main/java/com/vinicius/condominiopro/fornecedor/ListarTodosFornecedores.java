package com.vinicius.condominiopro.fornecedor;

public record ListarTodosFornecedores(
		
		long fornecedor_id,
		String nome,
		String cpfCnpj,
		String telefone_celular,
	    String especialidade,
	    String rua,
	    String bairro,
	    int numero,
	    String cidade,
	    String estado
		) {

	public ListarTodosFornecedores(Fornecedor fornecedor) {
		this(fornecedor.getFornecedor_id(), fornecedor.getNome(), fornecedor.getCpfCnpj(),
				fornecedor.getTelefone_celular(), fornecedor.getEspecialidade(), 
				fornecedor.getRua(), fornecedor.getBairro(), fornecedor.getNumero(),
				fornecedor.getCidade().getCidade_nome(), fornecedor.getEstado().getEstado_nome());
	}
}
