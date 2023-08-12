package com.francoBeade.PaginaVideojuegos.controller;

import java.util.List;

import com.francoBeade.PaginaVideojuegos.model.VideoJuego;
import com.francoBeade.PaginaVideojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ListController {

    private final VideojuegoService videojuegoService;

    public ListController(VideojuegoService videojuegoService) {
        this.videojuegoService = videojuegoService;
    }

    @RequestMapping("/")
    public String listarVideojuegos(Model model) {
        List<VideoJuego> destacados = videojuegoService.buscarDestacados();
        model.addAttribute("videojuegos", destacados);
        return "listado";
    }
    @RequestMapping("/videoJuegosPorDistribuidor")
   public String listarVideojuegosPorDistribuidor(int distribuidorId, Model model) {
        List<VideoJuego> juegos = videojuegoService.buscarPorDistribuidor(distribuidorId);
        model.addAttribute("videojuegos", juegos);
        return "listado";
    }

    @RequestMapping("/buscar")
    public String buscar(@RequestParam("q") String consulta, Model model) {
        List<VideoJuego> juegos = videojuegoService.buscar(consulta);
        model.addAttribute("videojuegos", juegos);
        return "listado";
    }

}
