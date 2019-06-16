package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Candidato;
import it.contrader.model.Company;

public class CompanyView extends AbstractView implements View{

	private String choice;
	private Request request;

	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		List<Company> listacompany = (List<Company>) request.get("companys");
		System.out.println("NOME             INFO              OPENJOB");
		for (Company x : listacompany) {
			System.out.println(x.getName() +"        "+x.getInfo() + "    " +x.getOpenjob());
		}
	}
	
	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("-------MENU COMPANY-------\n");
        System.out.println("Completa profilo del company :");
        System.out.println("[I]nserisci [C]ancella [A]ggiorna  [E]sci");
        this.choice = this.getInput();
	}
	@Override
	public void submit() {
		// TODO Auto-generated method stub
		 request = new Request();
        switch (choice) {
        case "i":
     
        	MainDispatcher.getInstance().callView("company.CompanyInsert", null);
        	break;
        	
case "c":
        	
        	MainDispatcher.getInstance().callView("company.CompanyDelete", null);
        	break;
        	
        case "a":
        	
        	MainDispatcher.getInstance().callView("company.CompanyUpdate",null);
        	break;
        	
        case "e":
        	MainDispatcher.getInstance().callView("HomeAdmin", null);
        	break;
        default:
        	
            request.put("choice", choice);
        	MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
	}

}
