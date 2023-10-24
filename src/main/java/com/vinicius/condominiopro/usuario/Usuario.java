package com.vinicius.condominiopro.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity(name = "Usuario")
@Table(name = "usuario")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Usuario {
	public Usuario() {
	}

	public Usuario(Long login_id) {
		this.id = login_id;
	}

	public Usuario(String login) {
		this.login = login;
	}

	public Usuario(String login, String password) {
		this.login = login;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String login;
    private String password;
	private String perfil;
	}
