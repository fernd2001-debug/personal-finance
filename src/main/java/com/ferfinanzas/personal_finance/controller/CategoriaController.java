package com.ferfinanzas.personal_finance.controller;


import com.ferfinanzas.personal_finance.entity.Categoria;
import com.ferfinanzas.personal_finance.service.CategoriaService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173"})
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> listarTodas() {
        return categoriaService.listarTodas();
    }

    @PostMapping
    public Categoria crear(@RequestBody Categoria categoria) {
        return categoriaService.crear(categoria);
    }
}