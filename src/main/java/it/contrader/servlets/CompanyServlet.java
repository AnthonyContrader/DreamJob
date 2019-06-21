package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.CompanyDTO;
import it.contrader.service.CompanyService;
import it.contrader.service.Service;


/*
 * Per dettagli vedi Guida sez Servlet
 */
public class CompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompanyServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<CompanyDTO> service = new CompanyService();
		List<CompanyDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<CompanyDTO> service = new CompanyService();
		String mode = request.getParameter("mode");
		CompanyDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "COMPANYLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/company/companymanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			System.out.println("ecco lid" + id);
			
			dto = service.read(id);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/company/companymanager.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/company/updatecompany.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String name = request.getParameter("name").toString();
			String info = request.getParameter("info").toString();
			String username = request.getParameter("username").toString();
			String password = request.getParameter("password").toString();
			Integer openjob = Integer.parseInt(request.getParameter("idopenjob").toString());
			Integer candidato =Integer.parseInt( request.getParameter("idcandidato").toString());
			dto = new CompanyDTO (name,info,username,password,openjob,candidato);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/company/companymanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			name = request.getParameter("name");
			info = request.getParameter("info");
			username = request.getParameter("username");
			password = request.getParameter("password");
			openjob = Integer.parseInt(request.getParameter("openjob"));
			candidato = Integer.parseInt(request.getParameter("candidato"));
			id = Integer.parseInt(request.getParameter("id"));
			dto = new CompanyDTO (id,name,info,username,password,openjob,candidato);
			ans = service.update(dto);
			request.setAttribute("dto", dto);
			
			getServletContext().getRequestDispatcher("/company/companymanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/company/companymanager.jsp").forward(request, response);
			break;
		}
	}
}