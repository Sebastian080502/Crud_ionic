package com.example.task_movil_api.categoria;

import org.springframework.stereotype.Component;

import com.example.task_movil_api.categoria.dto.CategoriaCreateDto;
import com.example.task_movil_api.categoria.dto.CategoriaResponseDto;

@Component
public class CategoriaMapper {

    public Categoria toEntity(CategoriaCreateDto dto) {
        var c = new Categoria();
        c.setNombre(dto.nombre());
        return c;
    }

    public CategoriaResponseDto toDto(Categoria c) {
        return new CategoriaResponseDto(
                c.getId(),
                c.getNombre(),
                c.getCreadaEn()
        );
    }
}
