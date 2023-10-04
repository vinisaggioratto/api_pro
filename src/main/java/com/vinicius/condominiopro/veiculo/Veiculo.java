package com.vinicius.condominiopro.veiculo;

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

@Entity(name = "Veiculo")
@Table(name = "veiculos")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "veiculo_id")
public class Veiculo {


	public Veiculo(DadosCadastrarVeiculo dados) {
		super();
		this.placa = dados.placa();
		this.marca = dados.marca();
		this.cor = dados.cor();
		this.ativo = dados.ativo();
		this.modelo = dados.modelo();
		this.condomino = dados.condomino();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long veiculo_id;
	
	
    private String placa;
    private String marca;
    private String cor;
    private String ativo;
    private String modelo;
    
	@ManyToOne
	@JoinColumn(name = "condomino_id")
    private Condomino condomino;
	
	
	//GETTER E SETTER - LOMBOK NÃO ESTÁ FUNCIONANDO

	public long getVeiculo_id() {
		return veiculo_id;
	}

	public void setVeiculo_id(Integer veiculo_id) {
		this.veiculo_id = veiculo_id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Condomino getCondomino() {
		return condomino;
	}

	public void setCondomino(Condomino condomino) {
		this.condomino = condomino;
	}
	
}
