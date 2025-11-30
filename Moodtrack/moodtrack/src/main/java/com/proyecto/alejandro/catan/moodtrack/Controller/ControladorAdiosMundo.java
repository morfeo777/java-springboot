package com.proyecto.alejandro.catan.moodtrack.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adiosmundo")
public class ControladorAdiosMundo {

    @GetMapping("/despedida")  // /holamundo/despedida
    public String despedidaRequest(){

        return "Despedido despedida";
    }
}
