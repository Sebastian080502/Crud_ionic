package com.example.task_movil_api.producto.dto;

import java.math.BigDecimal;
import java.time.Instant;

import com.example.task_movil_api.categoria.dto.CategoriaResponseDto;

public record ProductoResponseDto(
        Long id,
        String nombre,
        BigDecimal precio,
        Instant creadoEn,
        CategoriaResponseDto categoria
) {}
