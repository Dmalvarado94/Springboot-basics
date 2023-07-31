package cl.generation.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Rol;
import cl.generation.web.repositories.RolRepository;


@Service
public class RolServicesImpl {

	@Autowired
	private RolRepository rolRepository;
		public Rol obtenerRol(Long id) {
		Boolean existe = rolRepository.existsById(id);
		
		if(existe) {
		Rol user= rolRepository.findById(id).get();
			return user;
		}
		return null;
	}
}
