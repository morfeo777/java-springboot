package com.proyecto.alejandro.catan.moodtrack.Service.Usuario;

import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Mapper.Perfil.PerfilMapper;
import com.proyecto.alejandro.catan.moodtrack.Mapper.Usuario.UsuarioMapper;
import com.proyecto.alejandro.catan.moodtrack.Model.PerfilUsuario;
import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;
import com.proyecto.alejandro.catan.moodtrack.Repository.Usuario.Specification.UsuarioSpecifications;
import com.proyecto.alejandro.catan.moodtrack.Repository.Usuario.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService{

    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

   /* @Override  // Sin query param
    public List<UsuarioDto> obtenerTodos() {



        List<Usuario> usuarioList = usuarioRepository.findAll();

        return UsuarioMapper.toDtoList( usuarioList );
    }*/


    @Override // Con query param
    public List<UsuarioDto> obtenerTodos(String nombre, String email, String colorFavorito) {
        Specification<Usuario> spec = Specification.unrestricted();

        if(nombre != null && !nombre.isBlank()){
            spec = spec.and(UsuarioSpecifications.nombre( nombre ));
        }
        if(email != null && !email.isBlank()){
            spec = spec.and(UsuarioSpecifications.email( email ));
        }
        if(colorFavorito != null && !colorFavorito.isBlank()){
            spec = spec.and(UsuarioSpecifications.colorFavorito( colorFavorito ));
        }

        List<Usuario> usuarioList = usuarioRepository.findAll(spec);

        return UsuarioMapper.toDtoList( usuarioList );
    }

    @Override
    public Optional<UsuarioDto> obtenerPorId(UUID id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isPresent()) {
            Usuario usuarioEntity = usuario.get();
            return Optional.of( UsuarioMapper.toDto(usuarioEntity) );
        }
        return Optional.empty();
    }

    @Override
    public UsuarioDto crearUsuario(UsuarioCreateDto usuarioCreateDto) {

        Usuario usuario = UsuarioMapper.toEntity( usuarioCreateDto );
        usuario = usuarioRepository.save( usuario );
        return UsuarioMapper.toDto( usuario );
    }

    @Override
    public UsuarioDto updateUsuario(UUID id, UsuarioCreateDto usuarioCreateDto) {
        //1. Buscar el usuario por id
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            Optional<Usuario> usuarioExist = usuarioRepository.findByEmail( usuarioCreateDto.getEmail() );

            if (usuarioExist.isPresent() && !usuarioExist.get().getId().equals( id )) {
                throw new IllegalArgumentException("Mail no disponible");
            }

            //2. Setear campo a campo para actualizarlo
            Usuario usuarioEntity = usuario.get();
            usuarioEntity.setNombre( usuarioCreateDto.getNombre() );
            usuarioEntity.setEmail( usuarioCreateDto.getEmail() );

            PerfilUsuario perfilUsuario = usuarioEntity.getPerfil();
            //3. Chequear si no tiene perfil crearlo, sino actualizar sus campos
            if(perfilUsuario == null) {
                perfilUsuario = PerfilMapper.toEntity( usuarioCreateDto.getPerfilUsuarioDto() );
                usuarioEntity.setPerfil( perfilUsuario );
            }else{
                perfilUsuario.setBio( usuarioCreateDto.getPerfilUsuarioDto().getBio() );
                perfilUsuario.setColorFavorito( usuarioCreateDto.getPerfilUsuarioDto().getColorFavorito() );
                perfilUsuario.setFraseDelDia( usuarioCreateDto.getPerfilUsuarioDto().getFraseDelDia() );
            }

            //4. Guardarlo (actualizarlo)
            Usuario usuarioActualizado = usuarioRepository.save( usuarioEntity );
            log.info("Usuario actualizado con id {}", usuarioActualizado.getId());

            //5 devolver el UsuarioDTO.
            return UsuarioMapper.toDto( usuarioActualizado );

        }
        return null;
    }

    @Override
    public boolean eliminarUsuario(UUID id) {

        if ( usuarioRepository.existsById(id) ){
            usuarioRepository.deleteById(id);
            return true;
        }

        return false;
    }

    @Override // Con Path Variable
    public UsuarioDto updatePerfilUsuario(UUID id, PerfilUsuarioDto perfilUsuarioDto) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        UsuarioCreateDto usuarioCreateDto = UsuarioMapper.toCreateDto(usuario.get());

        if (usuario.isPresent()) {
            //Optional<Usuario> usuarioExist = usuarioRepository.findByEmail( usuarioCreateDto.getEmail() );
            Optional<Usuario> usuarioExist = usuarioRepository.findByEmail(usuario.get().getEmail() );

            if (usuarioExist.isPresent() && !usuarioExist.get().getId().equals( id )) {
                throw new IllegalArgumentException("Mail no disponible");
            }

            Usuario usuarioEntity = usuario.get();

            PerfilUsuario perfilUsuario = usuarioEntity.getPerfil();
            if(perfilUsuario == null) {
                perfilUsuario = PerfilMapper.toEntity( perfilUsuarioDto);
                usuarioEntity.setPerfil( perfilUsuario );
            }else{
                perfilUsuario.setBio( perfilUsuarioDto.getBio() );
                perfilUsuario.setColorFavorito( perfilUsuarioDto.getColorFavorito() );
                perfilUsuario.setFraseDelDia( perfilUsuarioDto.getFraseDelDia() );
            }

            Usuario usuarioActualizado = usuarioRepository.save( usuarioEntity );
            log.info("Perfil de usuario id: {} actualizado correctamente", usuarioActualizado.getId());

            return UsuarioMapper.toDto( usuarioActualizado );

        }
        return null;
    }

}

