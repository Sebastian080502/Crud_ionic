
package com.example.task_movil_api.producto;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.task_movil_api.categoria.CategoriaRepository;
import com.example.task_movil_api.producto.dto.ProductoCreateDto;
import com.example.task_movil_api.producto.dto.ProductoUpdateDto;

@Service @Transactional
public class ProductoService {
    private final ProductoRepository repo;
    private final CategoriaRepository categoriaRepo;

    public ProductoService(ProductoRepository repo, CategoriaRepository categoriaRepo){
        this.repo = repo; this.categoriaRepo = categoriaRepo;
    }

    public Producto create(ProductoCreateDto dto){
        var cat = categoriaRepo.findById(dto.categoriaId())
          .orElseThrow(() -> new RuntimeException("Categoría no existe"));
        var p = new Producto();
        p.setNombre(dto.nombre());
        p.setPrecio(dto.precio());
        p.setCategoria(cat);
        return repo.save(p);
    }

    public List<Producto> findAll(){ return repo.findAll(); }
    public Producto findById(Long id){ return repo.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado")); }

    public Producto update(Long id, ProductoUpdateDto dto){
        var p = findById(id);
        if (dto.nombre()!=null && !dto.nombre().isBlank()) p.setNombre(dto.nombre());
        if (dto.precio()!=null) p.setPrecio(dto.precio());
        if (dto.categoriaId()!=null){
            var cat = categoriaRepo.findById(dto.categoriaId())
              .orElseThrow(() -> new RuntimeException("Categoría no existe"));
            p.setCategoria(cat);
        }
        return repo.save(p);
    }
    public void delete(Long id){ repo.delete(findById(id)); }
}
