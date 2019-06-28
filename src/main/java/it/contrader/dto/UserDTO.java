package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	public UserDTO(String username2, String password2, String usertype2) {
		// TODO Auto-generated constructor stub
		this.username=username2;
		this.password=password2;
		this.usertype=usertype2;
	}

	private Integer id;

	private String username;
	
	private String password;

	private String usertype;
	
}
