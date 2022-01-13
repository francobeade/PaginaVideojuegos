package com.francoBeade.PaginaVideojuegos.repository;

import com.francoBeade.PaginaVideojuegos.model.Distribuidor;
import com.francoBeade.PaginaVideojuegos.model.VideoJuego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistribuidorRepository extends JpaRepository<Distribuidor, Integer> {

    @Query("from Distribuidor d order by d.nombre")
    List<Distribuidor> buscarOrdenado();
    List<Distribuidor> findById(int id);
}
