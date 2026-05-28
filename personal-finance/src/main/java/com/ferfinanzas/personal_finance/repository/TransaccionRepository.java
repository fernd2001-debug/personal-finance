package com.ferfinanzas.personal_finance.repository;


import com.ferfinanzas.personal_finance.entity.Transaccion;
import com.ferfinanzas.personal_finance.entity.Categoria;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {

    // Todas las transacciones de una categoría concreta
    List<Transaccion> findByCategoria(Categoria categoria);

    // Todas las transacciones entre dos fechas
    List<Transaccion> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);

    // Todas las transacciones por tipo ("GASTO" o "INGRESO")
    List<Transaccion> findByTipo(String tipo);
}