package com.CGDJ6.transportes.repositories;

import com.CGDJ6.transportes.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
}
