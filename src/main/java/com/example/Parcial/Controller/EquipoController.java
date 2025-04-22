package com.example.Parcial.Controller;

import com.example.Parcial.Model.Equipo;
import com.example.Parcial.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoRepository repository;

    @GetMapping
    public List<Equipo> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Equipo getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Equipo create(@RequestBody Equipo equipo) {
        return repository.save(equipo);
    }

    @PutMapping("/{id}")
    public Equipo update(@PathVariable Integer id, @RequestBody Equipo equipo) {
        equipo.setIdEquipo(id);
        return repository.save(equipo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}

