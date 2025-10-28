package com.example.task_movil_api.categoria.dto;
import java.time.Instant;

public record CategoriaResponseDto(
    Long id,
    String nombre,
    Instant creadaEn
) {

}

