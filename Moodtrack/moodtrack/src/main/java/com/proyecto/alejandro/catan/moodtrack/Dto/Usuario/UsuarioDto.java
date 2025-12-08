package com.proyecto.alejandro.catan.moodtrack.Dto.Usuario;
import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private UUID id;
    private String nombre;
    private String email;
    private PerfilUsuarioDto perfilUsuarioDto;

}
