package cl.generation.web.services;
import java.util.List;

import cl.generation.web.models.Usuario;

public interface UsuarioService {
	// Definir metodos para crud Usuario
	public Boolean guardarUsuario(Usuario usuario);
	
	public String eliminarUsuario(Long id);
	
	public String actualizarUsuario(Usuario usuario);
	
	public Usuario obtenerUsuario(Long id);
	
	public List<Usuario> obtenerListaUsuarios();
	
	// Login
	
	public Boolean ingresoUsuario(String email, String password);
	
	
	public Usuario obtenerUsuarioEmail(String email);

}
