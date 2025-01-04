package com.viaticos.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viaticos.backend.model.Viatico;

@Repository
public interface ViaticoRepository extends JpaRepository<Viatico, Long> {
    // Método para encontrar un Viático por identificacion
    Optional<Viatico> findByIdentificacion(String identificacion);

    boolean existsByIdentificacion(String identificacion);
}
