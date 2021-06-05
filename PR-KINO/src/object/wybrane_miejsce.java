package object;

public class wybrane_miejsce {
    public String numer;
    public String znizka = null;

    public float zwroc_znizke(){
        switch (znizka){
            case"Student":
                return 20;
            case"Uczeń":
                return 20;
            case"Senior":
                return 20;
            case"Niepełnosprawny":
                return 30;
            case"Nauczyciel":
                return 15;
            case"Grupa min 10 osób":
                return 10;
            case"< 2 lata":
                return 60;
            case"< 14 lat":
                return 10;
            default:
                return 0;
        }

    }
}
