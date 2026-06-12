/* Diese Klasse repräsentiert einen Agenten im Ticketing Tool. Sie erbt von der User-Klasse und enthält zusätzliche Informationen über die Abteilung, die Rolle und die Kategorie, der der Agent zugeordnet ist. Die Klasse bietet Methoden zum Abrufen und Ändern dieser Informationen.

Ausnahmebehandlung: Das Support-Level darf nur 1 (First-Level) oder 2 (Second-Level)
sein. Konstruktor und setLevel() prüfen das und werfen sonst eine
InvalidSupportLevelException.
*/
public class Agent extends User {
    String department;
    String role;
    Category category;
    int level; // 1 für First-Level-Support, 2 für Second-Level-Support

    public Agent (int id, String name, String email, String department, String role, Category category, int level) throws InvalidSupportLevelException {
        super(id, name, email);
        this.department = department;
        this.role = role;
        this.category = category;
        setLevel(level);
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String newDepartment){
        department = newDepartment;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String newRole){
        role = newRole;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category newCategory){
        category = newCategory;
    }

    public int getLevel(){
        return level;
    }

    // Prüft das Support-Level auf Gültigkeit (1 oder 2), bevor es übernommen wird.
    public void setLevel(int newLevel) throws InvalidSupportLevelException {
        if(newLevel != 1 && newLevel != 2){
            throw new InvalidSupportLevelException(newLevel);
        }
        level = newLevel;
    }

    public String toString(){
        return "Agent: " + getName() + " (" + getEmail() + ") - Abteilung: " + department + ", Rolle: " + role + ", Kategorie: " + category.getName() + ", Level: " + level;
    }
}
