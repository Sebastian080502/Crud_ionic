package com.example.task_movil_api.categoria.dto;
import jakarta.validation.constraints.NotBlank;


public record CategoriaCreateDto(
    @NotBlank String nombre
    ) {
    
}