package cl.generation.web.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "direcciones")
public class Direccion {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	private String numeracion;
	
	//relacion ManyToOne, esta entidad tendrá la columna FK
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="usuario_id")
		@JsonIgnore
		private Usuario usuario;


}
