package com.proyecto.alejandro.catan.moodtrack.Dto.Usuario;

import com.proyecto.alejandro.catan.moodtrack.Dto.Perfil.PerfilUsuarioDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateDto {

    @NotBlank(message = "El nombre del usuario no puede ser vacio")
    private String nombre;

    @NotBlank(message = "El email del usuario no puede ser vacio")
    private String email;

    @Valid
    private PerfilUsuarioDto perfilUsuarioDto;

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
