package object;

public class Bilet {
    private String Imie_kupujacego;
    private Integer idbilet;
    private Double cena;
    private String typplatnosci;
    private String typznizki;
    private Integer idseansu;
    private Integer idmiejsce;

    public Bilet(Integer idbilet,Double cena,String typplatnosci,String typznizki,String Imie_kupujacego,Integer idseansu,Integer idmiejsce){
        this.idbilet=idbilet;
        this.cena=cena;
        this.typplatnosci=typplatnosci;
        this.typznizki=typznizki;
        this.Imie_kupujacego=Imie_kupujacego;
        this.idseansu=idseansu;
        this.idmiejsce=idmiejsce;
    }


    public String WypiszImie(){
        return Imie_kupujacego;
    }
    public void WpiszImie(String a){
        Imie_kupujacego = a;
    }

    public Integer getIdbilet(){ return idbilet;}
    public void setIdbilet(Integer id2) { this.idbilet=id2;}

    public Double getCena()   {  return cena;   }
    public void setCena(Double cn)
    {
        this.cena=cn;
    }

    public String getTypplatnosci()

    {
        return typplatnosci;
    }
    public void setTypplatnosci(String tp)
    {
        this.typplatnosci=tp;
    }

    public String getTypznizki(){ return typznizki; }
    public void setTypznizki(String tz)    {  this.typznizki=tz;   }

    public Integer getIdseansu() { return idseansu;  }
    public void setIdseansu(Integer ids)
    {
        this.idseansu=ids;
    }

    public Integer getIdmiejsce()
    {
        return idmiejsce;
    }
    public void setIdmiejsce(Integer idm){ this.idmiejsce=idm; }


}
