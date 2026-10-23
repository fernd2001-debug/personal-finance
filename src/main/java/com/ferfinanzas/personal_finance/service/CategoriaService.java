package com.ferfinanzas.personal_finance.service;

import com.ferfinanzas.personal_finance.repository.CategoriaRepository;
import com.ferfinanzas.personal_finance.entity.Categoria;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    // Inyección por constructor (recomendada)
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Categoría no encontrada: " + id));
    }

    public Categoria crear(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria buscarPorNombre(String nombre) {
        return categoriaRepository.findByNombre(nombre);
    }
}