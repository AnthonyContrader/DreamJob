package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CandidatoDTO;
import it.contrader.dto.OpenjobDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.OpenjobService;

import java.util.List;


@Controller
@RequestMapping("/Openjob")
public class OpenjobController {

	private final OpenjobService openjobService;
	private HttpSession session;
	private int id;
	
	@Autowired
	public OpenjobController(OpenjobService openjobService) {
		this.openjobService = openjobService;
	}

	private void visualOpenjob(HttpServletRequest request){
		List<OpenjobDTO> allOpenjob = this.openjobService.getListaOpenjobDTO();
		request.setAttribute("allOpenjobDTO", allOpenjob);
	}
	
	@RequestMapping(value = "/companyManagement", method = RequestMethod.GET)
	public String companyManagement(HttpServletRequest request) {
		visualOpenjob(request);
		return "homeCompany";		
	}
	
	@RequestMapping(value = "/myJobs", method = RequestMethod.GET)
	public String myJobs(HttpServletRequest request){
		int idCompany = Integer.parseInt(request.getParameter("id"));
		 List<OpenjobDTO> wList = this.openjobService.getMyJobs(idCompany);
		 request.setAttribute("list", wList);
		return "homeOpenjob";
		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		OpenjobDTO x = this.openjobService.readOpenjobById(id);
		request.setAttribute("dto", x);
		return "homeOpenjob";
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String titoloUpdate = request.getParameter("titolo");
		String descrizioneUpdate = request.getParameter("descrizione");
		String requisitiUpdate = request.getParameter("requisiti");
		
		final OpenjobDTO openjob = new OpenjobDTO(titoloUpdate,descrizioneUpdate,requisitiUpdate);
		openjob.setId(id);
		
		openjobService.updateOpenjob(openjob);
		List<OpenjobDTO> list = this.openjobService.getListaOpenjobDTO();
		request.setAttribute("openjob", list);
		return "homeOpenjob";	
		
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		OpenjobDTO openjob = openjobService.getOpenjobDTOById(id);
		
		request.setAttribute("openjob", openjob);
		return "read";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		this.openjobService.deleteOpenjobById(id);
		List<OpenjobDTO> list = this.openjobService.getListaOpenjobDTO();
		request.setAttribute("read", list);
		visualOpenjob(request);
		return "homeOpenjob";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualOpenjob(request);
		request.setAttribute("option", "insert");
		return "creaOpenjob";
		
	}
	
	@RequestMapping(value = "/cercaOpenjob", method = RequestMethod.GET)
	public String cercaOpenjob(HttpServletRequest request) {

		final Integer content = Integer.parseInt(request.getParameter("search"));

		List<OpenjobDTO> allOpenjob = this.openjobService.findOpenjobDTOById(content);
		request.setAttribute("allOpenjobDTO", allOpenjob);

		return "homeOpenjob";

	}
	
	@RequestMapping(value = "/creaOpenjob", method = RequestMethod.POST)
	public String insertOpenjob(HttpServletRequest request) {
		String titolo = request.getParameter("titolo").toString();
		String descrizione = request.getParameter("descrizione").toString();
		String requisiti = request.getParameter("requisiti").toString();
 // state salvando un oggetto vuoto, dovete fare un costruttore pieno 
		OpenjobDTO openjobObj = new OpenjobDTO(titolo, descrizione, requisiti);
		
		openjobService.insertOpenjob(openjobObj);

		visualOpenjob(request);
		return "homeCompany";
	}
	

}
