package cl.generation.web.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.generation.web.models.Auto;

import cl.generation.web.repositories.AutoRepository;



@Service
	public class AutoServicesImpl implements AutoService{
		@Autowired
		AutoRepository autoRepository;
		@Override
		public Auto guardarAuto(Auto auto) {
			return autoRepository.save(auto);
		}
		@Override
		public Auto obtenerAuto(Long id) {
			return autoRepository.findById(id).get();
		}
		
		@Override
		public List<Auto> listarAutos() {
			return autoRepository.findAll();
		}
		
		@Override
		public Auto obtenerAutoNombre(String marca) {
			
			return autoRepository.findByMarca(marca);
		}
		@Override
		public List<Auto> findAllByMarca(String marca) {
			return autoRepository.findAllByMarca(marca);
		}
		
		@Override
		public String eliminarAuto(Long id) {
			Boolean existe = autoRepository.existsById(id);
			
			if(existe) {
				//elimino el usuario pasando el id (pk)
				autoRepository.deleteById(id);
			}else {
				return "Auto no existe en la tabla";
			}
			
			existe = autoRepository.existsById(id);
			
			//si es distinto de nulo, no fue eliminado
			if(existe) {
				return "Auto no eliminado";
			}
			
			return "El Auto fue eliminado";
		}
		
		@Override
		public Auto editarAuto(Long id, Auto auto) {
			Optional<Auto> autoParaEditar = autoRepository.findById(id);
			Auto autoEditado = autoParaEditar.get();
			autoEditado.setMarca(auto.getMarca());
			autoEditado.setColor(auto.getColor());
			autoRepository.save(autoEditado);
			return autoEditado;
		}




}
