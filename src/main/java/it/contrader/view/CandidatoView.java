package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Candidato;

public class CandidatoView extends AbstractView implements View{

	private String choice;
	private Request request;
	
	@Override
	public void showResults(Request request) {
		// TODO Auto-generated method stub
		List<Candidato> listacandidati = (List<Candidato>) request.get("candidatos");
		System.out.println("NOME             EDUCAZIONE              ESPERIENZE");
		for (Candidato x : listacandidati) {
			System.out.println(x.getName() +"        "+x.getEducation() + "    " +x.getExperience());
		}
	}

	@Override
	public void showOptions() {
		// TODO Auto-generated method stub
		System.out.println("-------MENU CANDIDATO-------\n");
        System.out.println("Completa profilo del candidato :");
        System.out.println("[I]nserisci [C]ancella [A]ggiorna  [E]sci");
        this.choice = this.getInput();
	}

	@Override
	public void submit() {
		// TODO Auto-generated method stub
		 request = new Request();
        switch (choice) {
        case "i":
     
        	MainDispatcher.getInstance().callView("candidato.CandidatoInsert", null);
        	break;
 
        case "c":
        	
        	MainDispatcher.getInstance().callView("candidato.CandidatoDelete", null);
        	break;
        	
        case "a":
        	
        	MainDispatcher.getInstance().callView("candidato.CandidatoUpdate",null);
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
