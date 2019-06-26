package it.contrader.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Risultato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String descrizione;

	@ManyToOne
	@JoinColumn(name="idCandidato")
	private Candidato candidato;
	
	@ManyToOne
	@JoinColumn(name="idOpenjob")
	private Openjob openjob;



}
