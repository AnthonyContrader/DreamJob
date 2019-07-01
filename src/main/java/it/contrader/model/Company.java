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

@Data //Crea i get e i set
@AllArgsConstructor //crea il costruttore con tutti gli argomenti
@NoArgsConstructor //crea il costruttore vuoto
@Entity //crea una tabella dove va il nome della classe, in questo caso Company
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotNull
	private String username;

	@NotNull
	private String password;

	
	private String name;
	
	
	private String info;
	
	@OneToMany(mappedBy="company") //indica la chiave esterna 1 a molti per più info consultare appunti
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Openjob> openjob;

}
