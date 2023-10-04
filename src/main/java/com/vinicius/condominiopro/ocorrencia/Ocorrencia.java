package com.vinicius.condominiopro.ocorrencia;

import java.sql.Date;

import com.vinicius.condominiopro.condomino.Condomino;
import com.vinicius.condominiopro.sindico.Sindico;

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

@Entity(name = "Ocorrencia")
@Table(name = "ocorrencias")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "ocorrencia_id")
public class Ocorrencia {

	

	public Ocorrencia(DadosCadastrarOcorrencia dados) {
		super();
		this.ocorrencia_nome = dados.ocorrencia_nome();
		this.ocorrencia_descricao = dados.ocorrencia_descricao();
		this.data_ocorrencia = dados.data_ocorrencia();
		this.sindico = dados.sindico();
		this.condomino = dados.condomino();
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long ocorrencia_id;
	
	@Column(name = "nome")
    private String ocorrencia_nome;
	
	@Column(name = "descricao")
    private String ocorrencia_descricao;
	
    private Date data_ocorrencia;
    
	@ManyToOne
	@JoinColumn(name = "sindico_id")
    private Sindico sindico;
	
	@ManyToOne
	@JoinColumn(name = "condomino_id")
    private Condomino condomino;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getOcorrencia_id() {
		return ocorrencia_id;
	}

	public void setOcorrencia_id(Integer ocorrencia_id) {
		this.ocorrencia_id = ocorrencia_id;
	}

	public String getOcorrencia_nome() {
		return ocorrencia_nome;
	}

	public void setOcorrencia_nome(String ocorrencia_nome) {
		this.ocorrencia_nome = ocorrencia_nome;
	}

	public String getOcorrencia_descricao() {
		return ocorrencia_descricao;
	}

	public void setOcorrencia_descricao(String ocorrencia_descricao) {
		this.ocorrencia_descricao = ocorrencia_descricao;
	}

	public Date getData_ocorrencia() {
		return data_ocorrencia;
	}

	public void setData_ocorrencia(Date data_ocorrencia) {
		this.data_ocorrencia = data_ocorrencia;
	}

	public Sindico getSindico() {
		return sindico;
	}

	public void setSindico(Sindico sindico) {
		this.sindico = sindico;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
	
}
