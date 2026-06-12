/* Wird geworfen, wenn auf ein Fachobjekt (Ticket, Kategorie, Agent, Kunde, ...)
   ueber eine ID verwiesen wird, die in der jeweiligen Verwaltungsklasse
   (TicketList, CategoryList, AgentList, CustomerList) nicht existiert.

   Beispiel: Beim Anlegen eines Tickets wird eine Kategorie-ID angegeben,
   zu der keine Kategorie in der CategoryList existiert. Statt mit "null"
   weiterzuarbeiten (und z. B. spaeter eine NullPointerException zu riskieren),
   wird hier eine fachliche Ausnahme geworfen. */
public class ReferenceNotFoundException extends TicketingException {

    private final String type;
    private final int id;

    public ReferenceNotFoundException(String type, int id){
        super(type + " mit ID " + id + " wurde nicht gefunden.");
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
