package com.example.Parcial.Service;

import com.example.Parcial.Model.Estadisticas;
import com.example.Parcial.Repository.EstadisticasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadisticasService {

    private final EstadisticasRepository estadisticasRepository;

    public EstadisticasService(EstadisticasRepository estadisticasRepository) {
        this.estadisticasRepository = estadisticasRepository;
    }

    public List<Estadisticas> findAll() {
        return estadisticasRepository.findAll();
    }

    public Optional<Estadisticas> findById(Integer id) {
        return estadisticasRepository.findById(id);
    }

    public Estadisticas save(Estadisticas estadistica) {
        return estadisticasRepository.save(estadistica);
    }

    public void deleteById(Integer id) {
        estadisticasRepository.deleteById(id);
    }

    public Estadisticas update(Integer id, Estadisticas updated) {
        return estadisticasRepository.findById(id)
                .map(est -> {
                    est.setMinutos_jugados(updated.getMinutos_jugados());
                    est.setGoles(updated.getGoles());
                    est.setAsistencias(updated.getAsistencias());
                    est.setTarjetas_amarillas(updated.getTarjetas_amarillas());
                    est.setTarjetas_rojas(updated.getTarjetas_rojas());
                    est.setJugador(updated.getJugador());
                    est.setPartido(updated.getPartido());
                    return estadisticasRepository.save(est);
                }).orElse(null);
    }
}
