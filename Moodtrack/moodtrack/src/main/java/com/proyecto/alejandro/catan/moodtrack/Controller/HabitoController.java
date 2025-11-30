package com.proyecto.alejandro.catan.moodtrack.Controller;

import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Habito.HabitoCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Habito.HabitoDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.Usuario.UsuarioDto;
import com.proyecto.alejandro.catan.moodtrack.Service.Habito.HabitoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/habito")
@RequiredArgsConstructor
@Slf4j
@Validated
public class HabitoController {

    private final HabitoService habitoService;

    @PostMapping
    public ResponseEntity<HabitoDto> crearHabito(@Valid @RequestBody HabitoCreateDto habitoCreateDto){
        try {
            HabitoDto habitoCreado = habitoService.create(habitoCreateDto);
            return ResponseEntity.ok(habitoCreado);
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            log.error("Error desconocido", e);
            return ResponseEntity.internalServerError().build();
        }
    }


    @GetMapping
    public List<HabitoDto> getHabitos() {

        List<HabitoDto> habitos = habitoService.obtenerTodosHabitos();
        return habitos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitoDto> getHabitoById(
            @PathVariable(name = "id") Long id
    ) {
        Optional<HabitoDto> habito = habitoService.obtenerHabitoPorId(id);

        if( habito.isPresent() ){
            return ResponseEntity.ok( habito.get() ) ;
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
