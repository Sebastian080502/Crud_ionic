package com.example.task_movil_api.producto.dto;
import java.math.BigDecimal;
public record ProductoUpdateDto(String nombre, BigDecimal precio, Long categoriaId) {
    
}