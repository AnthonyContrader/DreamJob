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
	
	@RequestMapping(value = "/openjobManagement", method = RequestMethod.GET)
	public String openjobManagement(HttpServletRequest request) {
		visualOpenjob(request);
		return "homeOpenjob";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.openjobService.deleteOpenjobById(id);
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
		

		OpenjobDTO openjobObj = new OpenjobDTO();
		
		openjobService.insertOpenjob(openjobObj);

		visualOpenjob(request);
		return "homeOpenjob";
	}
	

}
