package com.proyecto.alejandro.catan.moodtrack.Service.Usuario;

import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsuarioService {

    List<UsuarioDto> obtenerTodos(String nombre, String email, String colorFavorito);
    Optional<UsuarioDto> obtenerPorId(UUID id);
    UsuarioDto crearUsuario(UsuarioCreateDto usuarioCreateDto);

    UsuarioDto updateUsuario(UUID id, UsuarioCreateDto usuarioCreateDto);

    boolean eliminarUsuario(UUID id);

    UsuarioDto updatePerfilUsuario(UUID id, PerfilUsuarioDto perfilUsuarioDto);

}
