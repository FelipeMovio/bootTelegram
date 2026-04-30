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

    public void salvarOuAtualizar(String chatId, String nome, String comando) {

        Usuario usuario = repository.findById(chatId)
                .orElse(new Usuario());

        usuario.setChatId(chatId);
        usuario.setNome(nome);
        usuario.setUltimoComando(comando);

        repository.save(usuario);
    }
}