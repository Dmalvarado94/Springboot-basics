package cl.generation.web.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter     
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "roles")
public class Rol { // Relacion ManytoMany Roles profe, super, temp
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String descripcion;

	// ManyToMany rol
	@JsonIgnore
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;



}
