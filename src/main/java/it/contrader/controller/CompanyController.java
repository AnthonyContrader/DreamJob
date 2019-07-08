package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CandidatoDTO;
import it.contrader.dto.CompanyDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.service.CompanyService;



/**
 * 
 * Questa classe estende AbstractController con tipo UserDTO.
 * In aggiunta ai metodi di CRUD si implementa il metodo di login.
 * 
 * @author Vittorio Valent & Girolamo Murdaca
 * 
 * @param<UserDTO>
 * 
 * @see AbstractController
 *
 */
@RestController
@RequestMapping("/company")
@CrossOrigin(origins = "http://localhost:4200")
public class CompanyController extends AbstractController<CompanyDTO>{
	
	@Autowired
	private CompanyService companyService;


	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public CompanyDTO login( @RequestBody LoginDTO loginDTO ) {
		return companyService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
	}
	
	@GetMapping(value = "/readCompany")
	public CompanyDTO readCompany(@RequestParam String username ) {
		//System.out.println("Sono nel controller e ho prelevat l'oggeto con username: " + candidatoService.findByUsername(username).getUsername());
		return companyService.findByUsername(username);
		
	}
}