/* Gemeinsame Basisklasse für alle fachlichen (checked) Ausnahmen des
   Ticketing-Tools. Dadurch lassen sich alle projektspezifischen Fehler
   in einem catch-Block gemeinsam abfangen ("catch (TicketingException e)"),
   ohne dass man jede einzelne Unterklasse einzeln aufzählen muss.

   Abgeleitet von "Exception" (also eine "checked exception"), weil es sich
   um Situationen handelt, von denen sich der aufrufende Code in der Regel
   erholen kann/soll (z. B. erneute Eingabe anfordern, Vorgang abbrechen) –
   im Gegensatz zu Programmierfehlern, für die RuntimeExceptions besser
   geeignet wären. */
public abstract class TicketingException extends Exception {

    public TicketingException(String message){
        super(message);
    }

    public TicketingException(String message, Throwable cause){
        super(message, cause);
    }
}
