package cl.generation.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Auto;
import cl.generation.web.services.AutoServicesImpl;

@Controller
@RequestMapping ("/home")
public class HomeController {
	@Autowired
	AutoServicesImpl autoServicesImpl;
	
	
	//localhost:9080/home
		@GetMapping("")
		public String home(Model model, HttpSession session) {
			
			if(session.getAttribute("usuarioId")!=null) {
				
				//capturando variables de session
				String email = (String) session.getAttribute("usuarioEmail");
				Long usuarioId = (Long) session.getAttribute("usuarioId");
				String nombre = (String) session.getAttribute("usuarioNombre");
				
				//obtener y almacenar en variable
				List<Auto> listaAutos= autoServicesImpl.listarAutos();
				//pasar lista de autos al jsp
				model.addAttribute("autos", listaAutos);
				//lista para el selector
				List<Auto> listaSelectAutos= autoServicesImpl.listarAutos();
				model.addAttribute("listaSelectAutos", listaSelectAutos);
				
				model.addAttribute("usuarioNombre", nombre);
				return "home.jsp";
				
			}else {
				return "redirect:/registro/login";
			}
			
			
		}
		
		//localhost:9080/home -> post, solo respondera a formularios
		@PostMapping("")
		public String filtrar(@RequestParam("autoSeleccionado") Long id, Model model) {
			List<Auto> listaAutos= new ArrayList<Auto>();//lista vacia
			Auto auto = autoServicesImpl.obtenerAuto(id);
			listaAutos.add(auto);//agrego el auto a la lista
			model.addAttribute("autos", listaAutos);//pasar lista de autos al jsp
			//lista para el selector
			List<Auto> listaSelectAutos= autoServicesImpl.listarAutos();
			model.addAttribute("listaSelectAutos", listaSelectAutos);
			return "home.jsp";
		}
		
		@PostMapping("/nav")
		public String filtrarNav(@RequestParam("marca") String marca, Model model) {
			List<Auto> listaAutos= new ArrayList<Auto>();//lista vacia
			Auto auto = autoServicesImpl.obtenerAutoNombre(marca);
			listaAutos.add(auto);//agrego el auto a la lista
			model.addAttribute("autos", listaAutos);//pasar lista de autos al jsp
			//lista para el selector
			List<Auto> listaSelectAutos= autoServicesImpl.listarAutos();
			model.addAttribute("listaSelectAutos", listaSelectAutos);
			return "home.jsp";
		}
	
	
}
