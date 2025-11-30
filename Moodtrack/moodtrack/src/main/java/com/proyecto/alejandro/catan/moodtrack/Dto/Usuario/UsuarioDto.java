package com.proyecto.alejandro.catan.moodtrack.Dto.Usuario;
import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter

@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
    private UUID id;
    private String nombre;
    private String email;
    private PerfilUsuarioDto perfilUsuarioDto;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PerfilUsuarioDto getPerfilUsuarioDto() {
        return perfilUsuarioDto;
    }

    public void setPerfilUsuarioDto(PerfilUsuarioDto perfilUsuarioDto) {
        this.perfilUsuarioDto = perfilUsuarioDto;
    }
}
