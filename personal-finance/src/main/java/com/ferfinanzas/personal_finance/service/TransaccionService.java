package com.ferfinanzas.personal_finance.service;


import com.ferfinanzas.personal_finance.entity.Categoria;
import com.ferfinanzas.personal_finance.entity.Transaccion;
import com.ferfinanzas.personal_finance.repository.TransaccionRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public Transaccion guardar(Transaccion transaccion) {
        // Aquí podrías meter reglas, por ahora es directo
        if (transaccion.getFechaHora() == null) {
            transaccion.setFechaHora(LocalDateTime.now());
        }
        return transaccionRepository.save(transaccion);
    }

    public List<Transaccion> listarTodas() {
        return transaccionRepository.findAll();
    }

    public List<Transaccion> listarPorCategoria(Categoria categoria) {
        return transaccionRepository.findByCategoria(categoria);
    }

    public List<Transaccion> listarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return transaccionRepository.findByFechaHoraBetween(inicio, fin);
    }

    public List<Transaccion> listarPorTipo(String tipo) {
        return transaccionRepository.findByTipo(tipo);
    }
}