package com.felipemovio.bootTelegram.repository;

import com.felipemovio.bootTelegram.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
