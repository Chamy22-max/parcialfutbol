package com.example.Parcial.Controller;

import com.example.Parcial.Model.Partidos;
import com.example.Parcial.Repository.PartidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/partidos")
public class PartidosController {

    @Autowired
    private PartidosRepository repository;

    @GetMapping
    public List<Partidos> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Partidos getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Partidos create(@RequestBody Partidos partido) {
        return repository.save(partido);
    }

    @PutMapping("/{id}")
    public Partidos update(@PathVariable Integer id, @RequestBody Partidos partido) {
        partido.setIdPartido(id);
        return repository.save(partido);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/resultados/{id}")
    public List<Map<String, Object>> getResultadosPartidos() {
        List<Object[]> resultados = repository.obtenerResultadosDePartidos();
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron partidos.");
        } else {
            System.out.println("Resultados obtenidos: " + resultados.size());
        }

        List<Map<String, Object>> respuesta = new ArrayList<>();
        for (Object[] fila : resultados) {
            Map<String, Object> map = new HashMap<>();
            map.put("id_partido", fila[0]);
            map.put("equipo_local", fila[1]);
            map.put("equipo_visita", fila[2]);
            map.put("goles_local", fila[3]);
            map.put("goles_visita", fila[4]);
            respuesta.add(map);
        }
        return respuesta;
    }

}
