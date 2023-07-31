package cl.generation.web.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.generation.web.models.Auto;
@Repository
public interface AutoRepository extends JpaRepository<Auto, Long>{
	Auto findByMarca(String marca);
	
	//lógica de manipulación de datos (CRUD+)
	// JPQL 
	
	// a = *, dentro de la query, el segundo a es el Alias
	
	// obtener lista de autos por marca
	@Query("SELECT a FROM Auto a WHERE a.marca =?1 ")
	List<Auto> findAllByMarca(String marca);
	
	// obtener lista de autos por marca y color
	@Query("SELECT a FROM Auto a WHERE a.marca =?1 and a.color = ?2")
	List<Auto> findAllByMarcaColor(String marca, String color);
	
	//query Comun
	@Query(value="select * from autos a where a.marca = ?1", nativeQuery = true)
	List<Auto> findAllByMarcaComun(String marca);
	
	
	// obtener lista de autos por ID de un usuario
	@Query("SELECT a FROM Auto a WHERE a.usuario.id = ?1")
	List<Auto> findAllByUsuario(Long id);
	

}
