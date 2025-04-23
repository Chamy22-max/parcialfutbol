package com.example.Parcial.Repository;

import com.example.Parcial.Model.Estadisticas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadisticasRepository extends JpaRepository<Estadisticas, Integer> {

    @Query(value = "SELECT SUM(e.goles) FROM estadisticas e " +
            "JOIN jugador j ON e.id_jugador = j.id_jugador " +
            "WHERE j.id_equipo = :idEquipo", nativeQuery = true)
    Integer obtenerTotalGolesPorEquipo(@Param("idEquipo") int idEquipo);
}
