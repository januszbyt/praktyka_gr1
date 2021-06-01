package object;

public class wybrane_miejsce {
    public String numer;
    public String znika;

    public int zwroc_znizke(){
        switch (znika){
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
                System.out.println(30);
                return 60;
            case"< 14 lat":
                System.out.println(15);
                return 10;
            default:
                return 0;
        }

    }
}
