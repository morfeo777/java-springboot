package com.proyecto.alejandro.catan.moodtrack.Dto.Perfil;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuarioDto {

  // private Long id;
   @NotBlank(message = "La biografia no puede ser vacia")
   @Size(min = 2, max = 500, message = "La Biografia tiene que estar entre 2 y 500 caracteres")
   private String bio;
   @NotBlank(message = "El color favorito no puede ser vacio")
   @Size(min = 2, max = 25, message = "El color favorito tiene que estar entre 2 y 25 caracteres")
   private String colorFavorito;
   @NotBlank(message = "La Frase del dia no puede ser vacia")
   @Size(max = 700, message = "La frase del dia no puede superar los 700 caracteres")
   private String fraseDelDia;

}


