package com.vinicius.condominiopro.condomino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Condomino")
@Table(name = "condomino")
@Getter
@Setter
@EqualsAndHashCode(of = "condomino_id")
public class Condomino {

	public Condomino() {
	}

	public Condomino(Long id) {
		super();
		this.id = id;
	}

	public Condomino(String nome) {
		this.nome = nome;
	}

	public Condomino(Long id, String nome, String cpf, String rg, String proprietario, String telefone_celular,
					 String morador) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.proprietario = proprietario;
		this.telefone_celular = telefone_celular;
		this.morador = morador;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long id;
	
	private String nome;
    private String cpf;
    private String rg;
    private String proprietario;
    private String telefone_celular;
    private String morador;
}
