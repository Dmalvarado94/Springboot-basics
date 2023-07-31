package cl.generation.web.services;


import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Usuario;
import cl.generation.web.repositories.UsuarioRepository;

@Service
public class UsuarioServicesImpl implements UsuarioService{
	@Autowired
	private UsuarioRepository usuarioRepository;
// Aquí realizamos toda la lógica de negocio del sistema Web, (Existe correo?, existe web?)
	@Override
	public Boolean guardarUsuario(Usuario usuario) {	
		//validar el usuario (email)
				Usuario retornoUsuario = usuarioRepository.findByCorreo(usuario.getCorreo());
				if(retornoUsuario == null) {
					//1234 -> 1231245321425fas4352
					String passHashed = BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
					//reemplazando el valor por el hash
					usuario.setPassword(passHashed);		
					
					usuarioRepository.save(usuario);
					return true;
				}else {
					return false;
				}
			}
	
	@Override
	public String eliminarUsuario(Long id) {
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {
			//elimino el usuario pasando el id (pk)
			usuarioRepository.deleteById(id);
		}else {
			return "Usuario no existe en la tabla";
		}
		
		existe = usuarioRepository.existsById(id);
		
		//si es distinto de nulo, no fue eliminado
		if(existe) {
			return "Usuario no eliminado";
		}
		
		return "El usuario fue eliminado";
	}
	
	@Override
	public String actualizarUsuario(Usuario usuario) {
		
		Boolean existe = usuarioRepository.existsById(usuario.getId());
		if (existe) {
			usuarioRepository.save(usuario);
			return "Usuario actualizado";
		}
		return "Usuario Creado";
	}
	
	
	@Override
	public Usuario obtenerUsuario(Long id) {
		//Optional<Usuario> user = usuarioRepository.findById(id);  este era el método de brisa
		Boolean existe = usuarioRepository.existsById(id);
		
		if(existe) {
		Usuario user= usuarioRepository.findById(id).get();
			return user;
		}
		return null;
	}
	
	@Override
	public List<Usuario> obtenerListaUsuarios() {

		//obtener todos los usuarios
		return usuarioRepository.findAll();
	}

	
	@Override
	public Boolean ingresoUsuario(String email, String password) {
		System.out.println(email +" "+password);
		Usuario usuario = usuarioRepository.findByCorreo(email);
		if(usuario!= null) {//existe el usuario
			// opcion resumen
			//return BCrypt.checkpw(password,usuario.getPassword());  Esto reemplazaría el if else.
			//comparar contraseñas
			boolean resultadoPwd = BCrypt.checkpw(password,usuario.getPassword());
			
			if(resultadoPwd) {//resultadoPwd == true; son iguales-> 
				return true;
			}else {//resultadoPwd == false; password distintas
				return false;
			}
			
		}else {//no existe el email en bd
			return false;
		}
	}

	public Usuario obtenerUsuarioEmail(String email) {
		
		
		return usuarioRepository.findByCorreo(email);
	}



}
