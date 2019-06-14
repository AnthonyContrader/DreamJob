package it.contrader.controller;

import it.contrader.main.MainDispatcher;

import it.contrader.service.LoginService;

public class HomeController implements Controller {

    private LoginService loginService;

    public HomeController() {
        loginService = new LoginService();
    }

    public void doControl(Request request) {
        if (request != null) {
            String username = request.get("username").toString();
            String password = request.get("password").toString();
            //prende i dati nel pacchetto request e li fa ritornare singoli
            
            //Change view according userType
            String userType= loginService.login(username, password);
            //serve per ottenere un utente dal db
            System.out.println(userType);
           
            
            if(userType==null)
                MainDispatcher.getInstance().callAction("Login", "doControl", request);
            	
            if (userType.equals("admin"))
                MainDispatcher.getInstance().callView("HomeAdmin", request);
            
            if (userType.equals("candidato")) 
            	MainDispatcher.getInstance().callView("HomeCandidato", request);
           
            if (userType.equals("company")) {
            	
            	// aggiungere info
            	MainDispatcher.getInstance().callView("HomeCompany", request);
            }
           }
        else MainDispatcher.getInstance().callView("Login", null);

    }
}
