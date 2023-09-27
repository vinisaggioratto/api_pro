package com.vinicius.condominiopro.manutencao;

import java.sql.Date;

import com.vinicius.condominiopro.fornecedor.Fornecedor;

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

@Entity(name = "Manutencao")
@Table(name = "manutencoes")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "manutencao_id")
public class Manutencao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long manutencao_id;
    
	@Column(name = "nome")
    private String manutencao_nome;
	
	@Column(name = "descricao")
    private String manutencao_descricao;
	
    private Double valor;
    private Date data_inicial;
    private Date data_final;
    
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getManutencao_id() {
		return manutencao_id;
	}

	public void setManutencao_id(Integer manutencao_id) {
		this.manutencao_id = manutencao_id;
	}

	public String getManutencao_nome() {
		return manutencao_nome;
	}

	public void setManutencao_nome(String manutencao_nome) {
		this.manutencao_nome = manutencao_nome;
	}

	public String getManutencao_descricao() {
		return manutencao_descricao;
	}

	public void setManutencao_descricao(String manutencao_descricao) {
		this.manutencao_descricao = manutencao_descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
