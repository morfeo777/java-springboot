package com.proyecto.alejandro.catan.moodtrack.Mapper.Usuario;

import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Mapper.Perfil.PerfilMapper;
import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;

import java.util.List;

public final class UsuarioMapper {

    public UsuarioMapper() {
    }

    public static UsuarioDto toDto(Usuario usuario){

        if(usuario == null) return null;

        UsuarioDto usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuario.getId());
        usuarioDto.setNombre(usuario.getNombre());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setPerfilUsuarioDto(PerfilMapper.toDto(usuario.getPerfil()));
        return usuarioDto;

    }

    public static List<UsuarioDto> toDtoList(List<Usuario> usuarios){
        return usuarios.stream()
                .map(usuario -> toDto(usuario))
                .toList();
    }


    public static Usuario toEntity(UsuarioCreateDto usuarioCreateDto){
        if(usuarioCreateDto == null) return null;

        Usuario usuario = new Usuario();
        usuario.setEmail( usuarioCreateDto.getEmail() );
        usuario.setNombre( usuarioCreateDto.getNombre() );
        usuario.setPerfil( PerfilMapper.toEntity( usuarioCreateDto.getPerfilUsuarioDto() ) );
        usuario.setEntradasDiarias( List.of() );
        return usuario;

    }
}
