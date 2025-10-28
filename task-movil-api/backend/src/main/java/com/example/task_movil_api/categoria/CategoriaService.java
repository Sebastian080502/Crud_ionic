package com.example.task_movil_api.categoria;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.task_movil_api.categoria.dto.CategoriaCreateDto;
import com.example.task_movil_api.categoria.dto.CategoriaResponseDto;
import com.example.task_movil_api.categoria.dto.CategoriaUpdateDto;
import com.example.task_movil_api.common.NotFoundException;

@Service
@Transactional
public class CategoriaService {

    private final CategoriaRepository repo;
    private final CategoriaMapper mapper;

    public CategoriaService(CategoriaRepository repo, CategoriaMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public CategoriaResponseDto create(CategoriaCreateDto dto) {
        var c = mapper.toEntity(dto);
        c = repo.save(c);
        return mapper.toDto(c);
    }

    @Transactional(readOnly = true)
    public List<CategoriaResponseDto> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaResponseDto findById(Long id) {
        var c = repo.findById(id).orElseThrow(() -> new NotFoundException("categoria no existe"));
        return mapper.toDto(c);
    }

    public CategoriaResponseDto update(Long id, CategoriaUpdateDto dto) {
        var c = repo.findById(id).orElseThrow(() -> new NotFoundException("categoria no existe"));
        c.setNombre(dto.nombre());
        c = repo.save(c);
        return mapper.toDto(c);
    }

    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("categoria no existe");
        }
        repo.deleteById(id);
    }
}
