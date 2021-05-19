package object;

public class Bilet {
    private String Imie_kupujacego;


    public Bilet(){

    }


    public void WpiszImie(String a){
        Imie_kupujacego = a;
    }
    public String WypiszImie(){
        return Imie_kupujacego;
    }
}
