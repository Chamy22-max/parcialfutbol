package com.example.Parcial.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "partidos")
public class Partidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Integer idPartido;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "estadio", length = 100, nullable = false)
    private String estadio;

    @Column(name = "goles_local")
    private Integer goles_local;

    @Column(name = "goles_visita")
    private Integer goles_visita;

    @ManyToOne
    @JoinColumn(name = "equipo_local")
    private Equipo equipoLocal;

    @ManyToOne
    @JoinColumn(name = "equipo_visita")
    @JsonIgnoreProperties("equipo_visita")
    private Equipo equipoVisita;

    @OneToMany(mappedBy = "partido", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("partido")
    private List<Estadisticas> estadisticas;


}
