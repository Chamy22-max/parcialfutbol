package com.example.Parcial.Controller;

import com.example.Parcial.Model.Partidos;
import com.example.Parcial.Repository.PartidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}

