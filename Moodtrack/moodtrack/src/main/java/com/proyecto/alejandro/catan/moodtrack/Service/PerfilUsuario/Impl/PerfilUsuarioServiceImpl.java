package com.proyecto.alejandro.catan.moodtrack.Service.PerfilUsuario.Impl;

import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;
import com.proyecto.alejandro.catan.moodtrack.Repository.PerfilUsuario.PerfilUsuarioRepository;
import com.proyecto.alejandro.catan.moodtrack.Repository.Usuario.UsuarioRepository;
import com.proyecto.alejandro.catan.moodtrack.Service.PerfilUsuario.PerfilUsuarioService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PerfilUsuarioServiceImpl implements PerfilUsuarioService {


    private UsuarioRepository usuarioRepository;
    private PerfilUsuarioRepository perfilUsuarioRepository;

    @Override
    public List<PerfilUsuarioDto> obtenerPerfiles() {
        return List.of();
    }

    @Override
    public Optional<PerfilUsuarioDto> obtenerPerfilPorId(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public PerfilUsuarioDto crearPerfilDto(PerfilUsuarioCreateDto perfilUsuarioCreateDto) {
        return null;
    }

    @Override
    public PerfilUsuarioDto updatePerfil(UUID id, PerfilUsuarioCreateDto perfilUsuarioCreateDto) {
        //1. Buscar el usuario por id
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) { // El Usuario Existe

        }

        return null;
    }
}
