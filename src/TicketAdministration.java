import java.util.Comparator;
import java.util.ArrayList;

public class TicketAdministration {
    private ArrayList<Ticket> tickets;
    private ArrayList<Category> categories;
    private ArrayList<Agent> agents;
    private ArrayList<Customer> customers;

    public TicketAdministration(){
        tickets = new ArrayList<>();
        categories = new ArrayList<>();
        agents = new ArrayList<>();
        customers = new ArrayList<>();
    }

    public void addTicket(Ticket ticket){
        tickets.add(ticket);
    }

    public void addCategory(Category category){
        categories.add(category);
    }

    public void addAgent(Agent agent){
        agents.add(agent);
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public  void removeTicket(Ticket ticket){
        tickets.remove(ticket);
    }
    
    public void findTicketByID(int id){
        for(Ticket ticket : tickets){
            if(ticket.getID() == id){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
                return;
            }
        }
        System.out.println("Ticket with ID " + id + " not found.");
    }

    public void findTicketsByCategory(Category category){
        for(Ticket ticket : tickets){
            if(ticket.getCategory().getId() == category.getId()){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }

    public void findTicketsByAgent(Agent agent){
        for(Ticket ticket : tickets){
            if(ticket.getResolvedBy() != null && ticket.getResolvedBy().getId() == agent.getId()){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }

    public void findTicketsByCustomer(Customer customer){
        for(Ticket ticket : tickets){
            if(ticket.getCreatedBy().getId() == customer.getId()){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }

    public void findTicketsByStatus(Status status){
        for(Ticket ticket : tickets){
            if(ticket.getStatus() == status){
                System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle());
            }
        }
    }   

    public void getAllTicketsSortedByAgent(){
        tickets.sort(Comparator.comparing(ticket -> ticket.getResolvedBy() != null ? ticket.getResolvedBy().getName() : ""));
        for(Ticket ticket : tickets){
            System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle() + ", Resolved By: " + (ticket.getResolvedBy() != null ? ticket.getResolvedBy().getName() : "Unassigned"));
        }
    }

    public void getAllTicketsSortedByDueDate(){
        tickets.sort(Comparator.comparing(Ticket::getDueDate, Comparator.nullsLast(Comparator.naturalOrder())));
        for(Ticket ticket : tickets){
            System.out.println("Ticket ID: " + ticket.getID() + ", Title: " + ticket.getTitle() + ", Due Date: " + (ticket.getDueDate() != null ? ticket.getDueDate() : "No Due Date"));    
        }  
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tickets:\n");
        for(Ticket ticket : tickets){
            sb.append(ticket.toString()).append("\n");
        }
        sb.append("Categories:\n");
        for(Category category : categories){
            sb.append(category.toString()).append("\n");
        }
        sb.append("Agents:\n");
        for(Agent agent : agents){
            sb.append(agent.toString()).append("\n");
        }
        sb.append("Customers:\n");
        for(Customer customer : customers){
            sb.append(customer.toString()).append("\n");
        }
        return sb.toString();
    }

}

