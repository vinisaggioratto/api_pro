package com.vinicius.condominiopro.sindico;

import java.sql.Date;

import com.vinicius.condominiopro.condomino.Condomino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "Sindico")
@Table(name = "sindico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "aviso_id")
public class Sindico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer sindico_id;
	
    private Date data_inicial;
    private Date data_final_prevista;
    private Date data_final;
    
    @ManyToOne
    @Column(name = "condomino_id")
    private Condomino condomino;
    
    private String ativo;
    
    
    //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
    
	public Integer getSindico_id() {
		return sindico_id;
	}
	public void setSindico_id(Integer sindico_id) {
		this.sindico_id = sindico_id;
	}
	public Date getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public Date getData_final_prevista() {
		return data_final_prevista;
	}
	public void setData_final_prevista(Date data_final_prevista) {
		this.data_final_prevista = data_final_prevista;
	}
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	public Condomino getCondomino() {
		return condomino;
	}
	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
    
    
}
