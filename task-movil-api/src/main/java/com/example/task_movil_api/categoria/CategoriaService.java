
package com.example.task_movil_api.categoria;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.task_movil_api.categoria.dto.CategoriaCreateDto;
import com.example.task_movil_api.categoria.dto.CategoriaUpdateDto;

@Service @Transactional
public class CategoriaService {
    private final CategoriaRepository repo;
    public CategoriaService(CategoriaRepository repo){ this.repo = repo; }

    public Categoria create(CategoriaCreateDto dto){
        var c = new Categoria();
        c.setNombre(dto.nombre());
        return repo.save(c);
    }
    public List<Categoria> findAll(){ return repo.findAll(); }
    public Categoria findById(Long id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }
    public Categoria update(Long id, CategoriaUpdateDto dto){
        var c = findById(id);
        if (dto.nombre()!=null && !dto.nombre().isBlank()) c.setNombre(dto.nombre());
        return repo.save(c);
    }
    public void delete(Long id){ repo.delete(findById(id)); }
}
