package it.contrader.model;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * Model dell'entità User. Contiene l'enum che definisce gli usertype (salvati come interi
 * a partire da 0 sul db).
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @see UserDTO
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Company {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String username;
	private String password;
	private String name;
	private String info;
	
	@OneToMany(mappedBy = "company")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Openjob> openjob;

	
	 
}
