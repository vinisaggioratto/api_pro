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

	public Condomino(Long condomino_id) {
		super();
		this.condomino_id = condomino_id;
	}

	public Condomino(String nome) {
		this.nome = nome;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Long condomino_id;
	
	private String nome;
    private String cpf;
    private String rg;
    private String proprietario;
    private String telefone_celular;
    private String morador;
}
