package object;

import java.util.ArrayList;
import java.util.List;

public class Bilet {
    private String Imie_kupujacego;
    private Integer idbilet;
    private Double cena;
    private String typplatnosci;
    private String typznizki;
    private Integer idmiejsce;
    private Integer idseansu;
    private Integer idFilmu;
    private List<wybrane_miejsce> wybraneMiejsca = new ArrayList<wybrane_miejsce>();
    public Bilet(){
    }

    public void setWybraneMiejsca(List<wybrane_miejsce> lista){
        this.wybraneMiejsca = lista;
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

    public Integer getIdFilm()
    {
        return idFilmu;
    }
    public void setIdFilm(Integer idm){ this.idFilmu=idm; }

}
