package cl.generation.web.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cl.generation.web.models.Usuario;
import cl.generation.web.services.UsuarioServicesImpl;

@Controller
@RequestMapping("/registro")
//http://localhost:8081/registro/usuario
public class RegistroController {
	@Autowired
	UsuarioServicesImpl usuarioServicesImpl;

	// capturar la url y desplegar jsp (controlador)
	@GetMapping("/usuario")
	public String mostrarFormulario() {
		return "registro.jsp";
	}
	// llenamos el formulario (vista) // llenamos el formulario (vista)
	// enviamos el formulario (vista) al controlador
	// capturar la url,
	// capturar los parametros
	// enviar a base datos

	// Aqui capturamos parametros del formulario Nombre
	@PostMapping("/usuario")
	public String guardarFormulario(@RequestParam("nombre") String nombre, @RequestParam("nick") String nick,
			@RequestParam("email") String correo, @RequestParam("password") String pass,
			@RequestParam("password2") String pass2, Model model) {

		if (pass.equals(pass2)) {

			// Instanciamos un objeto Usuario para poder ingresar a la DB
			Usuario usuario = new Usuario();
			usuario.setNombre(nombre);
			usuario.setCorreo(correo);
			usuario.setNick(nick);
			usuario.setPassword(pass);
			usuario.setPassword2(pass2);

			// Enviamos a la base de datos, no olvides el UsuarioServicesImplem arriba
			
			Boolean resultado = usuarioServicesImpl.guardarUsuario(usuario);
			if(resultado) {//si es verdadero
				model.addAttribute("msgOk", "Registro exitoso");
				return "login.jsp"; //enviar a una vista
			}else {
				model.addAttribute("msgError" ,"Email ya registrado" );
				return "registro.jsp";
			}	
		}else {
			model.addAttribute("msgError" ,"Password distintos" );
			return "registro.jsp";
		}
	}
	
	//desplegar el jsp http://localhost:8080/registro/login
	@GetMapping("/login")
	public String login() {
		return "login.jsp";
	}
	
	//capturar el email y password
	@PostMapping("/login")
	public String ingresoUsuario(@RequestParam("email") String email,
			@RequestParam("pass") String pass,
			Model model,
			HttpSession session) {
		//System.out.println(email +" "+pass);
		//llamando al metodo
		Boolean resultadoLogin = usuarioServicesImpl.ingresoUsuario(email, pass);
		
		if(resultadoLogin) {//resultadoLogin == true, login correcto
			
			Usuario usuario = usuarioServicesImpl.obtenerUsuarioEmail(email);
			
			//guardar informacion en session
			session.setAttribute("usuarioId", usuario.getId());
			session.setAttribute("usuarioEmail", email);
			session.setAttribute("usuarioRol", usuario.getRoles());
			session.setAttribute("usuarioNombre", usuario.getNombre()+" " + usuario.getNick());
			
			//ir a una ruta interna http://localhost:8080/home
			return "redirect:/home";
		}else {
			model.addAttribute("msgError", "Por favor verifica tus datos ingresados");
			return "login.jsp";
		}

	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("usuarioId")!=null) {
			session.invalidate();
		}
		return "redirect:/registro/login";
	}


}
