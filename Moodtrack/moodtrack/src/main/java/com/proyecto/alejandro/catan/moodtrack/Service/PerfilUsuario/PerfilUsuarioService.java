package com.proyecto.alejandro.catan.moodtrack.Service.PerfilUsuario;

import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Model.PerfilUsuario;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PerfilUsuarioService {

    List<PerfilUsuarioDto> obtenerPerfiles();

    Optional<PerfilUsuarioDto> obtenerPerfilPorId(UUID uuid);

    PerfilUsuarioDto crearPerfilDto(PerfilUsuarioCreateDto perfilUsuarioCreateDto);

    PerfilUsuarioDto updatePerfil(UUID id, PerfilUsuarioCreateDto perfilUsuarioCreateDto);




}
