package com.example.Parcial.Repository;

import com.example.Parcial.Model.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
    @Query("SELECT e FROM Equipo e WHERE e.nombre = :nombre")
    List<Equipo> findByNombre(@Param("nombre") String nombre);
}
