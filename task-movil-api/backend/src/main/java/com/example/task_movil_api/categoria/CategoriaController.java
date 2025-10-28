package com.example.task_movil_api.categoria;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_movil_api.categoria.dto.CategoriaCreateDto;
import com.example.task_movil_api.categoria.dto.CategoriaResponseDto;
import com.example.task_movil_api.categoria.dto.CategoriaUpdateDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public CategoriaResponseDto create(@Valid @RequestBody CategoriaCreateDto dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<CategoriaResponseDto> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaResponseDto get(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public CategoriaResponseDto update(@PathVariable Long id,
                                       @Valid @RequestBody CategoriaUpdateDto dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
