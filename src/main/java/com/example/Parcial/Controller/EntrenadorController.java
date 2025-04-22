package com.example.Parcial.Controller;

import com.example.Parcial.Model.Entrenadores;
import com.example.Parcial.Repository.EntrenadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entrenadores")
public class EntrenadorController {

    @Autowired
    private EntrenadoresRepository repository;

    @GetMapping
    public List<Entrenadores> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Entrenadores getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Entrenadores create(@RequestBody Entrenadores entrenador) {
        return repository.save(entrenador);
    }

    @PutMapping("/{id}")
    public Entrenadores update(@PathVariable Integer id, @RequestBody Entrenadores entrenador) {
        entrenador.setIdEntrenador(id);
        return repository.save(entrenador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
