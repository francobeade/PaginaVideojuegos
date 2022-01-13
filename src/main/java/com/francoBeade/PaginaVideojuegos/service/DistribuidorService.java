package com.francoBeade.PaginaVideojuegos.service;

import com.francoBeade.PaginaVideojuegos.model.Distribuidor;
import com.francoBeade.PaginaVideojuegos.repository.DistribuidorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistribuidorService {

    private final DistribuidorRepository distribuidorRepository;

    public DistribuidorService(DistribuidorRepository distribuidorRepository) {
        this.distribuidorRepository = distribuidorRepository;
    }

    public List<Distribuidor> buscarTodos() {
        return distribuidorRepository.buscarOrdenado();
    }

    public Distribuidor guardarDist(Distribuidor distribuidor) {
        return distribuidorRepository.save(distribuidor);
    }

    public List<Distribuidor> buscarDistId(int id) {
        return distribuidorRepository.findById(id);
    }
}
