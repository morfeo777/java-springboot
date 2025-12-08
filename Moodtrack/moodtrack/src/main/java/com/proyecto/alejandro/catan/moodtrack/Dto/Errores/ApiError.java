package com.proyecto.alejandro.catan.moodtrack.Dto.Errores;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
public class ApiError {

    private LocalDateTime timeStamp;
    private int status;
    private String error;
    private String message;
    private String path;
    private Map<String, String> validationErrors;

}
