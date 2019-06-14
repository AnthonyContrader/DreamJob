package it.contrader.main;

import java.io.IOException;
import java.lang.reflect.Method;

import it.contrader.controller.Controller;
import it.contrader.controller.GestoreEccezioni;
import it.contrader.controller.Request;
import it.contrader.view.View;

public class MainDispatcher {

	private MainDispatcher() {
	}

	private static MainDispatcher instance;

	public static MainDispatcher getInstance() {
		if (instance == null) {
			instance = new MainDispatcher();
		}
		return instance;
	}

	public void callAction(String controller, String action, Request request) {
		Controller oggettoController = (Controller) ReflectionUtils
				.instantiateClass("it.contrader.controller." + controller + "Controller");
		try {
			Method metodo = oggettoController.getClass().getMethod(action, Request.class);
			metodo.invoke(oggettoController, request);
		} catch (Throwable e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
		}
	}

	public void callView(String view, Request request) {
		System.out.println("la string view " + view);
		System.out.println("la request " + request);
		/**
		 * l'errore era nel cast in tipo view, le classi che stavamo chiamando non implementavano
		 * l'interfaccia View che si trova nel package .view, quindi in fase di compilazione
		 * la JVM non riesce a tradurre.
		 */
		View oggettoView = (View) ReflectionUtils.instantiateClass("it.contrader.view." + view + "View");
		oggettoView.showResults(request);
		oggettoView.showOptions();
		oggettoView.submit();
		try {
			Runtime.getRuntime().exec("clear");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
