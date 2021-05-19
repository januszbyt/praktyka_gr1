package controller.Administrator;

import java.util.Base64;

public class AFilmy {
    private String tytul;
    private String gatunek;
    private String dlugosc_filmu;
    private String rezyser;
    private String kraj;
    private String opis;
    private int rokprod;
    private String typ;
    private Base64 zdjecie;
    public void wpiszDane(String tytul, String gatunek, String dlugosc_filmu, String rezyser, String kraj, String opis, int rokprod, String typ){
        this.tytul=tytul;
        this.gatunek=gatunek;
        this.dlugosc_filmu=dlugosc_filmu;
        this.rezyser=rezyser;
        this.kraj=kraj;
        this.opis=opis;
        this.rokprod=rokprod;
        this.typ=typ;
    }















}
