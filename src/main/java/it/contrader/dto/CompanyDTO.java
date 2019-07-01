package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDTO {

	public CompanyDTO(String username2, String password2) {
		this.setUsername(username2);
		this.setPassword(password2);
		// TODO Auto-generated constructor stub
	}

	public CompanyDTO(String username2, String password2, String name2, String info2) {
		this.setUsername(username2);
		this.setPassword(password2);
		this.setName(name2);
		this.setInfo(info2);
		// TODO Auto-generated constructor stub
	}

	private Integer id;

	private String username;
	
	private String password;

	private String name;
	
	private String info;
	
	private Integer idOpenjob;
	
}
