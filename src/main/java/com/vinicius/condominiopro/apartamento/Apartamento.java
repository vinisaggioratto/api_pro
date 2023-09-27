package com.vinicius.condominiopro.apartamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Apartamento")
@Table(name = "apartamento")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "apartamento_id")
public class Apartamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long apartamento_id;
	
    private Integer numero;
    private Integer andar;
    private String bloco;
    private String status;
    
    
  //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
    
	public long getApartamento_id() {
		return apartamento_id;
	}
	public void setApartamento_id(long apartamento_id) {
		this.apartamento_id = apartamento_id;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getAndar() {
		return andar;
	}
	public void setAndar(Integer andar) {
		this.andar = andar;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
