package com.vinicius.condominiopro.licenca;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Licenca")
@Table(name = "licencas")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "licenca_id")
public class Licenca {
	
	public Licenca() {
		super();
	}
	
	public Licenca(DadosCadastrarLicenca dados) {
		super();
		this.licenca_nome = dados.licenca_nome();
		this.licenca_descricao = dados.licenca_descricao();
		this.numero = dados.numero();
		this.emissor = dados.emissor();
		this.data_emissao = dados.data_emissao();
		this.data_validade = dados.data_validade();
		this.valido = dados.valido();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long licenca_id;
	
	@Column(name = "nome")
    private String licenca_nome;
	
	@Column(name = "descricao")
    private String licenca_descricao;
	
    private String numero;
    private String emissor;
    private Date data_emissao;
    private Date data_validade;
    private String valido;
    
  //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
	public long getLicenca_id() {
		return licenca_id;
	}
	public void setLicenca_id(long licenca_id) {
		this.licenca_id = licenca_id;
	}
	public String getLicenca_nome() {
		return licenca_nome;
	}
	public void setLicenca_nome(String licenca_nome) {
		this.licenca_nome = licenca_nome;
	}
	public String getLicenca_descricao() {
		return licenca_descricao;
	}
	public void setLicenca_descricao(String licenca_descricao) {
		this.licenca_descricao = licenca_descricao;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getEmissor() {
		return emissor;
	}
	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}
	public Date getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}
	public Date getData_validade() {
		return data_validade;
	}
	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
	public String getValido() {
		return valido;
	}
	public void setValido(String valido) {
		this.valido = valido;
	}
    
}
