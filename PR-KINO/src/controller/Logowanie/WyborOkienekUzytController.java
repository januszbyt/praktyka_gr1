package controller.Logowanie;

import controller.MainController;

public class WyborOkienekUzytController {
    private MainController main;
    public void init(MainController main){
        this.main = main;
    }
    public void przejscie_do_recenzji(){
main.ViewController.changeBody("URecenzja");
    }
    public void przejscie_do_zakupu(){
        main.ViewController.changeBody("UWybor_filmu");
    }

}
