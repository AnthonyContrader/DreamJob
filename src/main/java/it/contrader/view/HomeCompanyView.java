/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeCompanyView extends AbstractView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println(" request " + request);
    	System.out.println("Benvenuto in dreamjob "+request.get("username").toString());
    }


    public void showOptions() {
        System.out.println("-------MENU COMPANY-------\n"); 
        System.out.println("Seleziona cosa vuoi effettuare:");
        System.out.println("[I]nserisci [C]ancella [A]ggiorna [V]isualizza [E]sci");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("I")) {
        	MainDispatcher.getInstance().callView("CompanyInsert", null);
        }
        
        if (choice.equalsIgnoreCase("C"))
            MainDispatcher.getInstance().callView("CompanyDelete", null);
        if (choice.equalsIgnoreCase("A"))
            MainDispatcher.getInstance().callView("CompanyUpdate", null);
        if (choice.equalsIgnoreCase("V"))
            MainDispatcher.getInstance().callView("CompanyRead", null);
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
