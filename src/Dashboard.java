/*
Diese Klasse repräsentiert das Dashboard des Ticketing Tools, welches verschiedene Methoden zur Anzeige von Tickets basierend auf unterschiedlichen Kriterien enthält. Es ermöglicht die Anzeige von offenen Tickets, Tickets nach Kategorie, Agent, Kunde, Status und innerhalb eines bestimmten Datumsbereichs. Zusätzlich gibt es eine Methode zur Zählung der Tickets nach Kategorie. Die Ausgabe erfolgt in der Konsole.
*/
import java.util.*;
public class Dashboard {
    public void showOpenTickets(List<Ticket> tickets){
        for(Ticket ticket : tickets){
            if(ticket.getStatus() == Status.OPEN){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }

    public void showTicketsByCategory(List<Ticket> tickets, Category category){
        for(Ticket ticket : tickets){
            if(ticket.getCategory().getId() == category.getId()){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }   

    public void showTicketsByAgent(List<Ticket> tickets, Agent agent){
        for(Ticket ticket : tickets){
            if(ticket.getResolvedBy() != null && ticket.getResolvedBy().getId() == agent.getId()){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }   

    public void showTicketsByCustomer(List<Ticket> tickets, Customer customer){
        for(Ticket ticket : tickets){
            if(ticket.getCreatedBy().getId() == customer.getId()){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }

    public void showTicketsByStatus(List<Ticket> tickets, Status status){
        for(Ticket ticket : tickets){
            if(ticket.getStatus() == status){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }

    public void showTicketsByDateRange(List<Ticket> tickets, Date startDate, Date endDate){
        for(Ticket ticket : tickets){
            if(ticket.getCreatedAt().after(startDate) && ticket.getCreatedAt().before(endDate)){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }

    // Zählt, wie viele Tickets es pro Kategorie gibt, und gibt das Ergebnis aus.
    public void countTicketsByCategory(List<Ticket> tickets){
        Map<String, Integer> categoryCount = new HashMap<>();
        for(Ticket ticket : tickets){
            String categoryName = ticket.getCategory().getName();
            // Zähler für die Kategorie um 1 erhöhen (0 als Startwert, falls noch nicht vorhanden)
            categoryCount.put(categoryName, categoryCount.getOrDefault(categoryName, 0) + 1);
        }
        for(Map.Entry<String, Integer> entry : categoryCount.entrySet()){
            System.out.println("Category: " + entry.getKey() + ", Count: " + entry.getValue()); // hier könnte man auch eine grafische Darstellung hinzufügen, z.B. Balkendiagramm oder Kreisdiagramm
        }
    }

    //brauchen wir im Dashboard eine toString Methode?
}
