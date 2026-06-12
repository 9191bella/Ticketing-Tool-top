/* Wird geworfen, wenn ein Datum mit ungültigen Werten initialisiert werden soll,
   z. B. Monat 13, Tag 31 im Februar oder Tag 30 im Februar eines Schaltjahres.
   Speichert die fehlerhaften Eingabewerte zusätzlich, damit der Aufrufer z. B.
   eine konkrete Fehlermeldung mit den eingegebenen Werten anzeigen kann. */
public class InvalidDateException extends TicketingException {

    private final int day;
    private final int month;
    private final int year;

    public InvalidDateException(int day, int month, int year){
        super("Ungueltiges Datum: " + day + "." + month + "." + year);
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }
}
