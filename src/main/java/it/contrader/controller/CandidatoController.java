package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
/*Sono i controller a farsi carico della gestone vera e propria delle request,
 * le quali vengono recapitate in base agli url di destinazione.
 * Vi sarà un'unica serlet che prende il nome di dispatcher servlet che attraverso l'annotation RequestMapping riconosce
 * quali url sono associate ad un certo controller*/
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CandidatoDTO;
import it.contrader.services.CandidatoService;

import java.util.List;


@Controller //da utilizzare a livello di classe per identificarla come controller
@RequestMapping("/Candidato") //da utilizzare per evidenziare il metodo e l'url da mappare
public class CandidatoController {

	private final CandidatoService candidatoService;
	private HttpSession session;
	private int id;
	
	@Autowired //permette di inettare le dipendenze all'interno di una classe, sostituisce il costruttore
	public CandidatoController(CandidatoService candidatoService) {
		this.candidatoService = candidatoService;
	}

	private void visualCandidato(HttpServletRequest request){
		List<CandidatoDTO> allCandidato = this.candidatoService.getListaCandidatoDTO();
		request.setAttribute("allCandidatoDTO", allCandidato);
	}
	
	@RequestMapping(value = "/candidatoManagement", method = RequestMethod.GET) /*usando l'annotazione in questo modo stiamo gestendo
	                                                                             le sole GET per l'indirizzo candidatoManagement
	                                                                             attraverso 'method' stiamo usando i metodi HTTP
	                                                                             GET : si usa nella read per ottenere qualcosa senza 
	                                                                             passare parametri (cambio pagina) o se passi parametri
	                                                                             si vedono in chiaro nell'url*/
	public String candidatoManagement(HttpServletRequest request) {
		visualCandidato(request);
		return "homeCandidato";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.candidatoService.deleteCandidatoById(id);
		visualCandidato(request);
		return "homeCandidato";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualCandidato(request);
		request.setAttribute("option", "insert");
		return "creaCandidato";
		
	}
	
	@RequestMapping(value = "/cercaCandidato", method = RequestMethod.GET)
	public String cercaCandidato(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<CandidatoDTO> allCandidato = this.candidatoService.findCandidatoDTOByUsername(content);
		request.setAttribute("allCandidatoDTO", allCandidato);

		return "homeCandidato";

	}
	
	@RequestMapping(value = "/creaCandidato", method = RequestMethod.POST) /*POST: si utilizza nel create per ottenere qualcosa
	                                                                       passando dei parametri che non si vedono
	                                                                       in chiaro nell'url*/
	public String insertCandidato(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String name = request.getParameter("name").toString();
		String surname = request.getParameter("surname").toString();
		Integer age = Integer.parseInt(request.getParameter("age"));
		String tipolaurea = request.getParameter("tipolaurea").toString();
		String experience = request.getParameter("experience").toString();

		CandidatoDTO candidatoObj = new CandidatoDTO();
		
		candidatoService.insertCandidato(candidatoObj);

		visualCandidato(request);
		return "homeCandidato";
	}
	
}