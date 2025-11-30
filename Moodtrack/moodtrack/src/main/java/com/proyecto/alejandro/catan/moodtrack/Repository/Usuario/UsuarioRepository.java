package com.proyecto.alejandro.catan.moodtrack.Repository.Usuario;

import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAllByNombreStartingWith(String nombre);
}
