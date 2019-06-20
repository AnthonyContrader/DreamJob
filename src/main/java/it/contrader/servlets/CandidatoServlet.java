package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CandidatoDTO;
import it.contrader.service.Service;
import it.contrader.service.CandidatoService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CandidatoServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CandidatoDTO> service = new CandidatoService();
		List<CandidatoDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CandidatoDTO> service = new CandidatoService();
		String mode = request.getParameter("mode");
		CandidatoDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "CANDIDATOLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/candidato/candidatomanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/candidato/readcandidato.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/candidato/updatecandidato.jsp").forward(request, response);
			
			break;

		case "INSERT":
//			System.out.println("ilaria");
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			String name = request.getParameter("name").toString();
			String surname = request.getParameter("surname").toString();
			int age = Integer.parseInt(request.getParameter("age"));
			String education = request.getParameter("education").toString();
			String experience = request.getParameter("experience").toString();
			
			dto = new CandidatoDTO (username,password,name,surname,age,education,experience);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/candidato/candidatomanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			username = request.getParameter("username");
			password = request.getParameter("password");
			name = request.getParameter("name");
			surname = request.getParameter("surname");
			age = Integer.parseInt(request.getParameter("age"));
			education = request.getParameter("education");
			experience = request.getParameter("experience");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CandidatoDTO (username, password, name, surname, age, education, experience);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/candidato/candidatomanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/candidato/candidatomanager.jsp").forward(request, response);
			break;
		}
	}
}