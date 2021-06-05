package object;

public class UDodatki {

    private int id;
    private String nazwa;
    private double cena;
    private int ilosc;
    private String typ;
    private String url;

    public UDodatki(int ID,String Nazwa,double Cena,int Ilosc,String Typ,
                    String Url){
        this.id=ID;
        this.nazwa=Nazwa;
        this.cena=Cena;
        this.ilosc=Ilosc;
        this.typ=Typ;
        this.url=Url;
    }

    public int getId() {
        return id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    public int getIlosc() {
        return ilosc;
    }

    public String getTyp() {
        return typ;
    }

    public String getUrl() {
        return url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
