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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Cidade")
@Table(name = "cidade")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "cidade_id")
public class Cidade {
	

	public Cidade(long cidade_id) {
		super();
		this.cidade_id = cidade_id;
	}



	public Cidade(DadosCadastrarCidade dados) {
		super();
		this.cidade_nome = dados.cidade_nome();
		this.estado = dados.estado();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long cidade_id;
	
	@Column(name = "nome")
    private String cidade_nome;
	
	@ManyToOne
	@JoinColumn(name = "estado_id")
    private Estado estado;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getCidade_id() {
		return cidade_id;
	}

	public void setCidade_id(int cidade_id) {
		this.cidade_id = cidade_id;
	}

	public String getCidade_nome() {
		return cidade_nome;
	}

	public void setCidade_nome(String cidade_nome) {
		this.cidade_nome = cidade_nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
}
