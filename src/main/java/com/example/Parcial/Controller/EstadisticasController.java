package com.example.Parcial.Controller;

import com.example.Parcial.Model.Estadisticas;
import com.example.Parcial.Repository.EstadisticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estadisticas")
public class EstadisticasController {

    @Autowired
    private EstadisticasRepository repository;

    @GetMapping
    public List<Estadisticas> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Estadisticas getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Estadisticas create(@RequestBody Estadisticas estadistica) {
        return repository.save(estadistica);
    }

    @PutMapping("/{id}")
    public Estadisticas update(@PathVariable Integer id, @RequestBody Estadisticas estadistica) {
        estadistica.setIdEstadistica(id);
        return repository.save(estadistica);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
