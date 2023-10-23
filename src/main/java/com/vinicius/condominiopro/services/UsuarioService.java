package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.repository.UsuarioRepository;
import com.vinicius.condominiopro.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private CondominoService condominoService;

    public List<Usuario> listar(){
        return repository.findAll().stream().toList();
    }

    public void salvar(Usuario login){
        login.setUsuario(login.getUsuario());
        login.setSenha(login.getSenha());
        repository.save(login);
    }

    public Usuario retornarIdLogin(String loginUsuario) {
        Usuario usuario = (Usuario) repository.findByUsuario(loginUsuario);
        return usuario;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
