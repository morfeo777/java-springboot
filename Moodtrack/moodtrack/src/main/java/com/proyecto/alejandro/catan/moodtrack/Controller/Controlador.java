package com.proyecto.alejandro.catan.moodtrack.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/holamundo")
public class Controlador {

    @GetMapping("/saludo") // /holamundo/saludo
    public String holaMundoRequest(){
        return "Hola Mundo";
    }


}
