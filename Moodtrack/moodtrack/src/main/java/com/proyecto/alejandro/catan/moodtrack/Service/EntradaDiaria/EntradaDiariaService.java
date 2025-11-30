package com.proyecto.alejandro.catan.moodtrack.Service.EntradaDiaria;

import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaDto;

public interface EntradaDiariaService {

    EntradaDiariaDto create(EntradaDiariaCreateDto createDto);
}
