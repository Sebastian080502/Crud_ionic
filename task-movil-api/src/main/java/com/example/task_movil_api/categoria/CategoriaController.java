
package com.example.task_movil_api.categoria;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.task_movil_api.categoria.dto.CategoriaCreateDto;
import com.example.task_movil_api.categoria.dto.CategoriaUpdateDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService service;
    public CategoriaController(CategoriaService service){ this.service = service; }

    @PostMapping
    public Categoria create(@Valid @RequestBody CategoriaCreateDto dto){ return service.create(dto); }

    @GetMapping
    public List<Categoria> findAll(){ return service.findAll(); }

    @GetMapping("{id}")
    public Categoria findById(@PathVariable Long id){ return service.findById(id); }

    @PatchMapping("{id}")
    public Categoria update(@PathVariable Long id, @RequestBody CategoriaUpdateDto dto){ return service.update(id, dto); }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){ service.delete(id); }
}
