package cl.generation.web.api;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Rol;


@RestController
@RequestMapping("/api")
public class ApiRestController {

	// Aqui creamos una API estatica
	@RequestMapping("/hola")
	// http://localhost:8081/api/hola
	public String hola() {
		System.out.println("Estoy en la api");
		return "hola api";
	}

	// Para una API dinámica se realizaría así:
	@RequestMapping("/edad/{edad}")
	// http://localhost:8081/api/edad/28
	public String rutaDinamica(@PathVariable("edad") int edad) {
		return "capturando edad " + edad;
	}

	// http://localhost:8081/api/nombre/luisa
	@RequestMapping("/nombre/{nombre}")
	public String capturarNombre(@PathVariable("nombre") String nombre) {
		return "El nombre capturado es: " + nombre;
		
	}

// Tarea:

	// Tenemos que obtener http://localhost:8081/api/14/noviembre/2022 Tuvimos que
	// ponerle un PathVariable a cada valor.
	// http://localhost:8081/api/14/noviembre/2022
	@RequestMapping("/{dia}/{mes}/{año}")
	public String rutaDinamica(@PathVariable("dia") int dia, @PathVariable("mes") String mes,
			@PathVariable("año") int año) {
		return "La fecha es: " + dia + " " + mes + " " + año;
	}

	// http://localhost:8081/api/usuario?usuarioId=1
	// Required = false significa que no es requerido u obligatorio
	@RequestMapping("/usuario")
	public String parametro(@RequestParam(value = "usuarioId", required = false) Integer id) {
		if(id == null) {
			return "parametro no existe";
		}else {
			return "parametro por get "+id;
		}
		}
	
	
	// http://localhost:8081/api/usuario2?usuarioId=2323&nombre=daniel
		@RequestMapping("/usuario2")
		public String parametro2(@RequestParam(value="usuarioId",required = false) Integer id,
				@RequestParam(value="nombre",required = false) String nombre) {

			if(id == null) {
				return "parametro no existe";
			}else {
				return "parametro por get "+id + " nombre: "+nombre;
			}
			
		}
		
		@RequestMapping("/rol")
		public Rol obtenerRol() {
			Rol rol = new Rol();
			rol.setNombre("hola");
			return rol;
			
		}


}

