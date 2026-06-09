/* Diese Enum repräsentiert den Status eines Tickets im Ticketing Tool. Mögliche Werte sind OPEN, IN_PROGRESS, WAITING_FOR_FEEDBACK und CLOSED. Der Status eines Tickets kann sich im Laufe des Bearbeitungsprozesses ändern, z.B. von OPEN zu IN_PROGRESS, wenn ein Agent das Ticket bearbeitet, oder von WAITING_FOR_FEEDBACK zu CLOSED, wenn der Kunde Feedback gegeben hat und das Problem gelöst wurde. 
*/

public enum Status {
    OPEN,
    IN_PROGRESS,
    WAITING_FOR_FEEDBACK,
    CLOSED
}

//nach Feddback automatisch auf IN_PROGESS setzen
