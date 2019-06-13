package it.contrader.controller;

import it.contrader.main.MainDispatcher;

public class LoginController implements Controller {

    public LoginController() {
    }

    public void doControl (Request request) {
        MainDispatcher.getInstance().callView("Login", request);
        // esegue tre metodi del login view
    }
}
