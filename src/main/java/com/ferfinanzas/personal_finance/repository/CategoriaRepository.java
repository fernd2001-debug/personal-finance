package com.ferfinanzas.personal_finance.repository;

import com.ferfinanzas.personal_finance.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Ejemplo: buscar por nombre
    Categoria findByNombre(String nombre);
}