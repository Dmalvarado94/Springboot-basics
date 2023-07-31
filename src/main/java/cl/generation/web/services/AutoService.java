package cl.generation.web.services;

import java.util.List;

import cl.generation.web.models.Auto;


public interface AutoService {

	public Auto guardarAuto(Auto auto);
	public List<Auto> listarAutos();
	public Auto obtenerAuto(Long id);
	public Auto obtenerAutoNombre(String marca);
	
	public List<Auto> findAllByMarca(String marca);
	
	public String eliminarAuto(Long id);
	
	public Auto editarAuto(Long id,Auto auto);

}