package com.vinicius.condominiopro.entradaEstoque;

import java.sql.Date;

import com.vinicius.condominiopro.fornecedor.Fornecedor;
import com.vinicius.condominiopro.itemEstoque.ItemEstoque;

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

@Entity(name = "EntradaEstoque")
@Table(name = "entrada_estoque")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "entradaEstoque_id")
public class EntradaEstoque {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long entradaEstoque_id;
	
	@ManyToOne
	@JoinColumn(name = "item_estoque_id")
    private ItemEstoque itemEstoque;
	
	@Column(name = "nome")
    private String entradaEstoque_descricao;
    private Integer quantidade;
    private double valor_unitario;
    private Date data_entrada;
    
	@ManyToOne
	@JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getEntradaEstoque_id() {
		return entradaEstoque_id;
	}

	public void setEntradaEstoque_id(Integer entradaEstoque_id) {
		this.entradaEstoque_id = entradaEstoque_id;
	}

	public ItemEstoque getItemEstoque() {
		return itemEstoque;
	}

	public void setItemEstoque(ItemEstoque itemEstoque) {
		this.itemEstoque = itemEstoque;
	}

	public String getEntradaEstoque_descricao() {
		return entradaEstoque_descricao;
	}

	public void setEntradaEstoque_descricao(String entradaEstoque_descricao) {
		this.entradaEstoque_descricao = entradaEstoque_descricao;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor_unitario() {
		return valor_unitario;
	}

	public void setValor_unitario(double valor_unitario) {
		this.valor_unitario = valor_unitario;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	
}
