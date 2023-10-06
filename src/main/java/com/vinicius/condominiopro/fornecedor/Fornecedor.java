package com.vinicius.condominiopro.fornecedor;

import com.vinicius.condominiopro.cidade.Cidade;
import com.vinicius.condominiopro.estado.Estado;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Fornecedor")
@Table(name = "fornecedor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "fornecedor_id")
public class Fornecedor {

	public Fornecedor(long fornecedor_id) {
		super();
		this.fornecedor_id = fornecedor_id;
	}



	public Fornecedor(DadosCadastrarFornecedor dados) {
		super();
		this.nome = dados.nome();
		this.cpfCnpj = dados.cpfCnpj();
		this.telefone_celular = dados.telefone_celular();
		this.especialidade = dados.especialidade();
		this.rua = dados.rua();
		this.bairro = dados.bairro();
		this.numero = dados.numero();
		this.cidade = dados.cidade();
		this.estado = dados.estado();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long fornecedor_id;
	
	private String nome;
	
	@Column(name = "cpf_cnpj")
    private String cpfCnpj;
	
    private String telefone_celular;
    private String especialidade;
    private String rua;
    private String bairro;
    private int numero;
    
	@ManyToOne
	@JoinColumn(name = "cidade_id")
    private Cidade cidade;
    
	@ManyToOne
	@JoinColumn(name = "estado_id")
    private Estado estado;
}
