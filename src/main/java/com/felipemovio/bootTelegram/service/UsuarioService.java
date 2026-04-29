package com.felipemovio.bootTelegram.service;

import com.felipemovio.bootTelegram.entity.Usuario;
import com.felipemovio.bootTelegram.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarSeNaoExistir(Long chatId, String nome, String username) {
        if (!repository.existsById(chatId)) {
            Usuario usuario = new Usuario(chatId, nome, username);
            repository.save(usuario);
        }
    }
}