package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AutoController {
	
	@RequestMapping("/inicio")
	public String getAuto() {
		System.out.println("Metodo de obtener auto");
		return "index.jsp";
	}

}
