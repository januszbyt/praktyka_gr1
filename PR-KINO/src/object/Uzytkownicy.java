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



}
