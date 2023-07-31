package cl.generation.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.generation.web.models.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

}
