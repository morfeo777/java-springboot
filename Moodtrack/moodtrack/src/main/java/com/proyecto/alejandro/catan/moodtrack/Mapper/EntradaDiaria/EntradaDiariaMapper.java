package com.proyecto.alejandro.catan.moodtrack.Mapper.EntradaDiaria;

import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaDto;
import com.proyecto.alejandro.catan.moodtrack.Mapper.Usuario.UsuarioMapper;
import com.proyecto.alejandro.catan.moodtrack.Model.EntradaDiaria;

public final class EntradaDiariaMapper {

    public EntradaDiariaMapper() {
    }
    public static EntradaDiariaDto toDto(EntradaDiaria entradaDiaria) {
        if (entradaDiaria == null) return null;


        EntradaDiariaDto dto = new EntradaDiariaDto();
        dto.setId(entradaDiaria.getId());
        dto.setFecha(entradaDiaria.getFecha());
        dto.setEmocion(entradaDiaria.getEmocion());
        dto.setReflexion(entradaDiaria.getReflexion());
        dto.setUsuarioDto(UsuarioMapper.toDto(entradaDiaria.getUsuario()));

        if ( entradaDiaria.getHabitos() != null && !entradaDiaria.getHabitos().isEmpty()){
            dto.setHabitosDescripciones(
                    entradaDiaria.getHabitos().stream()
                            .map(habito -> habito.getDescripcion())
                            .toList()
            );
        }

        return dto;
    }
}
