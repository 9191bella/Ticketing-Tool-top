/* Diese Klasse repräsentiert einen Agenten im Ticketing Tool. Sie erbt von der User-Klasse und enthält zusätzliche Informationen über die Abteilung, die Rolle und die Kategorie, der der Agent zugeordnet ist. Die Klasse bietet Methoden zum Abrufen und Ändern dieser Informationen.
*/
public class Agent extends User {
    String department;
    String role;
    Category category;
    int level; // 1 für First-Level-Support, 2 für Second-Level-Support usw.

    public Agent (int id, String name, String email, String department, String role, Category category, int level){
        super(id, name, email);
        this.department = department;
        this.role = role;
        this.category = category;
        this.level = level;
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

    public void setLevel(int newLevel){
        level = newLevel;
    }

    public String toString(){
        return "Agent: " + getName() + " (" + getEmail() + ") - Abteilung: " + department + ", Rolle: " + role + ", Kategorie: " + category.getName() + ", Level: " + level;
    }
}
//First und Second level support, Kategorie hinzufügen 
