package com.vinicius.condominiopro.login;

import com.vinicius.condominiopro.condomino.Condomino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Login")
@Table(name = "login")
@Getter
@Setter
@EqualsAndHashCode(of = "login_id")
public class Login {
	public Login() {
	}

	public Login(long login_id) {
		this.login_id = login_id;
	}

	public Login(String usuario) {
		this.usuario = usuario;
	}

	public Login(long login_id, String usuario, String senha, Condomino condomino) {
		this.login_id = login_id;
		this.usuario = usuario;
		this.senha = senha;
		this.condomino = condomino;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private long login_id;
	
    private String usuario;
    private String senha;
    
	@ManyToOne
	@JoinColumn(name = "condomino_id")
    private Condomino condomino;
	}
