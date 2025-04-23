package com.example.Parcial.Service;

import com.example.Parcial.Model.Entrenadores;
import com.example.Parcial.Repository.EntrenadoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrenadoresService {

    private final EntrenadoresRepository entrenadoresRepository;

    public EntrenadoresService(EntrenadoresRepository entrenadoresRepository) {
        this.entrenadoresRepository = entrenadoresRepository;
    }

    public List<Entrenadores> findAll() {
        return entrenadoresRepository.findAll();
    }

    public Optional<Entrenadores> findById(Integer id) {
        return entrenadoresRepository.findById(id);
    }

    public Entrenadores save(Entrenadores entrenador) {
        return entrenadoresRepository.save(entrenador);
    }

    public void deleteById(Integer id) {
        entrenadoresRepository.deleteById(id);
    }

    public Entrenadores update(Integer id, Entrenadores updated) {
        return entrenadoresRepository.findById(id)
                .map(ent -> {
                    ent.setNombre(updated.getNombre());
                    ent.setEspecialidad(updated.getEspecialidad());
                    ent.setEquipo(updated.getEquipo());
                    return entrenadoresRepository.save(ent);
                }).orElse(null);
    }
}
