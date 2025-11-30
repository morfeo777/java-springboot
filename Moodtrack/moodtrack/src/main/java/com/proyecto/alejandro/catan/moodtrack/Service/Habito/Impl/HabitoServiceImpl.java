package com.proyecto.alejandro.catan.moodtrack.Service.Habito.Impl;

import com.proyecto.alejandro.catan.moodtrack.Dto.Habito.HabitoCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Habito.HabitoDto;
import com.proyecto.alejandro.catan.moodtrack.Mapper.Habito.HabitoMapper;
import com.proyecto.alejandro.catan.moodtrack.Model.EntradaDiaria;
import com.proyecto.alejandro.catan.moodtrack.Model.Habito;
import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;
import com.proyecto.alejandro.catan.moodtrack.Repository.EntradaDiaria.EntradaDiariaRepository;
import com.proyecto.alejandro.catan.moodtrack.Repository.Habito.HabitoRepository;
import com.proyecto.alejandro.catan.moodtrack.Repository.Usuario.UsuarioRepository;
import com.proyecto.alejandro.catan.moodtrack.Service.Habito.HabitoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class HabitoServiceImpl implements HabitoService {

    private final HabitoRepository habitoRepository;
    private final UsuarioRepository usuarioRepository;
    private final EntradaDiariaRepository entradaDiariaRepository;

    @Override
    public HabitoDto create(HabitoCreateDto createHabitoDto) {
        UUID uuidUsuario = createHabitoDto.getUsuarioId();
        Optional<Usuario> usuario = usuarioRepository.findById(uuidUsuario);

        if (usuario.isEmpty()) {
            throw new IllegalArgumentException("Usuario no Encontrado id: " + uuidUsuario);
        }

        List<EntradaDiaria> entradasDiarias = List.of();
        if (createHabitoDto.getEntradas() != null && !createHabitoDto.getEntradas().isEmpty()) {
            entradasDiarias = entradaDiariaRepository.findAll();
            if (entradasDiarias.size() != createHabitoDto.getEntradas().size()) {
                log.warn("Algunas de los entradas no se han encontrado");
            }
        }

        Habito habito = new Habito();
        habito.setDescripcion(createHabitoDto.getDescripcion());
        habito.setNivelDeImportanciaEnum(createHabitoDto.getNivelDeImportanciaEnum());
        habito.setEntradas(entradasDiarias);

        Habito saved = habitoRepository.save(habito);

        log.info("Habito guardado exitosamente");
        return HabitoMapper.toDto(saved);
    }

    @Override
    public List<HabitoDto> obtenerTodosHabitos() {
        List<Habito> habitoList = habitoRepository.findAll();
        return HabitoMapper.toDtoList(habitoList);
    }

    @Override
    public Optional<HabitoDto> obtenerHabitoPorId(Long uuid) {
        Optional<Habito> habito = habitoRepository.findById(uuid);
        if (habito.isPresent()) {
            Habito habitoEntity = habito.get();
            return Optional.of(HabitoMapper.toDto(habitoEntity));
        }
        return Optional.empty();
    }
}
