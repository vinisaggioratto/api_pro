package com.vinicius.condominiopro.itemEstoque;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "ItemEstoque")
@Table(name = "item_estoque")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "itemEstoque_id")
public class ItemEstoque {
	
	public ItemEstoque() {
		super();
	}
	
	
	public ItemEstoque(long itemEstoque_id) {
		super();
		this.itemEstoque_id = itemEstoque_id;
	}


	public ItemEstoque(DadosCadastrarItemEstoque dados) {
		super();
		this.itemEstoque_descricao = dados.itemEstoque_descricao();
		this.estoque = dados.estoque();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long itemEstoque_id;
	
	@Column(name = "descricao")
    private String itemEstoque_descricao;
    private Integer estoque;
    
    
  //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
	public long getItemEstoque_id() {
		return itemEstoque_id;
	}
	public void setItemEstoque_id(Integer itemEstoque_id) {
		this.itemEstoque_id = itemEstoque_id;
	}
	public String getItemEstoque_descricao() {
		return itemEstoque_descricao;
	}
	public void setItemEstoque_descricao(String itemEstoque_descricao) {
		this.itemEstoque_descricao = itemEstoque_descricao;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}
    

}
