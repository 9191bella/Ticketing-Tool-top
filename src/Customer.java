/* Diese Klasse repräsentiert einen Kunden. Sie erweitert die User-Klasse um spezifische Eigenschaften für Kunden. */
public class Customer extends User {
    Category category;
    public Customer (int id, String name, String email, Category category){
        super(id, name, email);
        this.category = category;   
    }

    public Category getCategory(){
        return category;
    }   

    public void setCategory(Category newCategory){
        category = newCategory;
    }

    public String toString(){
        return "Customer: " + getName() + " (" + getEmail() + ")" + " - Category: " + category.getName();
    }
}
