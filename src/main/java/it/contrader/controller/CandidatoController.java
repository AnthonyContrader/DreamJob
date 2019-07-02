package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.CandidatoDTO;
import it.contrader.dto.LoginDTO;
import it.contrader.service.CandidatoService;



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
@RequestMapping("/candidato")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidatoController extends AbstractController<CandidatoDTO>{
	
	@Autowired
	private CandidatoService candidatoService;


	//POST Angular a UserDTO
	@PostMapping(value = "/login")
	public CandidatoDTO login( @RequestBody LoginDTO loginDTO ) {
		return candidatoService.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
	}
}