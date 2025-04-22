package com.example.Parcial.Repository;

import com.example.Parcial.Model.Entrenadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrenadoresRepository extends JpaRepository<Entrenadores, Integer> {
}