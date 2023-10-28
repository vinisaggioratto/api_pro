package com.vinicius.api_pro.service;

import com.vinicius.api_pro.data.UsuarioEntity;
import com.vinicius.api_pro.data.UsuarioRepository;
import com.vinicius.api_pro.exception.ResourceNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity getUsuarioId(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new ResourceNotFoundException("Usuário não encontrado" + id));
    }

    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        usuario.setId(null);
        String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
        usuario.setPassword(encryptedPassword);
        repository.save(usuario);
        return usuario;
    }

    public UsuarioEntity atualizarUsuario(Long id, UsuarioEntity usuario) {

        UsuarioEntity user = getUsuarioId(id);

        String encryptedPassword = new BCryptPasswordEncoder().encode(usuario.getPassword());
        user.setPassword(encryptedPassword);
        user.setPerfil(usuario.getPerfil());

        repository.save(user);
        return user;
    }

    public List<UsuarioEntity> listarTodosUsuarios() {
        return repository.findAll();
    }

    public List<UsuarioEntity> retornarUsuarioList(String loginUsuario) {
        List<UsuarioEntity> usuario = repository.findByLogin(loginUsuario);
        return usuario;
    }

    public void deletarUsuario(Long id) {
        UsuarioEntity usuario = getUsuarioId(id);
        repository.deleteById(usuario.getId());
    }

    public List<UsuarioEntity> validarLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password);
    }

}
