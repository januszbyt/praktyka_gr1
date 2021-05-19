package object;

import java.util.Base64;

public class Admin_film {
    private String tytul;
    private String gatunek;
    private String dlugosc_filmu;
    private String rezyser;
    private String kraj;
    private String opis;
    private int rokprod;
    private Base64 zdjecie;


    public void wpiszDane(String tytul, String gatunek, String dlugosc_filmu, String rezyser, String kraj, String opis, int rokprod){
        this.tytul=tytul;
        this.gatunek=gatunek;
        this.dlugosc_filmu=dlugosc_filmu;
        this.rezyser=rezyser;
        this.kraj=kraj;
        this.opis=opis;
        this.rokprod=rokprod;
    }
    public String getTytul()
    {
        return tytul;
    }
    public void setTytul(String tt)
    {
        this.tytul=tytul;
    }




    
    public void wypiszDane(){
        System.out.println(tytul + " " + gatunek + " " + dlugosc_filmu + " " + rezyser + " " + kraj + " " + opis + " " + rokprod);
    }







}
