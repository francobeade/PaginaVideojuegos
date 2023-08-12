package com.francoBeade.PaginaVideojuegos.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LogingController {
                    
	@GetMapping("/login")
	public String login(@RequestParam(value="error", required = false) String error, Model model, Principal principal, RedirectAttributes attribute) {
		
		if(error!=null) {
			model.addAttribute("error", "ERROR DE ACCESO: Usuario y/o Contraseña son incorrectos");
		}
		
		if(principal!=null) {
			attribute.addFlashAttribute("warning", "ATENCION: Ud. ya ha iniciado sesion previamente");
			return "redirect:/";
		}
		return "login";
	}
	
}
