/* Verwaltungsklasse für Kategorien (vgl. Übungsblatt Phase 2, Aufgabe 2:
   "Erstellen Sie für jede Fachklasse eine Verwaltungsklasse").
   Verwaltet intern eine ArrayList von Category-Objekten und bietet Methoden
   zum Anlegen, Löschen, Suchen und zur sortierten Ausgabe. */
import java.util.ArrayList;
import java.util.Comparator;

public class CategoryList {
    private ArrayList<Category> categories;

    public CategoryList(){
        categories = new ArrayList<>();
    }

    // Legt eine Kategorie an und fügt sie der Verwaltung hinzu.
    public void addCategory(Category category){
        categories.add(category);
    }

    // Entfernt eine Kategorie aus der Verwaltung.
    public void removeCategory(Category category){
        categories.remove(category);
    }

    // Suche nach einer Kategorie anhand der eindeutigen ID.
    // Gibt die Kategorie zurück oder null, falls keine gefunden wurde.
    public Category findById(int id){
        for(Category category : categories){
            if(category.getId() == id){
                return category;
            }
        }
        return null;
    }

    // Volltextsuche über den Namen (Teilstring, ohne Groß-/Kleinschreibung).
    public ArrayList<Category> findByName(String name){
        ArrayList<Category> result = new ArrayList<>();
        for(Category category : categories){
            if(category.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(category);
            }
        }
        return result;
    }

    // Sortierte Ausgabe nach Name (alphabetisch).
    public void printSortedByName(){
        categories.sort(Comparator.comparing(Category::getName));
        for(Category category : categories){
            System.out.println(category.toString());
        }
    }

    // Sortierte Ausgabe nach ID (aufsteigend).
    public void printSortedById(){
        categories.sort(Comparator.comparingInt(Category::getId));
        for(Category category : categories){
            System.out.println(category.toString());
        }
    }

    public ArrayList<Category> getCategories(){
        return categories;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Kategorien:\n");
        for(Category category : categories){
            sb.append(category.toString()).append("\n");
        }
        return sb.toString();
    }
}
