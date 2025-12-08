package com.proyecto.alejandro.catan.moodtrack.Repository.Usuario.Specification;

import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;
import org.springframework.data.jpa.domain.Specification;

public final class UsuarioSpecifications {

    public UsuarioSpecifications() {
    }

    public static Specification<Usuario> nombre(final String nombre) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower( root.get("nombre")), "%" + nombre.toLowerCase() + "%"
                ));
    }

    public static Specification<Usuario> email(String email) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower( root.get("email")), "%" + email.toLowerCase() + "%"
                ));
    }

    public static Specification<Usuario> colorFavorito(String colorFavorito) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        criteriaBuilder.lower(
                                root.join("perfil").get("colorFavorito")
                        ),
                        colorFavorito.toLowerCase()
                )
        );
    }
}
