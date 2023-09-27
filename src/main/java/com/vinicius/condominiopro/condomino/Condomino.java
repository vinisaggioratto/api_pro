package com.vinicius.condominiopro.condomino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Condomino")
@Table(name = "condomino")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "condomino_id")
public class Condomino {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long condomino_id;
	
	private String nome;
	
    private String cpf;
    private String rg;
    private String proprietario;
    private String telefone_celular;
    private String morador;

    
    //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
    
    
	public long getCondomino_id() {
		return condomino_id;
	}

	public void setCondomino_id(long condomino_id) {
		this.condomino_id = condomino_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getProprietario() {
		return proprietario;
	}

	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}

	public String getTelefone_celular() {
		return telefone_celular;
	}

	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}

	public String getMorador() {
		return morador;
	}

	public void setMorador(String morador) {
		this.morador = morador;
	}
 
}
