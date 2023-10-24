package com.vinicius.condominiopro.services;

import com.vinicius.condominiopro.usuario.Usuario;
import com.vinicius.condominiopro.repository.UsuarioRepository;
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

    public void salvar(Usuario usuario){
        usuario.setLogin(usuario.getLogin());
        usuario.setPassword(usuario.getPassword());
        repository.save(usuario);
    }

    public Usuario retornarIdLogin(String loginUsuario) {
        Usuario usuario = repository.findByLogin(loginUsuario);
        return usuario;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
