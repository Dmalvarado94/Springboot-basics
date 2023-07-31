package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	//http://localhost:8081/
	@RequestMapping("/")
	public String getUsuario() {
		System.out.println("Metodo de obtener usuario");
		return "index.jsp";
	}
	
	//http://localhost:9080/home
	@RequestMapping("/home")
	public String home() {
		System.out.println("Estoy en el metodo home");
		return "TURIP";
	}
	//http://localhost:9080/luis
	@RequestMapping("/luis")
	public String luis() {
		System.out.println("Estoy en el metodo luis");
		return "";
	}
}


