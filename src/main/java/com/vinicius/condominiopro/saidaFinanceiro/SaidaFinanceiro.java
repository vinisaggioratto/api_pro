package com.vinicius.condominiopro.saidaFinanceiro;

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

@Entity(name = "SaidaFinanceiro")
@Table(name = "saidas_financeiro")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "saidaPag_id")
public class SaidaFinanceiro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long saidaPag_id;
	
	
    private Date data_operacao;
    
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    
    private Integer nota_fiscal;
    private double valor;
    private String parcelamento; //S/N
    
	@Column(name = "descricao")
    private String saidaPag_descricao;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getSaidaPag_id() {
		return saidaPag_id;
	}

	public void setSaidaPag_id(Integer saidaPag_id) {
		this.saidaPag_id = saidaPag_id;
	}

	public Date getData_operacao() {
		return data_operacao;
	}

	public void setData_operacao(Date data_operacao) {
		this.data_operacao = data_operacao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Integer getNota_fiscal() {
		return nota_fiscal;
	}

	public void setNota_fiscal(Integer nota_fiscal) {
		this.nota_fiscal = nota_fiscal;
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

	public String getSaidaPag_descricao() {
		return saidaPag_descricao;
	}

	public void setSaidaPag_descricao(String saidaPag_descricao) {
		this.saidaPag_descricao = saidaPag_descricao;
	}
	
}
