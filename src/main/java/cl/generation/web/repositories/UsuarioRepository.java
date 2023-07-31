package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Usuario;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
// Aqui realizamos la lógica de manipulación de datos (Crud y más cosas)
	// los FindBy funcionan con todos los datos que ingresamos en el models
	
	Usuario findByCorreo(String correo);
	Usuario findByNick(String nick);
}
