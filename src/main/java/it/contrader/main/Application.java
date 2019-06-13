package it.contrader.main;

public class Application {

    public static void main(String[] args) {
        MainDispatcher.getInstance().callAction("Login", "doControl", null);
        //esegue il metodo doControl del login Controller passando un parametro in questo caso null
    }

}
