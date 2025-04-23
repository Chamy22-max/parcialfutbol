package com.example.Parcial.Service;

import com.example.Parcial.Model.Partidos;
import com.example.Parcial.Repository.PartidosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PartidosService {

    private final PartidosRepository partidosRepository;

    public PartidosService(PartidosRepository partidosRepository) {
        this.partidosRepository = partidosRepository;
    }

    public List<Partidos> findAll() {
        return partidosRepository.findAll();
    }

    public Optional<Partidos> findById(Integer id) {
        return partidosRepository.findById(id);
    }

    public Partidos save(Partidos partido) {
        return partidosRepository.save(partido);
    }

    public void deleteById(Integer id) {
        partidosRepository.deleteById(id);
    }

    public Partidos update(Integer id, Partidos updated) {
        return partidosRepository.findById(id)
                .map(partido -> {
                    partido.setNombre(updated.getNombre());
                    partido.setFecha(updated.getFecha());
                    partido.setEstadio(updated.getEstadio());
                    partido.setEquipoLocal(updated.getEquipoLocal());
                    partido.setEquipoVisita(updated.getEquipoLocal());
                    partido.setGoles_local(updated.getGoles_local());
                    partido.setGoles_visita(updated.getGoles_visita());
                    partido.setEquipoLocal(updated.getEquipoLocal());
                    partido.setEquipoVisita(updated.getEquipoVisita());
                    return partidosRepository.save(partido);
                }).orElse(null);
    }
    public List<Object[]> obtenerResultadosPartidos() {
        return partidosRepository.obtenerResultadosDePartidos();
    }
}
