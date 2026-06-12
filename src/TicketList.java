/* Verwaltungsklasse für Tickets (vgl. Übungsblatt Phase 2, Aufgabe 2:
   "Erstellen Sie für jede Fachklasse eine Verwaltungsklasse").
   Verwaltet intern eine ArrayList von Ticket-Objekten und bietet Methoden
   zum Anlegen, Löschen, Suchen und zur sortierten Ausgabe.

   Ausnahmebehandlung:
   - addTicket() wirft DuplicateIdException, falls die Ticket-ID bereits vergeben ist.
   - findByIdOrThrow() wirft ReferenceNotFoundException statt null zurückzugeben.
   - assignAgent() prüft die Auslastung des Agenten und wirft bei Überschreitung
     eine CapacityExceededException (vgl. TODO.md: First-/Second-Level-Support,
     "Überschreitung von Kapazitäten"). */
import java.util.ArrayList;
import java.util.Comparator;

public class TicketList {
    private ArrayList<Ticket> tickets;

    // Maximale Anzahl gleichzeitig offener (nicht abgeschlossener) Tickets pro Agent.
    private static final int MAX_OPEN_TICKETS_PER_AGENT = 5;

    public TicketList(){
        tickets = new ArrayList<>();
    }

    // Legt ein Ticket an und fügt es der Verwaltung hinzu.
    // Wirft DuplicateIdException, wenn bereits ein Ticket mit derselben ID existiert.
    public void addTicket(Ticket ticket) throws DuplicateIdException {
        if(findById(ticket.getID()) != null){
            throw new DuplicateIdException("Ticket", ticket.getID());
        }
        tickets.add(ticket);
    }

    // Entfernt ein Ticket aus der Verwaltung.
    public void removeTicket(Ticket ticket){
        tickets.remove(ticket);
    }

    // Suche nach einem Ticket anhand der eindeutigen ID.
    // Gibt das Ticket zurück oder null, falls keines gefunden wurde.
    public Ticket findById(int id){
        for(Ticket ticket : tickets){
            if(ticket.getID() == id){
                return ticket;
            }
        }
        return null;
    }

    // Wie findById(), wirft aber eine ReferenceNotFoundException statt null
    // zurückzugeben, falls kein Ticket mit dieser ID existiert.
    public Ticket findByIdOrThrow(int id) throws ReferenceNotFoundException {
        Ticket ticket = findById(id);
        if(ticket == null){
            throw new ReferenceNotFoundException("Ticket", id);
        }
        return ticket;
    }

    // Volltextsuche über den Titel (Teilstring, ohne Groß-/Kleinschreibung).
    public ArrayList<Ticket> findByTitle(String title){
        ArrayList<Ticket> result = new ArrayList<>();
        for(Ticket ticket : tickets){
            if(ticket.getTitle().toLowerCase().contains(title.toLowerCase())){
                result.add(ticket);
            }
        }
        return result;
    }

    // Liefert alle Tickets einer bestimmten Kategorie.
    public ArrayList<Ticket> findByCategory(Category category){
        ArrayList<Ticket> result = new ArrayList<>();
        for(Ticket ticket : tickets){
            if(ticket.getCategory() != null && ticket.getCategory().getId() == category.getId()){
                result.add(ticket);
            }
        }
        return result;
    }

    // Liefert alle Tickets mit einem bestimmten Status.
    public ArrayList<Ticket> findByStatus(Status status){
        ArrayList<Ticket> result = new ArrayList<>();
        for(Ticket ticket : tickets){
            if(ticket.getStatus() == status){
                result.add(ticket);
            }
        }
        return result;
    }

    // Zählt, wie viele aktuell NICHT abgeschlossene Tickets einem Agenten zugewiesen sind.
    public int countOpenTickets(Agent agent){
        int count = 0;
        for(Ticket ticket : tickets){
            if(ticket.getResolvedBy() != null
                    && ticket.getResolvedBy().getId() == agent.getId()
                    && ticket.getStatus() != Status.CLOSED){
                count++;
            }
        }
        return count;
    }

    // Weist ein Ticket einem Agenten zu - aber nur, wenn dessen Kapazität
    // (maximale Anzahl offener Tickets) das zulässt. Andernfalls wird eine
    // CapacityExceededException geworfen und die Zuweisung NICHT durchgeführt.
    public void assignAgent(Ticket ticket, Agent agent) throws CapacityExceededException {
        int currentLoad = countOpenTickets(agent);
        if(currentLoad >= MAX_OPEN_TICKETS_PER_AGENT){
            throw new CapacityExceededException(agent, currentLoad, MAX_OPEN_TICKETS_PER_AGENT);
        }
        ticket.assignAgent(agent);
    }

    // Sortierte Ausgabe nach Titel (alphabetisch).
    public void printSortedByTitle(){
        tickets.sort(Comparator.comparing(Ticket::getTitle));
        for(Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }
    }

    // Sortierte Ausgabe nach Fälligkeitsdatum (frühestes zuerst).
    // Tickets ohne Fälligkeitsdatum (null) werden ans Ende sortiert (nullsLast).
    public void printSortedByDueDate(){
        tickets.sort(Comparator.comparing(Ticket::getDueDate, Comparator.nullsLast(Comparator.naturalOrder())));
        for(Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }
    }

    public ArrayList<Ticket> getTickets(){
        return tickets;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tickets:\n");
        for(Ticket ticket : tickets){
            sb.append(ticket.toString()).append("\n");
        }
        return sb.toString();
    }
}
