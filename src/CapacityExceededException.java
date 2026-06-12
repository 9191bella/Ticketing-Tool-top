/* Wird geworfen, wenn einem Agenten ein weiteres Ticket zugewiesen werden soll,
   obwohl er bereits die maximale Anzahl offener (nicht abgeschlossener)
   Tickets bearbeitet. Entspricht der "Ueberschreitung von Kapazitaeten" aus
   der Aufgabenstellung (hier: Arbeits-/Ticketlast eines Agenten).

   Speichert den betroffenen Agenten sowie die aktuelle und maximale Auslastung,
   damit der Aufrufer z. B. einen anderen Agenten vorschlagen kann. */
public class CapacityExceededException extends TicketingException {

    private final Agent agent;
    private final int currentLoad;
    private final int maxLoad;

    public CapacityExceededException(Agent agent, int currentLoad, int maxLoad){
        super("Agent " + agent.getName() + " (ID " + agent.getId() + ") bearbeitet bereits "
                + currentLoad + " offene Ticket(s); Maximum ist " + maxLoad + ".");
        this.agent = agent;
        this.currentLoad = currentLoad;
        this.maxLoad = maxLoad;
    }

    public Agent getAgent(){
        return agent;
    }

    public int getCurrentLoad(){
        return currentLoad;
    }

    public int getMaxLoad(){
        return maxLoad;
    }
}
