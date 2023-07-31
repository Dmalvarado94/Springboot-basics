package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Esto se lo añadimos para que al ingresar al localhost8081 
// Se despliegue automaticamente el jsp si no hay nada ingresado.

@Controller
public class IndexController {
	@GetMapping("/")
	public String home() {
		return "index.jsp";
	}
}