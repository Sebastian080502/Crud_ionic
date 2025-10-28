package com.example.task_movil_api.producto;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.task_movil_api.categoria.CategoriaRepository;
import com.example.task_movil_api.common.NotFoundException;
import com.example.task_movil_api.producto.dto.ProductoCreateDto;
import com.example.task_movil_api.producto.dto.ProductoResponseDto;
import com.example.task_movil_api.producto.dto.ProductoUpdateDto;

@Service
@Transactional
public class ProductoService {

    private final ProductoRepository productoRepo;
    private final CategoriaRepository categoriaRepo;
    private final ProductoMapper mapper;

    public ProductoService(ProductoRepository productoRepo,
                           CategoriaRepository categoriaRepo,
                           ProductoMapper mapper) {
        this.productoRepo = productoRepo;
        this.categoriaRepo = categoriaRepo;
        this.mapper = mapper;
    }

    public ProductoResponseDto create(ProductoCreateDto dto) {
        var categoria = categoriaRepo.findById(dto.categoriaId())
                .orElseThrow(() -> new NotFoundException("categoria no existe"));

        var p = new Producto();
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setCategoria(categoria);

        p = productoRepo.save(p);
        return mapper.toDto(p);
    }

    @Transactional(readOnly = true)
    public List<ProductoResponseDto> findAll() {
        return productoRepo.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public ProductoResponseDto findById(Long id) {
        var p = productoRepo.findById(id).orElseThrow(() -> new NotFoundException("producto no existe"));
        return mapper.toDto(p);
    }

    public ProductoResponseDto update(Long id, ProductoUpdateDto dto) {
        var p = productoRepo.findById(id).orElseThrow(() -> new NotFoundException("producto no existe"));
        var categoria = categoriaRepo.findById(dto.categoriaId())
                .orElseThrow(() -> new NotFoundException("categoria no existe"));

        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setCategoria(categoria);

        p = productoRepo.save(p);
        return mapper.toDto(p);
    }

    public void delete(Long id) {
        if (!productoRepo.existsById(id)) {
            throw new NotFoundException("producto no existe");
        }
        productoRepo.deleteById(id);
    }
}
