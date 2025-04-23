package com.example.Parcial.Repository;

import com.example.Parcial.Model.Jugadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JugadoresRepository extends JpaRepository<Jugadores, Integer> {

    @Query(value = "SELECT * FROM jugador WHERE id_equipo = :idEquipo", nativeQuery = true)
    List<Jugadores> findJugadoresByEquipo(@Param("idEquipo") Integer idEquipo);

    @Query(value = "SELECT j.* FROM jugador j " +
            "JOIN estadisticas e ON j.id_jugador = e.id_jugador " +
            "GROUP BY j.id_jugador " +
            "HAVING SUM(e.goles) > :minGoles", nativeQuery = true)
    List<Jugadores> findJugadoresConMasDeXGoles(@Param("minGoles") Integer minGoles);

    @Query(value = "SELECT DISTINCT j.* FROM jugador j " +
            "JOIN estadisticas e ON j.id_jugador = e.id_jugador " +
            "GROUP BY j.id_jugador, j.nombre, j.posicion, j.dorsal, j.fecha_nac, j.nacionalidad, j.id_equipo " +
            "HAVING SUM(e.goles) > :goles", nativeQuery = true)
    List<Jugadores> findJugadoresConMasDeXGoles(@Param("goles") int goles);

    @Query(value = "SELECT SUM(e.goles) FROM estadisticas e " +
            "JOIN jugador j ON e.id_jugador = j.id_jugador " +
            "WHERE j.id_equipo = :idEquipo", nativeQuery = true)
    Integer obtenerTotalGolesPorEquipo(@Param("idEquipo") int idEquipo);
}

