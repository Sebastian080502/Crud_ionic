package com.example.task_movil_api.producto.dto;
import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductoCreateDto(
    @NotBlank String nombre,
    @NotNull @DecimalMin("0.01") BigDecimal precio,
    @NotNull Long categoriaId
) {
    
}