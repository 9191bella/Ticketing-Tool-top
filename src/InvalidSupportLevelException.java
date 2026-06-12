/* Wird geworfen, wenn einem Agenten ein Support-Level zugewiesen wird, das
   im Ticketing-Tool nicht definiert ist. Aktuell sind ausschliesslich die
   Werte 1 (First-Level-Support) und 2 (Second-Level-Support) zulaessig
   (vgl. TODO.md: "First- und Second-Level-Support"). */
public class InvalidSupportLevelException extends TicketingException {

    private final int level;

    public InvalidSupportLevelException(int level){
        super("Ungueltiges Support-Level: " + level
                + " (erlaubt sind nur 1 = First-Level und 2 = Second-Level).");
        this.level = level;
    }

    public int getLevel(){
        return level;
    }
}
