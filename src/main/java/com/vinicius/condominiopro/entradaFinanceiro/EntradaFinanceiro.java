package com.vinicius.condominiopro.entradaFinanceiro;

import java.sql.Date;

import com.vinicius.condominiopro.condomino.Condomino;

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

@Entity(name = "EntradaFinanceiro")
@Table(name = "entrada_financeiro")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "recebCond_id")
public class EntradaFinanceiro {
	
	public EntradaFinanceiro() {
		super();
	}

	public EntradaFinanceiro(DadosCadastrarEntradaFinanceiro dados) {
		super();
		this.data_operacao = dados.data_operacao();
		this.condomino = dados.condomino();
		this.valor = dados.valor();
		this.parcelamento = dados.parcelamento();
		this.recebCond_descricao = dados.recebCond_descricao();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long recebCond_id;
    
    private Date data_operacao;
    
	@ManyToOne
	@JoinColumn(name = "condomino_id")
    private Condomino condomino;
	
    private double valor;
    private String parcelamento;
    
	@Column(name = "descricao")
    private String recebCond_descricao;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getRecebCond_id() {
		return recebCond_id;
	}

	public void setRecebCond_id(Integer recebCond_id) {
		this.recebCond_id = recebCond_id;
	}

	public Date getData_operacao() {
		return data_operacao;
	}

	public void setData_operacao(Date data_operacao) {
		this.data_operacao = data_operacao;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getParcelamento() {
		return parcelamento;
	}

	public void setParcelamento(String parcelamento) {
		this.parcelamento = parcelamento;
	}

	public String getRecebCond_descricao() {
		return recebCond_descricao;
	}

	public void setRecebCond_descricao(String recebCond_descricao) {
		this.recebCond_descricao = recebCond_descricao;
	}
	
}
