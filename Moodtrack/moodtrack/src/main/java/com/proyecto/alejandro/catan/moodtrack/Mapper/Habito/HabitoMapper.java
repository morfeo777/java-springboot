package com.proyecto.alejandro.catan.moodtrack.Mapper.Habito;
import com.proyecto.alejandro.catan.moodtrack.Dto.Habito.HabitoDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Model.Habito;
import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;

import java.util.List;

public class HabitoMapper {

    public HabitoMapper() {
    }

    public static HabitoDto toDto(Habito habito) {
        if (habito == null) return null;

        HabitoDto dto = new HabitoDto();
        dto.setId(habito.getId());
        dto.setDescripcion(habito.getDescripcion());
        dto.setNivelDeImportanciaEnum(habito.getNivelDeImportanciaEnum());
        dto.setEntradasDiarias(habito.getEntradas());

        return dto;
    }

    public static List<HabitoDto> toDtoList(List<Habito> habitos){
        return habitos.stream()
                .map(habito -> toDto(habito))
                .toList();
    }

}
