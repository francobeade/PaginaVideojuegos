package com.francoBeade.PaginaVideojuegos.service;

import java.util.List;
import java.util.Optional;

import com.francoBeade.PaginaVideojuegos.model.VideoJuego;

import com.francoBeade.PaginaVideojuegos.repository.VideoJuegoRepository;
import org.springframework.stereotype.Service;

@Service
public class VideojuegoService {

    private final VideoJuegoRepository videoJuegoRepository;

    public VideojuegoService(VideoJuegoRepository videoJuegoRepository) {
        this.videoJuegoRepository = videoJuegoRepository;
    }

    public List<VideoJuego> buscarDestacados() {
        return videoJuegoRepository.buscarTodos();
    }

    public List<VideoJuego> buscarPorDistribuidor(int distribuidorId) {
        return videoJuegoRepository.buscarPorDistribuidor(distribuidorId);
    }

    public List<VideoJuego> buscar(String consulta) {
        return videoJuegoRepository.findByNombreContaining(consulta);
    }

    public VideoJuego guardar (VideoJuego videoJuego) {
        return videoJuegoRepository.save(videoJuego);
    }

    public void eliminar(int id) {
        videoJuegoRepository.deleteById(id);
    }

    public VideoJuego buscarPorId(Integer id) {
        return videoJuegoRepository.findById(id).orElse(null);
    }


}
