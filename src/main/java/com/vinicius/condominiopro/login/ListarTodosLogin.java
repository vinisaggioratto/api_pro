package com.vinicius.condominiopro.login;

public record ListarTodosLogin(
		long login_id,
		String usuario,
		String condomino
		) {

	public ListarTodosLogin(Login login) {
		this(login.getLogin_id(), login.getUsuario(), login.getCondomino().getNome());
	}
}
