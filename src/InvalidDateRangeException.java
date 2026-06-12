/* Wird geworfen, wenn ein Start-Datum zeitlich NACH einem End-Datum liegt,
   obwohl das fachlich nicht erlaubt ist. Beispiele im Ticketing-Tool:
   - Faelligkeitsdatum (dueDate) eines Tickets liegt vor dem Erstellungsdatum
   - Dashboard-Filter "showTicketsByDateRange": Startdatum liegt nach Endedatum

   Das Feld "context" beschreibt, in welcher Situation der Fehler aufgetreten
   ist (z. B. "Faelligkeitsdatum" oder "Dashboard-Zeitraumfilter"), damit die
   Fehlermeldung fuer den Benutzer aussagekraeftig ist. */
public class InvalidDateRangeException extends TicketingException {

    private final Date start;
    private final Date end;

    public InvalidDateRangeException(Date start, Date end, String context){
        super("Ungueltiger Zeitraum (" + context + "): Startdatum " + start
                + " liegt nach dem Endedatum " + end + ".");
        this.start = start;
        this.end = end;
    }

    public Date getStart(){
        return start;
    }

    public Date getEnd(){
        return end;
    }
}
