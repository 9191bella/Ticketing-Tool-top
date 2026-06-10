/* Verwaltungsklasse für Kunden (vgl. Übungsblatt Phase 2, Aufgabe 2:
   "Erstellen Sie für jede Fachklasse eine Verwaltungsklasse").
   Verwaltet intern eine ArrayList von Customer-Objekten und bietet Methoden
   zum Anlegen, Löschen, Suchen und zur sortierten Ausgabe. */
import java.util.ArrayList;
import java.util.Comparator;

public class CustomerList {
    private ArrayList<Customer> customers;

    public CustomerList(){
        customers = new ArrayList<>();
    }

    // Legt einen Kunden an und fügt ihn der Verwaltung hinzu.
    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    // Entfernt einen Kunden aus der Verwaltung.
    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }

    // Suche nach einem Kunden anhand der eindeutigen ID.
    // Gibt den Kunden zurück oder null, falls keiner gefunden wurde.
    public Customer findById(int id){
        for(Customer customer : customers){
            if(customer.getId() == id){
                return customer;
            }
        }
        return null;
    }

    // Volltextsuche über den Namen (Teilstring, ohne Groß-/Kleinschreibung).
    public ArrayList<Customer> findByName(String name){
        ArrayList<Customer> result = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getName().toLowerCase().contains(name.toLowerCase())){
                result.add(customer);
            }
        }
        return result;
    }

    // Liefert alle Kunden einer bestimmten Kategorie.
    public ArrayList<Customer> findByCategory(Category category){
        ArrayList<Customer> result = new ArrayList<>();
        for(Customer customer : customers){
            if(customer.getCategory() != null && customer.getCategory().getId() == category.getId()){
                result.add(customer);
            }
        }
        return result;
    }

    // Sortierte Ausgabe nach Name (alphabetisch).
    public void printSortedByName(){
        customers.sort(Comparator.comparing(Customer::getName));
        for(Customer customer : customers){
            System.out.println(customer.toString());
        }
    }

    // Sortierte Ausgabe nach ID (aufsteigend).
    public void printSortedById(){
        customers.sort(Comparator.comparingInt(Customer::getId));
        for(Customer customer : customers){
            System.out.println(customer.toString());
        }
    }

    public ArrayList<Customer> getCustomers(){
        return customers;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Kunden:\n");
        for(Customer customer : customers){
            sb.append(customer.toString()).append("\n");
        }
        return sb.toString();
    }
}
