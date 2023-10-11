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
//@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "fornecedor_id")
public class Fornecedor {

	public Fornecedor() {
	}
	public Fornecedor(Long fornecedor_id) {
		super();
		this.fornecedor_id = fornecedor_id;
	}
	public Fornecedor(String nome) {

		this.nome = nome;
	}

	public Fornecedor(Long fornecedor_id, String nome, String cpf_cnpj, String telefone_celular, String especialidade,
					  String rua, String bairro, int numero, Cidade cidade, Estado estado) {
		this.fornecedor_id = fornecedor_id;
		this.nome = nome;
		this.cpf_cnpj = cpf_cnpj;
		this.telefone_celular = telefone_celular;
		this.especialidade = especialidade;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long fornecedor_id;
	
	private String nome;

    private String cpf_cnpj;
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
