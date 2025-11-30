package com.proyecto.alejandro.catan.moodtrack.Service.EntradaDiaria.Impl;

import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaDto;
import com.proyecto.alejandro.catan.moodtrack.Mapper.EntradaDiaria.EntradaDiariaMapper;
import com.proyecto.alejandro.catan.moodtrack.Model.EntradaDiaria;
import com.proyecto.alejandro.catan.moodtrack.Model.Habito;
import com.proyecto.alejandro.catan.moodtrack.Model.Usuario;
import com.proyecto.alejandro.catan.moodtrack.Repository.EntradaDiaria.EntradaDiariaRepository;
import com.proyecto.alejandro.catan.moodtrack.Repository.Habito.HabitoRepository;
import com.proyecto.alejandro.catan.moodtrack.Repository.Usuario.UsuarioRepository;
import com.proyecto.alejandro.catan.moodtrack.Service.EntradaDiaria.EntradaDiariaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class EntradaDiariaServiceImpl implements EntradaDiariaService {

    private final EntradaDiariaRepository entradaDiariaRepository;
    private final UsuarioRepository usuarioRepository;
    private final HabitoRepository habitoRepository;


    @Override
    public EntradaDiariaDto create(EntradaDiariaCreateDto createDto) {
        log.info("Creando entrada Diaria");
        UUID uuidUsuario = createDto.getUsuarioID();
        Optional<Usuario> usuario = usuarioRepository.findById(uuidUsuario);

        if (usuario.isEmpty()) {
            log.warn("Usuario no encontrado");
            throw new IllegalArgumentException("Usuario no Encontrado id: " + uuidUsuario);
        }

        List<Habito> habitos = List.of();
        if (createDto.getHabitosIds() != null && !createDto.getHabitosIds().isEmpty()) {
            habitos = habitoRepository.findAllById(createDto.getHabitosIds());
            if(habitos.size() != createDto.getHabitosIds().size()){
                log.warn("Alguno de los habitos no se ha encontrado");
            }
        }

        EntradaDiaria entradaDiaria = new EntradaDiaria();
        entradaDiaria.setUsuario(usuario.get());
        entradaDiaria.setHabitos(habitos);
        entradaDiaria.setFecha(createDto.getFecha());
        entradaDiaria.setReflexion(createDto.getReflexion());
        entradaDiaria.setEmocion(createDto.getEmocion());

        EntradaDiaria saved = entradaDiariaRepository.save(entradaDiaria);

        log.info("Entrada guardado exitosamente");
        return EntradaDiariaMapper.toDto(saved);
    }
}
