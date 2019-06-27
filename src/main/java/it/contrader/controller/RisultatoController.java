package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.OpenjobDTO;
import it.contrader.dto.RisultatoDTO;
import it.contrader.services.RisultatoService;

import java.util.List;


@Controller
@RequestMapping("/Risultato")
public class RisultatoController {

	private final RisultatoService risultatoService;
	private HttpSession session;
	private int id;

	@Autowired
	public RisultatoController(RisultatoService risultatoService) {
		this.risultatoService = risultatoService;
	}

	private void visualRisultato(HttpServletRequest request){
		List<RisultatoDTO> allRisultato = this.risultatoService.getListaRisultatoDTO();
		request.setAttribute("allRisultatoDTO", allRisultato);
	}

	@RequestMapping(value = "/risultatoManagement", method = RequestMethod.GET)
	public String risultatoManagement(HttpServletRequest request) {
		visualRisultato(request);
		return "homeRisultato";		
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.risultatoService.deleteRisultatoById(id);
		visualRisultato(request);
		return "homeRisultato";
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualRisultato(request);
		request.setAttribute("option", "insert");
		return "creaRisultato";
	}
	
	@RequestMapping(value = "/cercaRisultato", method = RequestMethod.GET)
	public String cercaRisultato(HttpServletRequest request) {

		final Integer id = Integer.parseInt(request.getParameter("search"));

		List<RisultatoDTO> allRisultato = this.risultatoService.findRisultatoDTOById(id);
		request.setAttribute("allRisultatoDTO", allRisultato);

		return "homeRisultato";
	}
	
	@RequestMapping(value = "/creaRisultato", method = RequestMethod.POST)
	public String insertRisultato(HttpServletRequest request) {
		String descrizione = request.getParameter("descrizione").toString();

		RisultatoDTO risultatoObj = new RisultatoDTO();
		
		risultatoService.insertRisultato(risultatoObj);

		visualRisultato(request);
		return "homeRisultato";
	}
	
}
