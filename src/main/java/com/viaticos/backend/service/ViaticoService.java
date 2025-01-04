package com.viaticos.backend.service;

import com.viaticos.backend.model.Viatico;
import com.viaticos.backend.repository.ViaticoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ViaticoService {

    private final ViaticoRepository viaticoRepository;

    public ViaticoService(ViaticoRepository viaticoRepository) {
        this.viaticoRepository = viaticoRepository;
    }

    public Map<String, String> registrarViatico(Viatico viatico) {
        validarDatosViatico(viatico);
        if (viaticoRepository.existsByIdentificacion(viatico.getIdentificacion())) {
            throw new IllegalArgumentException("Ya existe un viático con esta identificación.");
        }
        Viatico savedViatico = viaticoRepository.save(viatico);
        return Map.of("message", "Viático registrado exitosamente", "id", savedViatico.getId().toString());
    }

    public Optional<Viatico> obtenerViaticoPorId(Long id) {
        return viaticoRepository.findById(id);
    }

    public Viatico aprobarViatico(Long id) {
        Viatico viatico = viaticoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Viático no encontrado"));
        if (viatico.isAprobado()) {
            throw new IllegalArgumentException("El viático ya está aprobado.");
        }
        viatico.setAprobado(true);
        return viaticoRepository.save(viatico);
    }

    public List<Viatico> obtenerTodosLosViaticos() {
        return viaticoRepository.findAll();
    }

    public Optional<Viatico> buscarViaticoPorIdentificacion(String identificacion) {
        return viaticoRepository.findByIdentificacion(identificacion);
    }

    public boolean existeViaticoPorIdentificacion(String identificacion) {
        return viaticoRepository.existsByIdentificacion(identificacion);
    }

    // Método para guardar un nuevo viático
    public Viatico save(Viatico viatico) {
        return viaticoRepository.save(viatico);
    }

    private void validarDatosViatico(Viatico viatico) {
        if (viatico.getFechaRegistro() == null) {
            throw new IllegalArgumentException("La fecha de registro es obligatoria.");
        }
        if (viatico.getNombrePersona() == null || viatico.getNombrePersona().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la persona no puede estar vacío.");
        }
        if (viatico.getIdentificacion() == null || !viatico.getIdentificacion().matches("\\d{10}")) {
            throw new IllegalArgumentException("La identificación debe tener 10 dígitos.");
        }
    }
}
