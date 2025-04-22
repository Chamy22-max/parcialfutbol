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



}

