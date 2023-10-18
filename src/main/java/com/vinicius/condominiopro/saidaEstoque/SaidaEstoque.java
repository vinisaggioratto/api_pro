package com.vinicius.condominiopro.saidaEstoque;

import java.sql.Date;

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

@Entity(name = "SaidaEstoque")
@Table(name = "saida_estoque")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "saidaEstoque_id")
public class SaidaEstoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long saidaEstoque_id;
	
	@ManyToOne
	@JoinColumn(name = "item_estoque_id")
    private ItemEstoque itemEstoque;
	
    private Integer quantidade;
    private Date data_saida;
    
    
  //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
	public long getSaidaEstoque_id() {
		return saidaEstoque_id;
	}
	public void setSaidaEstoque_id(Integer saidaEstoque_id) {
		this.saidaEstoque_id = saidaEstoque_id;
	}
	public ItemEstoque getItemEstoque() {
		return itemEstoque;
	}
	public void setItemEstoque(ItemEstoque itemEstoque) {
		this.itemEstoque = itemEstoque;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Date getData_saida() {
		return data_saida;
	}
	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}
    

}
