/* Verwaltungsklasse für Tickets (vgl. Übungsblatt Phase 2, Aufgabe 2:
   "Erstellen Sie für jede Fachklasse eine Verwaltungsklasse").
   Verwaltet intern eine ArrayList von Ticket-Objekten und bietet Methoden
   zum Anlegen, Löschen, Suchen und zur sortierten Ausgabe. */
import java.util.ArrayList;
import java.util.Comparator;

public class TicketList {
    private ArrayList<Ticket> tickets;

    public TicketList(){
        tickets = new ArrayList<>();
    }

    // Legt ein Ticket an und fügt es der Verwaltung hinzu.
    public void addTicket(Ticket ticket){
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
