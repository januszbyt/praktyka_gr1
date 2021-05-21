package object;
import java.util.Base64;

public class Admin_film {
    private String tytul;
    private String gatunek;
    private Integer dlugosc;
    private String rezyser;
    private String kraj;
    private String opis;
    private Integer rokprodukcji;
    private String typ;
    private Base64 zdjecie;

    public Admin_film(String tytul, String gatunek, Integer dlugosc, String rezyser, String kraj, String opis, Integer rokprodukcji, String typ) {
    }


    public void Admin_film(String tytul, String gatunek, Integer dlugosc, String rezyser,String kraj, String opis, Integer rokprodukcji,String typ){
        this.tytul=tytul;
        this.gatunek=gatunek;
        this.dlugosc=dlugosc;
        this.rezyser=rezyser;
        this.kraj=kraj;
        this.opis=opis;
        this.rokprodukcji=rokprodukcji;
        this.typ=typ;

    }
    public void Admin_film(){ }

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

    public int getDlugosc(){ return dlugosc; }
    public void setDlugosc(Integer df)    {  this.dlugosc=df;   }

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
        return rokprodukcji;
    }
    public void setRokprod(Integer rp)
    {
        this.rokprodukcji=rp;
    }



    public void wypiszDane(){
        System.out.println(tytul + " " + gatunek + " " + dlugosc + " " + rezyser + " " + kraj + " " + opis + " " + rokprodukcji + " " + typ);
    }







}
