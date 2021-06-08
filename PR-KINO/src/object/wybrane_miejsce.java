package object;

public class wybrane_miejsce {
    public String numer;
    public String znizka = "Brak";

    public float zwroc_znizke(){
        switch (znizka){
            case"Student":
                return 20;
            case"Uczeń":
                return 20;
            case"Senior":
                return 50;
            case"Niepełnosprawny":
                return 45;
            case"Nauczyciel":
                return 25;
            case"Grupa min 10 osób":
                return 10;
            case"< 2 lata":
                return 95;
            case"< 14 lat":
                return 25;
            default:
                return 0;
        }

    }
}
