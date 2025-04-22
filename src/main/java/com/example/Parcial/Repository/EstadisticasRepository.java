package com.example.Parcial.Repository;

import com.example.Parcial.Model.Estadisticas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasRepository extends JpaRepository<Estadisticas, Integer> {
}

