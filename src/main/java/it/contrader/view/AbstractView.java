package it.contrader.view;

import java.util.Scanner;

public class AbstractView {
	private Scanner scanner;

	/**
	*Questo metodo � usato da tutti i controller che lo ereditano (non devono definirlo) estendendo questa classe
	*/
	public String getInput() {
		scanner = new Scanner(System.in);
		return scanner.nextLine();
	}
}


