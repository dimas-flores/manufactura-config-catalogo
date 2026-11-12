package com.ejemplo.mscatalogo.service.impl;
 
import com.ejemplo.mscatalogo.entity.Categoria;
import com.ejemplo.mscatalogo.repository.CategoriaRepository;
import com.ejemplo.mscatalogo.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
 
@Service
@RequiredArgsConstructor
public class CategoriaServiceImpl implements CategoriaService {
 
    private final CategoriaRepository categoriaRepository;
 
    @Override
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
 
    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }
 
    @Override
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
 
    @Override
    public Categoria actualizar(Integer id, Categoria categoria) {
        categoria.setId(id);
        return categoriaRepository.save(categoria);
    }
 
    @Override
    public void eliminar(Integer id) {
        categoriaRepository.deleteById(id);
    }
}
