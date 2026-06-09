/* Diese Klasse repräsentiert einen Kommentar. Sie enthält Informationen über den Inhalt des Kommentars, das zugehörige Ticket, den Autor (Kunde) und das Erstellungsdatum. Kommentare sind mit einem Ticket verbunden und können von Kunden oder Agenten erstellt werden, um zusätzliche Informationen oder Updates zum Ticket bereitzustellen. Die Klasse bietet Methoden zum Abrufen und Ändern des Kommentarinhalts sowie zum Abrufen der zugehörigen Informationen wie Ticket, Autor und Erstellungsdatum.
*/
public class Comment {
    int id;
    String content;
    Ticket ticket;
    User author;
    Date createdOn;

    public Comment (int id, String content, Ticket ticket, User author, Date createdOn){
        this.id = id;
        this.content = content;
        this.ticket = ticket;
        this.author = author;
        this.createdOn = createdOn;
    }

    public int getId(){
        return id;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String newContent){
        content = newContent;
    }

    public Ticket getTicket(){
        return ticket;
    }

    public User getAuthor(){
        return author;
    }

    public Date getCreatedOn(){
        return createdOn;
    }

    public String toString(){
        return "Kommentar von " + author.getName() + " am " + createdOn.toString() + ": " + content;
    }
}
