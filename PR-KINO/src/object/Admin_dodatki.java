package object;

public class Admin_dodatki {
    private String nazwa;
    private String typ;
    private Integer cena;
    private Integer ilosc;
    private Integer id;
    public Admin_dodatki( Integer id,String nazwa, String typ, Integer cena,Integer ilosc) {
       this.id = id;
        this.nazwa = nazwa;
        this.typ = typ;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public String getnazwa(){return nazwa;}
    public void setnazwa(String nz){this.nazwa=nz;}
    public String gettyp()

    {
        return typ;
    }
    public void settyp(String tp) { this.typ=tp; }
    public int getcena(){ return cena; }
    public void setCena(Integer ca)  {  this.cena=ca;   }
    public int getilosc(){ return ilosc; }
    public void setilosc(Integer ic)    {  this.ilosc=ic;}
    public void setId(Integer id)    {  this.id=id;   }
    public Integer getId(){ return id;}


}
