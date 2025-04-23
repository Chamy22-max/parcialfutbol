package com.example.Parcial.Service;

import com.example.Parcial.Model.Jugadores;
import com.example.Parcial.Repository.JugadoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadoresService {

    private final JugadoresRepository jugadoresRepository;

    public JugadoresService(JugadoresRepository jugadoresRepository) {
        this.jugadoresRepository = jugadoresRepository;
    }

    public List<Jugadores> findAll() {
        return jugadoresRepository.findAll();
    }

    public Optional<Jugadores> findById(Integer id) {
        return jugadoresRepository.findById(id);
    }

    public Jugadores save(Jugadores jugador) {
        return jugadoresRepository.save(jugador);
    }

    public void deleteById(Integer id) {
        jugadoresRepository.deleteById(id);
    }

    public Jugadores update(Integer id, Jugadores updated) {
        return jugadoresRepository.findById(id)
                .map(jugador -> {
                    jugador.setNombre(updated.getNombre());
                    jugador.setPosicion(updated.getPosicion());
                    jugador.setDorsal(updated.getDorsal());
                    jugador.setFecha_nac(updated.getFecha_nac());
                    jugador.setNacionalidad(updated.getNacionalidad());
                    jugador.setEquipo(updated.getEquipo());
                    return jugadoresRepository.save(jugador);
                }).orElse(null);
    }
}
