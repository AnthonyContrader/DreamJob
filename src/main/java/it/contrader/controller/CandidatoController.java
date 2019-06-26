package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CandidatoDTO;
import it.contrader.services.CandidatoService;

import java.util.List;


@Controller
@RequestMapping("/Candidato")
public class CandidatoController {

	private final CandidatoService candidatoService;
	private HttpSession session;
	private int id;
	
	@Autowired
	public CandidatoController(CandidatoService candidatoService) {
		this.candidatoService = candidatoService;
	}

	private void visualCandidato(HttpServletRequest request){
		List<CandidatoDTO> allCandidato = this.candidatoService.getListaCandidatoDTO();
		request.setAttribute("allCandidatoDTO", allCandidato);
	}
	
	@RequestMapping(value = "/candidatoManagement", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "/creaCandidato", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final CandidatoDTO candidatoDTO = candidatoService.getByUsernameAndPassword(username, password);
		
		
		return "index";
	}
}
