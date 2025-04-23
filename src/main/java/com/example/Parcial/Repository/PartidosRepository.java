package com.example.Parcial.Repository;

import com.example.Parcial.Model.Partidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidosRepository extends JpaRepository<Partidos, Integer> {

    @Query(value = "SELECT SUM(CASE WHEN p.equipo_local = :idEquipo THEN p.goles_local " +
            "WHEN p.equipo_visita = :idEquipo THEN p.goles_visita ELSE 0 END) " +
            "AS total_goles FROM partidos p", nativeQuery = true)
    Integer findTotalGolesPorEquipo(@Param("idEquipo") Integer idEquipo);


        @Query(value = "SELECT p.id_partido, el.nombre AS equipo_local, ev.nombre AS equipo_visita, " +
                "p.goles_local, p.goles_visita " +
                "FROM partidos p " +
                "JOIN equipo el ON p.equipo_local = el.id_equipo " +
                "JOIN equipo ev ON p.equipo_visita = ev.id_equipo", nativeQuery = true)
        List<Object[]> obtenerResultadosDePartidos();
    }

