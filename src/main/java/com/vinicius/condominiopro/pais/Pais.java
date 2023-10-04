package com.vinicius.condominiopro.pais;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Pais")
@Table(name = "pais")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "pais_id")
public class Pais {

	

	public Pais(long pais_id) {
		super();
		this.pais_id = pais_id;
	}



	public Pais(DadosCadastrarPais dados) {
		super();
		this.pais_nome = dados.pais_nome();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long pais_id;
	
	@Column(name = "nome")
    private String pais_nome;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getPais_id() {
		return pais_id;
	}

	public void setPais_id(int pais_id) {
		this.pais_id = pais_id;
	}

	public String getPais_nome() {
		return pais_nome;
	}

	public void setPais_nome(String pais_nome) {
		this.pais_nome = pais_nome;
	}
	
}
