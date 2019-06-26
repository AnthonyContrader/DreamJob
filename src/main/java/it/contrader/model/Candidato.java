package it.contrader.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Candidato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	@NotNull
	private String name;
	
	@NotNull
	private String surname;
	
	@NotNull
	private Integer age;
	
	@NotNull
	private String tipolaurea;
	
	@NotNull
	private String experience;
	
	@OneToMany(mappedBy="candidato")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Risultato> risultato;
	
}
