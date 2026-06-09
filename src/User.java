/* Diese Klasse repräsentiert einen Benutzer des Ticketing Tools */
public class User {
    int id;
    String name;
    String email;

    public User (int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
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

    public String getEmail(){
        return email;
    }

    public void setEmail(String newEmail){
        email = newEmail;
    }

    public String toString(){
        return "User: " + name + " (" + email + ")";
    }
}
// Priorisierung der Wichtigkeit des Users hinzufügen! x
// Kein reines Datenbank Projekt ->Vermeiden drei schichten system Java Objekte die interargieren.Es soll nicht immer nur in die Datenbank geschrieben werden
// System zeigt anhand von Methoden Fälligkeiten etc an.
// Lesbarkeit, Kommentare mit Beschreibung, Tets, Persistenz , Datenspeicherung -> Serialisierung aus dateien Objekte erzeugen 
// Kommentare wer sagt was, wann, und von wem. Kommentare sind Objekte in Listen(Chat) 
// Klassendiagramm erstellen 
// getter und setter Methoden prüfen (nur relevante gebraucht)
// Arbeiten mit den Tickets, Analyse -> Dashboard bspw Kategorie 
