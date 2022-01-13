package com.francoBeade.PaginaVideojuegos.controller;

import com.francoBeade.PaginaVideojuegos.model.Distribuidor;
import com.francoBeade.PaginaVideojuegos.model.VideoJuego;
import com.francoBeade.PaginaVideojuegos.repository.VideoJuegoRepository;
import com.francoBeade.PaginaVideojuegos.service.DistribuidorService;
import com.francoBeade.PaginaVideojuegos.service.VideojuegoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VideojuegoAbmController {

    private final DistribuidorService distribuidorService;
    private final VideojuegoService videojuegoService;

    public VideojuegoAbmController(DistribuidorService distribuidorService, VideojuegoService videojuegoService) {
        this.distribuidorService = distribuidorService;
        this.videojuegoService = videojuegoService;
    }

    @RequestMapping("/videojuegos/crear")
    public String mostrarFormAlta(Model model) {
        model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        model.addAttribute("videojuego", new VideoJuego());
        return "formVideojuego";
    }

    @RequestMapping("/distribuidor/crearDist")
    public String mostrarFormAltaDist(Model model) {
        model.addAttribute("distribuidor", new Distribuidor());
        return "formDistribuidor";
    }

    @PostMapping("/videojuegos/guardar")
    public String guardar(VideoJuego videoJuego) {
        videojuegoService.guardar(videoJuego);
        return "redirect:/";
    }

    @PostMapping("/distribuidor/guardar")
    public String guardarDist(Distribuidor distribuidor) {
        distribuidorService.guardarDist(distribuidor);
        return "redirect:/";
    }

    @GetMapping("/videojuegos/editar/{id}")
    public String editar(@PathVariable("id") Integer id, Model model) {
    	
    	VideoJuego videojuego = videojuegoService.buscarPorId(id);
    	model.addAttribute("distribuidores", distribuidorService.buscarTodos());
        model.addAttribute("videojuego",  videojuego);
        return "formVideojuego";
    }

    @GetMapping("/videojuegos/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        videojuegoService.eliminar(id);
        return "redirect:/";
    }

}