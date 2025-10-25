
package com.example.task_movil_api.producto;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_movil_api.producto.dto.ProductoCreateDto;
import com.example.task_movil_api.producto.dto.ProductoUpdateDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
    private final ProductoService service;
    public ProductoController(ProductoService service){ this.service = service; }

    @PostMapping
    public Producto create(@Valid @RequestBody ProductoCreateDto dto){ return service.create(dto); }

    @GetMapping
    public List<Producto> findAll(){ return service.findAll(); }

    @GetMapping("{id}")
    public Producto findById(@PathVariable Long id){ return service.findById(id); }

    @PatchMapping("{id}")
    public Producto update(@PathVariable Long id, @RequestBody ProductoUpdateDto dto){ return service.update(id, dto); }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }
}
