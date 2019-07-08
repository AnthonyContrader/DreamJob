package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.LoginDTO;
import it.contrader.dto.OpenjobDTO;
import it.contrader.service.OpenjobService;


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
@RequestMapping("/openjob")
@CrossOrigin(origins = "http://localhost:4200")
public class OpenjobController extends AbstractController<OpenjobDTO>{
	
	@Autowired
	private OpenjobService openjobService;


	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public OpenjobDTO login( @RequestBody LoginDTO loginDTO ) {
		return openjobService.findById(loginDTO.getId());
	}
	
	@GetMapping(value = "/readOpenjob")
	public OpenjobDTO readOpenjob(@RequestParam Integer idCompany ) {
		//System.out.println("Sono nel controller e ho prelevat l'oggetto con idCompany: " + openjobService.findByIdCompany(idCompany).getIdCompany());
		return openjobService.findByIdCompany(idCompany);
	}
}