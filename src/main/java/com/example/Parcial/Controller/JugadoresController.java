package com.example.Parcial.Controller;

import com.example.Parcial.Model.Jugadores;
import com.example.Parcial.Repository.JugadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadoresController {

    @Autowired
    private JugadoresRepository repository;

    @GetMapping
    public List<Jugadores> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Jugadores getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Jugadores create(@RequestBody Jugadores jugador) {
        return repository.save(jugador);
    }

    @PutMapping("/{id}")
    public Jugadores update(@PathVariable Integer id, @RequestBody Jugadores jugador) {
        jugador.setIdJugador(id);
        return repository.save(jugador);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}

