package com.viaticos.backend.controller;

import com.viaticos.backend.model.Viatico;
import com.viaticos.backend.service.ViaticoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/viaticos")
@CrossOrigin(origins = "*")
public class ViaticoController {

    private final ViaticoService viaticoService;

    public ViaticoController(ViaticoService viaticoService) {
        this.viaticoService = viaticoService;
    }

    @PostMapping("/registro")
    public ResponseEntity<Map<String, String>> registrarViatico(@RequestBody Viatico viatico) {
        // Verifica si el viático ya existe por identificación
        if (viaticoService.existeViaticoPorIdentificacion(viatico.getIdentificacion())) {
            return ResponseEntity.status(400).body(Map.of("message", "El viático ya existe"));
        }

        try {
            Viatico savedViatico = viaticoService.save(viatico);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Viático registrado exitosamente");
            response.put("id", savedViatico.getId().toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", "Error al registrar el viático"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viatico> obtenerViatico(@PathVariable Long id) {
        return viaticoService.obtenerViaticoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/aprobar")
    public ResponseEntity<Viatico> aprobarViatico(@PathVariable Long id) {
        try {
            Viatico aprobado = viaticoService.aprobarViatico(id);
            return ResponseEntity.ok(aprobado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Viatico>> obtenerTodosLosViaticos() {
        List<Viatico> viaticos = viaticoService.obtenerTodosLosViaticos();
        if (viaticos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(viaticos);
    }

    @GetMapping("/buscar/{identificacion}")
    public ResponseEntity<Viatico> buscarViaticoPorIdentificacion(@PathVariable String identificacion) {
        return viaticoService.buscarViaticoPorIdentificacion(identificacion)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
