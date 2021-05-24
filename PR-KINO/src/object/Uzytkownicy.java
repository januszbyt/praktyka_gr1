package object;


public class Uzytkownicy {

    private Integer id;
    private String login;
    private String haslo;
    private String imie;
    private String nazwisko;
    private String pesel;
    private String email;


    public Uzytkownicy(Integer id,String login,String haslo,String imie,String nazwisko,String pesel,String email)
    {
        this.id=id;
        this.login=login;
        this.haslo=haslo;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.pesel=pesel;
        this.email=email;
    }
    public Integer getId(){ return id; }
    public void setId(Integer id)    {  this.id=id;   }

    public String getLogin(){ return login; }
    public void setLogin(String lg)    {  this.login=lg;   }

    public String getHaslo(){ return haslo; }
    public void setHaslo(String ha)    {  this.haslo=ha;   }

    public String getImie(){ return imie; }
    public void setImie(String im)    {  this.imie=im;   }

    public String getNazwisko(){ return nazwisko; }
    public void setNazwisko(String naz)    {  this.nazwisko=naz;   }

    public String getPesel(){ return pesel; }
    public void setPesel(String psl)    {  this.pesel=psl;   }

    public String getEmail(){ return email; }
    public void setEmail(String ml)    {  this.email=ml;   }


}
