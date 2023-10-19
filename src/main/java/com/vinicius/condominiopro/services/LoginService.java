package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.login.Login;
import com.vinicius.condominiopro.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService{

    @Autowired
    private LoginRepository repository;

    @Autowired
    private CondominoService condominoService;

    public List<Login> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Login login){
        login.setUsuario(login.getUsuario());
        login.setSenha(login.getSenha());
        repository.save(login);
    }

    public Login retornarIdLogin(String loginUsuario) {
        Login login = repository.findByUsuario(loginUsuario);
        return login;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
