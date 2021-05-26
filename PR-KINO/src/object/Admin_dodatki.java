package object;

public class Admin_dodatki {
    private Integer id;
    private String nazwa;
    private String typ;
    private Double cena;
    private Integer ilosc;

    public Admin_dodatki(Integer id,String nazwa, String typ, Double cena,Integer ilosc) {
        this.id=id;
        this.nazwa = nazwa;
        this.typ = typ;
        this.cena = cena;
        this.ilosc = ilosc;
    }
    public String getNazwa(){return nazwa;}
    public void setNazwa(String nz){this.nazwa=nz;}
    public String getTyp()  { return typ; }
    public void setTyp(String tp) { this.typ=tp; }
    public Double getCena(){ return cena; }
    public void setCena(Double ca)  {  this.cena=ca;   }
    public Integer getIlosc(){ return ilosc; }
    public void setIlosc(Integer ic)    {  this.ilosc=ic;}
    public Integer getId(){ return id;}
    public void setId(Integer id1){ this.id=id1;}




}
