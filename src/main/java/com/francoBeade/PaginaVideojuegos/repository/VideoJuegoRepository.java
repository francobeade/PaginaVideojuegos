package com.francoBeade.PaginaVideojuegos.repository;

import com.francoBeade.PaginaVideojuegos.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoJuegoRepository extends JpaRepository<VideoJuego, Integer> {

    @Query("from VideoJuego v order by v.nombre")
    List<VideoJuego> buscarTodos();

    @Query("from VideoJuego v where v.distribuidor.id = ?1 order by v.nombre")
    List<VideoJuego> buscarPorDistribuidor(int distribuidorId);

    List<VideoJuego> findByNombreContaining(String consulta);

}
