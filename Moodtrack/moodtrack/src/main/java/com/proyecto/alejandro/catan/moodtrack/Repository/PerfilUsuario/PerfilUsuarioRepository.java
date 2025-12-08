package com.proyecto.alejandro.catan.moodtrack.Repository.PerfilUsuario;

import com.proyecto.alejandro.catan.moodtrack.Model.PerfilUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, UUID> {

}
