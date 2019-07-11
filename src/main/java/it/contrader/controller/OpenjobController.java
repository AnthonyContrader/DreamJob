package it.contrader.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.OpenjobDTO;
import it.contrader.model.Company;
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
@CrossOrigin(origins = "*")
public class OpenjobController extends AbstractController<OpenjobDTO>{
	
	@Autowired
	private OpenjobService openjobService;

	@PostMapping(value = "/getallbycompany")
	public List<OpenjobDTO> getAllByCompany(@RequestBody Company company ) {
		return openjobService.findAllByCompany(company);
	}
	
}