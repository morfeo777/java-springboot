package com.proyecto.alejandro.catan.moodtrack.Dto.Perfil;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

//@Getter No me funcionan ni el Getter ni el Setter de loombok
//@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuarioDto {

   private Long id;
   @NotBlank(message = "La biografia no puede ser vacia")
   private String bio;
   @NotBlank(message = "El color favorito no puede ser vacio")
   private String colorFavorito;
   @NotBlank(message = "La Frase del dia no puede ser vacia")
   private String fraseDelDia;

   public Long getId() {
        return id;
   }
   public String getBio() {
        return bio;
   }

   public String getColorFavorito() {
       return colorFavorito;
   }

   public String getFraseDelDia() {
      return fraseDelDia;
   }

   public void setId(Long id) {
     this.id = id;
   }

   public void setBio(String bio) {
        this.bio = bio;
   }

   public void setColorFavorito(String colorFavorito) {
       this.colorFavorito = colorFavorito;
   }

   public void setFraseDelDia(String fraseDelDia) {
       this.fraseDelDia = fraseDelDia;
   }
}


