package com.vinicius.condominiopro.aviso;

import java.sql.Date;

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

@Entity(name = "Aviso")
@Table(name = "avisos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "aviso_id")
public class Aviso {
	
	public Aviso(DadosCadastrarAviso dados) {
		this.aviso_nome = dados.aviso_nome();
		this.aviso_descricao = dados.aviso_descricao();
		this.data_aviso = dados.data_aviso();
		this.sindico = dados.sindico();
	}
	
		
	public Aviso() {
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long aviso_id;
	
	@Column(name = "nome")
    private String aviso_nome;
	
	@Column(name = "descricao")
    private String aviso_descricao;
	
    private Date data_aviso;
    
    @ManyToOne
    @JoinColumn(name = "sindico_id")
    private Sindico sindico;
    
    
  //GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO
    
	public long getAviso_id() {
		return aviso_id;
	}
	public void setAviso_id(Integer aviso_id) {
		this.aviso_id = aviso_id;
	}
	public String getAviso_nome() {
		return aviso_nome;
	}
	public void setAviso_nome(String aviso_nome) {
		this.aviso_nome = aviso_nome;
	}
	public String getAviso_descricao() {
		return aviso_descricao;
	}
	public void setAviso_descricao(String aviso_descricao) {
		this.aviso_descricao = aviso_descricao;
	}
	public Date getData_aviso() {
		return data_aviso;
	}
	public void setData_aviso(Date data_aviso) {
		this.data_aviso = data_aviso;
	}
	public Sindico getSindico() {
		return sindico;
	}
	public void setSindico(Sindico sindico) {
		this.sindico = sindico;
	}

}
