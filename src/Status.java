/* Diese Enum repräsentiert den Status eines Tickets im Ticketing Tool. Mögliche Werte sind OPEN, IN_PROGRESS, WAITING_FOR_FEEDBACK und CLOSED. Der Status eines Tickets kann sich im Laufe des Bearbeitungsprozesses ändern, z.B. von OPEN zu IN_PROGRESS, wenn ein Agent das Ticket bearbeitet, oder von WAITING_FOR_FEEDBACK zu CLOSED, wenn der Kunde Feedback gegeben hat und das Problem gelöst wurde. 
*/

public enum Status {
    OPEN,                  // Ticket ist neu und noch nicht in Bearbeitung
    IN_PROGRESS,           // Ein Agent bearbeitet das Ticket
    WAITING_FOR_FEEDBACK,  // Warten auf Rückmeldung des Kunden
    CLOSED                 // Ticket ist abgeschlossen
}

//nach Feedback automatisch auf IN_PROGRESS setzen
