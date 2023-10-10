package com.vinicius.condominiopro.cidade;

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

@Entity(name = "Cidade")
@Table(name = "cidade")
//@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "cidade_id")
public class Cidade {

	public Cidade() {
	}

	public Cidade(long cidade_id) {
		super();
		this.cidade_id = cidade_id;
	}

	public Cidade(String nome) {
		this.nome = nome;
	}

	public Cidade(long cidade_id, String nome, Estado estado) {
		this.cidade_id = cidade_id;
		this.nome = nome;
		this.estado = estado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long cidade_id;
	
	@Column(name = "nome")
    private String nome;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
    private Estado estado;
	
}
