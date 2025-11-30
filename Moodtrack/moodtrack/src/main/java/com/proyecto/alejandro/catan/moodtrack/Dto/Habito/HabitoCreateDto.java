package com.proyecto.alejandro.catan.moodtrack.Dto.Habito;

import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Model.EntradaDiaria;
import com.proyecto.alejandro.catan.moodtrack.Model.NivelDeImportanciaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitoCreateDto {

    private UUID usuarioId;
    private LocalDate fecha;
    private String descripcion;
    private NivelDeImportanciaEnum nivelDeImportanciaEnum;
    private List<EntradaDiaria> entradas;
}
