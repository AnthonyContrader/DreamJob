/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeCandidatoView extends AbstractView implements View {

    private String choice;

	//private String choice;
    
    private Request request;

    public void showResults(Request request) {
    	if(request!=null) {
    	System.out.println("Benvenuto in dreamjob "+request.get("username").toString());
    }
    }


    public void showOptions() {
        System.out.println("-------MENU CANDIDATO-------\n");
        System.out.println("Completa profilo del candidato :");
        System.out.println("[I]nserisci [C]ancella [A]ggiorna [V]isualizza [E]sci");
        this.choice = this.getInput();
    }

    public void submit() {
    	if (choice.equalsIgnoreCase("I")) {
          	MainDispatcher.getInstance().callView("CandidatoInsert", null);
          }
          
          if (choice.equalsIgnoreCase("C"))
              MainDispatcher.getInstance().callView("CandidatoDelete", null);
          if (choice.equalsIgnoreCase("A"))
              MainDispatcher.getInstance().callView("CandidatoUpdate", null);
          if (choice.equalsIgnoreCase("V"))
              MainDispatcher.getInstance().callView("CandidatoRead", null);
          else {
              Request request = new Request();
              request.put("choice", choice);
              MainDispatcher.getInstance().callAction("Login", "doControl", request);
          }
      }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}

       