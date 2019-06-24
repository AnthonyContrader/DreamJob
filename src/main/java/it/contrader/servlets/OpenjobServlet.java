package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.OpenjobDTO;
import it.contrader.service.OpenjobService;
import it.contrader.service.Service;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class OpenjobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OpenjobServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<OpenjobDTO> service = new OpenjobService();
		List<OpenjobDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<OpenjobDTO> service = new OpenjobService();
		String mode = request.getParameter("mode");
		OpenjobDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "JOBLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/openjob/openjobmanager.jsp").forward(request, response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);
			System.out.println("entra nell'openjob read");
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/openjob/readopenjob.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/openjob/updateopenjob.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String titolo = request.getParameter("titolo").toString();
			String descrizione = request.getParameter("descrizione").toString();
			String requisiti = request.getParameter("requisiti").toString();
			dto = new OpenjobDTO (titolo,descrizione,requisiti);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/openjob/openjobmanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			titolo = request.getParameter("titolo");
			descrizione = request.getParameter("descrizione");
			requisiti = request.getParameter("requisiti");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new OpenjobDTO (id,titolo, descrizione, requisiti);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/openjob/openjobmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/openjob/openjobmanager.jsp").forward(request, response);
			break;
		}
	}
}