package com.proyecto.alejandro.catan.moodtrack.Service.Habito;

import com.proyecto.alejandro.catan.moodtrack.Dto.Habito.HabitoCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Habito.HabitoDto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HabitoService {
    HabitoDto create(HabitoCreateDto createHabitoDto);

    List<HabitoDto> obtenerTodosHabitos();
    Optional<HabitoDto> obtenerHabitoPorId(Long uuid);
}
