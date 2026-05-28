package com.ferfinanzas.personal_finance.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Monto de la transacción (positivo siempre, ya veremos si es ingreso/gasto)
    private BigDecimal monto;

    // Fecha y hora de la transacción
    private LocalDateTime fechaHora;

    // "GASTO" o "INGRESO"
    private String tipo;

    // Descripción libre: "Compra en supermercado", "Suscripción Netflix", etc.
    private String descripcion;

    // Relación N:1 -> muchas transacciones pueden pertenecer a una sola categoría
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}