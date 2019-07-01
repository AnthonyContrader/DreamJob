package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.CandidatoDTO;
import it.contrader.dto.CompanyDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.CandidatoService;
import it.contrader.services.CompanyService;
import it.contrader.services.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/User")

public class UserController {

	private final UserService userService;
	private final CompanyService coService;
	private final CandidatoService caService;
	private HttpSession session;
	private int id;
	
	@Autowired
	public UserController(UserService userService,CompanyService coService,CandidatoService caService) {
		this.userService = userService;
		this.caService = caService;
		this.coService = coService;
	}

	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		visualUser(request);
		return "homeAdmin";		
	}
	
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String read(HttpServletRequest request) {
		visualUser(request);
		List<UserDTO> list = this.userService.getListaUserDTO();
		request.setAttribute("read", list);
		
		return "readUser";
		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		this.userService.deleteUserById(id);
		List<UserDTO> list = this.userService.getListaUserDTO();
		request.setAttribute("read", list);
		visualUser(request);
		return "readUser";
		
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request)
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		String usertypeUpdate = request.getParameter("usertype");
		
		final UserDTO user = new UserDTO(usernameUpdate,passwordUpdate,usertypeUpdate);
		user.setId(id);
		
		userService.updateUser(user);
		List<UserDTO> list = this.userService.getListaUserDTO();
		request.setAttribute("user", list);
		return "readUser";	
		
	}
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDTO user = userService.getUserDTOById(id);
		
		request.setAttribute("user", user);
		return "updateUser";
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	
	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
		request.setAttribute("allUserDTO", allUser);

		return "homeAdmin";

	}
	
	@RequestMapping(value = "/creaUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = request.getParameter("usertype").toString();
		
		UserDTO userObj = new UserDTO(username, password,usertype);
		
		userService.insertUser(userObj);
		
		switch(usertype) {
		case "candidato":
			CandidatoDTO cA = new CandidatoDTO(userObj.getUsername(),userObj.getPassword());
			caService.insertCandidato(cA);
			break;
		case "company":
			CompanyDTO cO = new CompanyDTO(userObj.getUsername(),userObj.getPassword());
			coService.insertCompany(cO);
			break;
		default:
			break;
		}
		visualUser(request);
		return "homeAdmin";
	}

		@RequestMapping(value = "/login", method = RequestMethod.POST)
		public String loginControl(HttpServletRequest request) {
			session = request.getSession();
			final String username = request.getParameter("username");
			final String password = request.getParameter("password");
			final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
			
			final String usertype = userDTO.getUsertype();
			System.out.println("user type " + usertype);
			
			if (!StringUtils.isEmpty(usertype)) {
				session.setAttribute("utenteCollegato", userDTO);
				if (usertype.equals("admin")) {
					return "homeAdmin";
				} else if (usertype.equals("candidato")) {
					System.out.print("qua");
					return "homeCandidato";
				} else if (usertype.equals("company")) {
					return "homeCompany";
				}
			}
			return "index";
		}

		@RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logOut(HttpServletRequest request) {
			request.getSession().invalidate();
			return "index";
		}
	}
