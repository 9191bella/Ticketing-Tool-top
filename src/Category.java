/* Diese Klasse repräsentiert eine Kategorie von Tickets im Ticketing Tool. Sie enthält Informationen über die ID, den Namen und die Beschreibung der Kategorie sowie eine Liste von Agenten, die dieser Kategorie zugeordnet sind. Die Klasse bietet Methoden zum Abrufen und Ändern der Informationen der Kategorie.
*/
import java.util.*;
public class Category {
    int id;
    String name;
    String description;
    List<Agent> agents;

    public Category (int id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
        agents = new ArrayList<>();
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String newDescription){
        description = newDescription;
    }

    public String toString(){
        return "Kategorie: " + name + " - " + description;
    }
}
