package com.example.task_movil_api.producto;

import org.springframework.stereotype.Component;

import com.example.task_movil_api.categoria.CategoriaMapper;
import com.example.task_movil_api.producto.dto.ProductoResponseDto;

@Component
public class ProductoMapper {

    private final CategoriaMapper categoriaMapper;

    public ProductoMapper(CategoriaMapper categoriaMapper) {
        this.categoriaMapper = categoriaMapper;
    }

    public ProductoResponseDto toDto(Producto p) {
        return new ProductoResponseDto(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getCreadoEn(),
                categoriaMapper.toDto(p.getCategoria())
        );
    }
}
