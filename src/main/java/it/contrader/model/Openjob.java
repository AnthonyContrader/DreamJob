package it.contrader.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Openjob {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	
	private String titolo;
	
	
	private String descrizione;

	
	private String requisiti;
	
	@ManyToOne
	@JoinColumn(name="idCompany")
	private Company company;
	
	@OneToMany(mappedBy="openjob")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private List<Risultato> risultato;
	
}
