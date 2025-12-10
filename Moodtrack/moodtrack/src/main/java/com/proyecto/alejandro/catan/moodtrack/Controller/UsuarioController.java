package com.proyecto.alejandro.catan.moodtrack.Controller;

import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;
import com.proyecto.alejandro.catan.moodtrack.Service.Usuario.UsuarioService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/usuarios")
@Slf4j
public class UsuarioController {


    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping // /api/v1/usuarios/getUsuarios/ ?
    public List<UsuarioDto> getUsuarios(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String colorFavorito
    ) {

        List<UsuarioDto> usuarios = usuarioService.obtenerTodos(nombre, email, colorFavorito);
        return usuarios;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDto> getUsuarioById(
            @PathVariable(name = "id") UUID id
    ) {
        Optional<UsuarioDto> usuario = usuarioService.obtenerPorId(id);

        if( usuario.isPresent() ){
            return ResponseEntity.ok( usuario.get() ) ;
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<UsuarioDto> createUsuario(
            @Valid @RequestBody UsuarioCreateDto usuarioCreateDto
    ){
        UsuarioDto usuarioCreado = usuarioService.crearUsuario(usuarioCreateDto);
        //return ResponseEntity.ok( usuarioCreado );
        return ResponseEntity
                .created( URI.create( "/api/v1/usuarios/" + usuarioCreado.getId() ) )
                .body( usuarioCreado ) ;
    }

    @PutMapping("/{id}") // PathVariable es el {id}
    public ResponseEntity<UsuarioDto> updateUsuario( @PathVariable(name = "id") UUID id, @Valid @RequestBody UsuarioCreateDto usuarioCreateDto){
        log.info("Solicitud para actualizar usuario con id {}", id);
        UsuarioDto usuarioDto = usuarioService.updateUsuario( id, usuarioCreateDto );
        if( usuarioDto == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( usuarioDto );
    }

    @PutMapping("/{id}/perfil") // PathVariable es el {id}  /{id}/perfil
    public ResponseEntity<UsuarioDto> updatePerfilUsuario(@PathVariable(name = "id") UUID id, @Valid @RequestBody PerfilUsuarioDto perfilUsuarioDto){
        log.info("Solicitud para actualizar perfil de usuario con id {}", id);
        UsuarioDto usuarioDto = usuarioService.updatePerfilUsuario( id, perfilUsuarioDto );
        if( usuarioDto == null ){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( usuarioDto );
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario( @PathVariable(name = "id") UUID id ){
        boolean wasDeleted = usuarioService.eliminarUsuario( id );
        if( !wasDeleted ){
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }


}
