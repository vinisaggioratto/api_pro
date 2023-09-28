package com.vinicius.condominiopro.dependentes;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.tipoDependente.TipoDependente;

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

@Entity(name = "Dependente")
@Table(name = "dependentes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "dependente_id")
public class Dependente {

	public Dependente() {
		super();
	}
	
	

	public Dependente(DadosCadastrarDependente dados) {
		super();
		this.nome = dados.nome();
		this.cpf = dados.cpf();
		this.rg = dados.rg();
		this.telefone_celular = dados.telefone_celular();
		this.morador = dados.morador();
		this.tipoDependente = dados.tipoDependente();
		this.condomino = dados.condomino();
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long dependente_id;
	private String nome;
    private String cpf;
    private String rg;
    private String telefone_celular;
    private String morador;
    
	@ManyToOne
	@JoinColumn(name = "tipo_dependente_id")
    private TipoDependente tipoDependente;
    
	@ManyToOne
	@JoinColumn(name = "condomino_id")
    private Condomino condomino;
	
    //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getDependente_id() {
		return dependente_id;
	}

	public void setDependente_id(Integer dependente_id) {
		this.dependente_id = dependente_id;
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

	public TipoDependente getTipoDependente() {
		return tipoDependente;
	}

	public void setTipoDependente(TipoDependente tipoDependente) {
		this.tipoDependente = tipoDependente;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
    
}
