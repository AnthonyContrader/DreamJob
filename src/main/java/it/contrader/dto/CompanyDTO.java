package it.contrader.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Openjob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO della classe User. Ha gli stessi attributi di User
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 *@see User
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class CompanyDTO {
	
	private long id;
	private String password;
	private String username;
	private String name;
	private String info;
	private OpenjobDTO openjob;
	
	

}
