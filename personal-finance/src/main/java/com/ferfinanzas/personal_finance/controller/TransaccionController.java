package com.ferfinanzas.personal_finance.controller;


import com.ferfinanzas.personal_finance.entity.Categoria;
import com.ferfinanzas.personal_finance.entity.Transaccion;
import com.ferfinanzas.personal_finance.service.CategoriaService;
import com.ferfinanzas.personal_finance.service.TransaccionService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transacciones")
@CrossOrigin(origins = "*")
public class TransaccionController {

    private final TransaccionService transaccionService;
    private final CategoriaService categoriaService;

    public TransaccionController(TransaccionService transaccionService,
                                 CategoriaService categoriaService) {
        this.transaccionService = transaccionService;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Transaccion> listarTodas() {
        return transaccionService.listarTodas();
    }

    @PostMapping
    public Transaccion crear(@RequestParam Long categoriaId,
                             @RequestParam String tipo,
                             @RequestParam String descripcion,
                             @RequestParam Double monto) {

        Categoria categoria = categoriaService.listarTodas()
                .stream()
                .filter(c -> c.getId().equals(categoriaId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Transaccion t = new Transaccion();
        t.setCategoria(categoria);
        t.setTipo(tipo); // "GASTO" o "INGRESO"
        t.setDescripcion(descripcion);
        t.setMonto(java.math.BigDecimal.valueOf(monto));
        t.setFechaHora(LocalDateTime.now());

        return transaccionService.guardar(t);
    }
}