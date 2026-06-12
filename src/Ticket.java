/*  
Diese Klasse repräsentiert ein Ticket im Ticketing Tool. Sie enthält Informationen über das Ticket, wie z.B. die ID, den Titel, die Beschreibung, die Kategorie, den Status, die Erstellungs- und Aktualisierungszeitpunkte, den Ersteller (Kunde) und den Bearbeiter (Agent). Außerdem enthält sie eine Liste von Kommentaren, die mit dem Ticket verbunden sind. Die Klasse bietet Methoden zum Hinzufügen von Kommentaren, Zuweisen von Agenten und Ändern des Status des Tickets.

Ausnahmebehandlung: Ein Fälligkeitsdatum (dueDate), das vor dem Erstellungsdatum
(createdAt) liegt, ist fachlich nicht sinnvoll ("ein Ticket kann nicht fälliger
sein, als es alt ist") und führt zu einer InvalidDateRangeException - sowohl im
Konstruktor als auch in setDueDate().
*/
import java.util.*;
public class Ticket {
    private int id;
    private String title;
    private String description;
    private Category category; 
    private Status status; 
    private Date createdAt; 
    private Date updatedAt; 
    private Date dueDate;
    private Customer createdBy; 
    private Agent resolvedBy;
    private ArrayList<Comment> comments;

    public Ticket(int id, String title, String description, Category category, Status status, Date createdAt, Date updatedAt, Date dueDate, Customer createdBy, Agent resolvedBy) throws InvalidDateRangeException {
        this.id = id;
        this.title = title; 
        this.description = description;
        this.category = category;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy; 
        this.resolvedBy = resolvedBy;
        this.comments = new ArrayList<>();
        setDueDate(dueDate); // führt die Plausibilitätsprüfung zentral durch
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void assignAgent(Agent agent){
        resolvedBy = agent;
        status = Status.IN_PROGRESS;
        updatedAt = new Date();
    }

    public int getID(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public Category getCategory(){
        return category;
    }

    public void setCategory(Category newCategory){
        category = newCategory;
    }

    public Status getStatus(){
        return status;
    }

    public void setStatus(Status newStatus){
        status = newStatus;
    }

    public Date getCreatedAt(){
        return createdAt;
    }

    public Date getUpdatedAt(){
        return updatedAt;
    }

    public void setUpdatedAt(Date newUpdatedAt){
        updatedAt = newUpdatedAt;
    }

    public Customer getCreatedBy(){
        return createdBy;
    }

    public Agent getResolvedBy(){
        return resolvedBy;
    }

    public void setResolvedBy(Agent newResolvedBy){
        resolvedBy = newResolvedBy;
    }

    public ArrayList<Comment> getComments(){
        return comments;
    }

    public Date getDueDate(){
        return dueDate;
    }

    // Setzt das Fälligkeitsdatum. Ein null-Wert ("kein Fälligkeitsdatum") ist erlaubt.
    // Liegt das angegebene Datum jedoch vor dem Erstellungsdatum, ist das fachlich
    // ein Fehler und es wird eine InvalidDateRangeException geworfen.
    public void setDueDate(Date newDueDate) throws InvalidDateRangeException {
        if(newDueDate != null && createdAt != null && newDueDate.before(createdAt)){
            throw new InvalidDateRangeException(createdAt, newDueDate, "Faelligkeitsdatum von Ticket " + id);
        }
        dueDate = newDueDate;
    }

    public String toString(){
        return "Ticket ID: " + id + ", Title: " + title + ", Status: " + status + ", Created At: " + createdAt + ", Updated At: " + updatedAt + ", Due Date: " + dueDate + ", Created By: " + createdBy.getName() + ", Resolved By: " + (resolvedBy != null ? resolvedBy.getName() : "Unassigned");
    }

}
