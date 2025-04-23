package com.example.Parcial.Service;

import com.example.Parcial.Model.Equipo;
import com.example.Parcial.Repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    private final EquipoRepository equipoRepository;

    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    public Optional<Equipo> findById(Integer id) {
        return equipoRepository.findById(id);
    }

    public Equipo save(Equipo equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteById(Integer id) {
        equipoRepository.deleteById(id);
    }

    public Equipo update(Integer id, Equipo updated) {
        return equipoRepository.findById(id)
                .map(equipo -> {
                    equipo.setNombre(updated.getNombre());
                    equipo.setCiudad(updated.getCiudad());
                    equipo.setFundacion(updated.getFundacion());
                    return equipoRepository.save(equipo);
                }).orElse(null);
    }
}
