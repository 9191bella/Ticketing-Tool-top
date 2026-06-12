/* Verwaltungsklasse für Agenten (vgl. Übungsblatt Phase 2, Aufgabe 2:
   "Erstellen Sie für jede Fachklasse eine Verwaltungsklasse").
   Verwaltet intern eine ArrayList von Agent-Objekten und bietet Methoden
   zum Anlegen, Löschen, Suchen und zur sortierten Ausgabe.

   Ausnahmebehandlung: addAgent() wirft DuplicateIdException, falls bereits
   ein Agent mit derselben ID existiert; findByIdOrThrow() wirft
   ReferenceNotFoundException statt null zurückzugeben. */
import java.util.ArrayList;
import java.util.Comparator;

public class AgentList {
    private ArrayList<Agent> agents;

    public AgentList(){
        agents = new ArrayList<>();
    }

    // Legt einen Agenten an und fügt ihn der Verwaltung hinzu.
    // Wirft DuplicateIdException, wenn die ID bereits vergeben ist.
    public void addAgent(Agent agent) throws DuplicateIdException {
        if(findById(agent.getId()) != null){
            throw new DuplicateIdException("Agent", agent.getId());
        }
        agents.add(agent);
    }

    // Entfernt einen Agenten aus der Verwaltung.
    public void removeAgent(Agent agent){
        agents.remove(agent);
    }

    // Suche nach einem Agenten anhand der eindeutigen ID.
    // Gibt den Agenten zurück oder null, falls keiner gefunden wurde.
    public Agent findById(int id){
        for(Agent agent : agents){
            if(agent.getId() == id){
                return agent;
            }
        }
        return null;
    }

    // Wie findById(), wirft aber eine ReferenceNotFoundException statt null
    // zurückzugeben, falls kein Agent mit dieser ID existiert.
    public Agent findByIdOrThrow(int id) throws ReferenceNotFoundException {
        Agent agent = findById(id);
        if(agent == null){
            throw new ReferenceNotFoundException("Agent", id);
        }
        return agent;
    }

    // Volltextsuche über den Namen (Teilstring, ohne Groß-/Kleinschreibung).
    public ArrayList<Agent> findByName(String name){
        ArrayList<Agent> result = new ArrayList<>();
        for(Agent agent : agents){
            if(agent.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(agent);
            }
        }
        return result;
    }

    // Liefert alle Agenten einer bestimmten Kategorie.
    public ArrayList<Agent> findByCategory(Category category){
        ArrayList<Agent> result = new ArrayList<>();
        for(Agent agent : agents){
            if(agent.getCategory() != null && agent.getCategory().getId() == category.getId()){
                result.add(agent);
            }
        }
        return result;
    }

    // Liefert alle Agenten eines bestimmten Support-Levels (z. B. First/Second Level).
    public ArrayList<Agent> findByLevel(int level){
        ArrayList<Agent> result = new ArrayList<>();
        for(Agent agent : agents){
            if(agent.getLevel() == level){
                result.add(agent);
            }
        }
        return result;
    }

    // Sortierte Ausgabe nach Name (alphabetisch).
    public void printSortedByName(){
        agents.sort(Comparator.comparing(Agent::getName));
        for(Agent agent : agents){
            System.out.println(agent.toString());
        }
    }

    // Sortierte Ausgabe nach Support-Level (aufsteigend).
    public void printSortedByLevel(){
        agents.sort(Comparator.comparingInt(Agent::getLevel));
        for(Agent agent : agents){
            System.out.println(agent.toString());
        }
    }

    public ArrayList<Agent> getAgents(){
        return agents;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Agenten:\n");
        for(Agent agent : agents){
            sb.append(agent.toString()).append("\n");
        }
        return sb.toString();
    }
}
