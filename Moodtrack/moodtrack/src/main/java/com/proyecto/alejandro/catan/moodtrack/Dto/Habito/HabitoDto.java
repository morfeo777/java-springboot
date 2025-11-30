package com.proyecto.alejandro.catan.moodtrack.Dto.Habito;

import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Model.EntradaDiaria;
import com.proyecto.alejandro.catan.moodtrack.Model.NivelDeImportanciaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitoDto {

    private Long id;
    private String descripcion;
    private NivelDeImportanciaEnum nivelDeImportanciaEnum;
    private UsuarioDto usuarioDto;
    private List<EntradaDiaria> entradasDiarias;

}
