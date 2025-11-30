package com.proyecto.alejandro.catan.moodtrack.Controller;

import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaCreateDto;
import com.proyecto.alejandro.catan.moodtrack.Dto.EntradaDiaria.EntradaDiariaDto;
import com.proyecto.alejandro.catan.moodtrack.Service.EntradaDiaria.EntradaDiariaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/entrada-diaria")
@RequiredArgsConstructor
@Slf4j
@Validated
public class EntradaController {

    private final EntradaDiariaService entradaDiariaService;

    @PostMapping
    public ResponseEntity<EntradaDiariaDto> crear(@Valid @RequestBody EntradaDiariaCreateDto emtradaDiariaCreateDto) {
        try {
            EntradaDiariaDto entradaCreada = entradaDiariaService.create(emtradaDiariaCreateDto);
            return ResponseEntity.ok( entradaCreada );
        }catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.badRequest().build();
        }catch (Exception e){
            log.error("Error desconocido", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
