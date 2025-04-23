package com.example.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "estadisticas")
public class Estadisticas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estadistica")
    private Integer idEstadistica;

    @Column(name = "minutos_jugados")
    private Integer minutos_jugados;

    @Column(name = "goles")
    private Integer goles;

    @Column(name = "asistencias")
    private Integer asistencias;

    @Column(name = "tarjetas_amarillas")
    private Integer tarjetas_amarillas;

    @Column(name = "tarjetas_rojas")
    private Integer tarjetas_rojas;

    @ManyToOne
    @JoinColumn(name = "id_jugador")
    @JsonIgnoreProperties("id_jugador")
    private Jugadores jugador;

    @ManyToOne
    @JoinColumn(name = "id_partido")
    @JsonIgnoreProperties("id_partido")
    private Partidos partido;


}
