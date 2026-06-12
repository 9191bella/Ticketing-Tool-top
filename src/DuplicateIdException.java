/* Wird geworfen, wenn ein Fachobjekt (Ticket, Agent, Kunde, Kategorie) mit
   einer ID in eine Verwaltungsklasse (TicketList, AgentList, CustomerList,
   CategoryList) eingefuegt werden soll, die dort bereits vergeben ist.
   IDs sollen innerhalb einer Verwaltungsklasse eindeutig sein, da sie u. a.
   fuer findById() verwendet werden. */
public class DuplicateIdException extends TicketingException {

    private final String type;
    private final int id;

    public DuplicateIdException(String type, int id){
        super(type + " mit ID " + id + " existiert bereits und kann nicht erneut angelegt werden.");
        this.type = type;
        this.id = id;
    }

    public String getType(){
        return type;
    }

    public int getId(){
        return id;
    }
}
