package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CompanyDTO;
import it.contrader.services.CompanyService;

import java.util.List;


@Controller
@RequestMapping("/Company")
public class CompanyController {

	private final CompanyService companyService;
	private HttpSession session;
	private int id;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	private void visualCompany(HttpServletRequest request){
		List<CompanyDTO> allCompany = this.companyService.getListaCompanyDTO();
		request.setAttribute("allCompanyDTO", allCompany);
	}
	
	@RequestMapping(value = "/companyManagement", method = RequestMethod.GET)
	public String companyManagement(HttpServletRequest request) {
		visualCompany(request);
		return "homeCompany";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.companyService.deleteCompanyById(id);
		visualCompany(request);
		return "homeCompany";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualCompany(request);
		request.setAttribute("option", "insert");
		return "creaCompany";
		
	}
	
	@RequestMapping(value = "/cercaCompany", method = RequestMethod.GET)
	public String cercaCompany(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<CompanyDTO> allCompany = this.companyService.findCompanyDTOByUsername(content);
		request.setAttribute("allCompanyDTO", allCompany);

		return "homeCompany";

	}
	
	@RequestMapping(value = "/creaCompany", method = RequestMethod.POST)
	public String insertCompany(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String name = request.getParameter("name").toString();
		String info = request.getParameter("info").toString();
		

		CompanyDTO companyObj = new CompanyDTO();
		
		companyService.insertCompany(companyObj);

		visualCompany(request);
		return "homeCompany";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final CompanyDTO companyDTO = companyService.getByUsernameAndPassword(username, password);
		
		
		return "index";
	}
}
