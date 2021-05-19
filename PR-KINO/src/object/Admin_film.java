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
    private String typ;
    private Base64 zdjecie;


    public void Admin_film(String tytul, String gatunek, String dlugosc_filmu, String rezyser, String typ,String kraj, String opis, int rokprod){
        this.tytul=tytul;
        this.gatunek=gatunek;
        this.dlugosc_filmu=dlugosc_filmu;
        this.rezyser=rezyser;
        this.typ=typ;
        this.kraj=kraj;
        this.opis=opis;
        this.rokprod=rokprod;

    }
    public void Afilm(){

    }

    public String getTytul()
    {
        return tytul;
    }
    public void setTytul(String tt)
    {
        this.tytul=tt;
    }

    public String getGatunek()

    {
        return gatunek;
    }
    public void setGatunek(String gt)
    {
        this.gatunek=gt;
    }

    public String getDlugosc_filmu(){ return dlugosc_filmu; }
    public void setDlugosc_filmu(String df)
    {
        this.dlugosc_filmu=df;
    }

    public String getRezyser()
    {
        return rezyser;
    }
    public void setRezyser(String re)
    {
        this.rezyser=re;
    }

    public String getTyp()
    {
        return typ;
    }
    public void setTyp(String tp){ this.typ=tp; }

    public String getKraj()
    {
        return kraj;
    }
    public void setKraj(String kr)
    {
        this.kraj=kr;
    }

    public String getOpis()
    {
        return opis;
    }
    public void setOpis(String op) { this.opis=op; }
    public int getRokprod()
    {
        return rokprod;
    }
    public void setRokprod(String rp)
    {
        this.opis=rp;
    }



    public void wypiszDane(){
        System.out.println(tytul + " " + gatunek + " " + dlugosc_filmu + " " + rezyser + " " + kraj + " " + opis + " " + rokprod + " " + typ);
    }







}
