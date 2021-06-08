package controller.Użytkownik;

import controller.MainController;

public class UZnizkiController {
    private MainController main;
    public void init(MainController main) {
        this.main = main;
    }
    public void wroc(){
        main.ViewController.changeBody("UWybor_miejsca");
    }
}

