package controller.Logowanie;

import controller.MainController;

public class RejestracjaController {
    private MainController main;

    public void init(MainController main){
        this.main = main;
    }

    public void wypisz(){
        System.out.println(this.main.Bilet.WypiszImie());
    }
}
