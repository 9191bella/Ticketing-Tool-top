# Verwaltungsklassen im Ticketing Tool

**Grundlagen der objektorientierten Programmierung — Phase 2, Aufgabe 2**
Prof. Dr.-Ing. Gert Faustmann

> Vorgabe aus dem Arbeitsblatt: *„Erstellen Sie für jede Fachklasse eine
> Verwaltungsklasse, die intern eine Collection (z. B. ArrayList) von
> Fachobjekten verwaltet."* Jede Verwaltungsklasse soll **Anlegen**, **Löschen**,
> **Suchen** (u. a. Volltext) und **sortierte Ausgabe** nach mehreren Kriterien
> ermöglichen.

---

## Überblick: eine Verwaltungsklasse pro Fachklasse

| Fachklasse | Verwaltungsklasse | Interne Collection |
|---|---|---|
| `Agent`    | `AgentList`    | `ArrayList<Agent>` |
| `Customer` | `CustomerList` | `ArrayList<Customer>` |
| `Ticket`   | `TicketList`   | `ArrayList<Ticket>` |
| `Category` | `CategoryList` | `ArrayList<Category>` |

`Comment` erhält **keine** eigene Verwaltungsklasse: Ein Kommentar ist fest an
genau ein `Ticket` gebunden und wird über die `ArrayList<Comment>` des Tickets
verwaltet (Komposition statt eigener Liste, siehe Frage 2 unten).

Alle vier Klassen folgen demselben Aufbau:
1. eine private `ArrayList` der jeweiligen Fachobjekte,
2. `addX` / `removeX` zum Anlegen und Löschen,
3. Suchmethoden (`findById`, Volltextsuche, fachliche Suchen),
4. `printSortedByX`-Methoden zur sortierten Ausgabe nach mehreren Kriterien.

---

## 1. `AgentList` — Verwaltung der Agenten

Verwaltet alle Support-Mitarbeiter.

| Methode | Aufgabe |
|---|---|
| `addAgent(Agent)` | Agenten hinzufügen |
| `removeAgent(Agent)` | Agenten entfernen |
| `findById(int)` | einen Agenten über die eindeutige ID finden (oder `null`) |
| `findByName(String)` | Volltextsuche über den Namen (Teilstring, ohne Groß-/Kleinschreibung) |
| `findByCategory(Category)` | alle Agenten einer Kategorie |
| `findByLevel(int)` | alle Agenten eines Support-Levels (First/Second Level) |
| `printSortedByName()` | sortierte Ausgabe alphabetisch nach Name |
| `printSortedByLevel()` | sortierte Ausgabe nach Support-Level |

## 2. `CustomerList` — Verwaltung der Kunden

Verwaltet alle Kunden.

| Methode | Aufgabe |
|---|---|
| `addCustomer(Customer)` | Kunden hinzufügen |
| `removeCustomer(Customer)` | Kunden entfernen |
| `findById(int)` | einen Kunden über die ID finden (oder `null`) |
| `findByName(String)` | Volltextsuche über den Namen |
| `findByCategory(Category)` | alle Kunden einer Kategorie (z. B. VIP, Regular) |
| `printSortedByName()` | sortierte Ausgabe alphabetisch nach Name |
| `printSortedById()` | sortierte Ausgabe nach ID |

## 3. `TicketList` — Verwaltung der Tickets

Verwaltet alle Support-Fälle.

| Methode | Aufgabe |
|---|---|
| `addTicket(Ticket)` | Ticket hinzufügen |
| `removeTicket(Ticket)` | Ticket entfernen |
| `findById(int)` | ein Ticket über die ID finden (oder `null`) |
| `findByTitle(String)` | Volltextsuche über den Titel |
| `findByCategory(Category)` | alle Tickets einer Kategorie |
| `findByStatus(Status)` | alle Tickets mit einem Status (OPEN, IN_PROGRESS …) |
| `printSortedByTitle()` | sortierte Ausgabe alphabetisch nach Titel |
| `printSortedByDueDate()` | sortierte Ausgabe nach Fälligkeitsdatum (Tickets ohne Datum ans Ende) |

## 4. `CategoryList` — Verwaltung der Kategorien

Verwaltet alle Kategorien (für Tickets, Kunden und Agenten).

| Methode | Aufgabe |
|---|---|
| `addCategory(Category)` | Kategorie hinzufügen |
| `removeCategory(Category)` | Kategorie entfernen |
| `findById(int)` | eine Kategorie über die ID finden (oder `null`) |
| `findByName(String)` | Volltextsuche über den Namen |
| `printSortedByName()` | sortierte Ausgabe alphabetisch nach Name |
| `printSortedById()` | sortierte Ausgabe nach ID |

## Hinweis: keine `CommentList`

Kommentare werden **nicht** über eine eigene Verwaltungsklasse geführt. Jedes
`Ticket` besitzt bereits eine `ArrayList<Comment>` und verwaltet seine Kommentare
selbst (`addComment`, `getComments`). Ein Kommentar existiert nie ohne sein
Ticket, daher wäre eine globale `CommentList` überflüssig (siehe Frage 2).

---

## Offene Fragen an den Professor: Zusammenfassen von Fachklassen

Das Arbeitsblatt verlangt „für **jede** Fachklasse eine Verwaltungsklasse".
In einigen Fällen wäre aber ein **Zusammenfassen** zweier Fachklassen in einer
gemeinsamen Verwaltungsklasse denkbar. Wir möchten klären, ob das gewünscht ist.

### Frage 1: `Agent` und `Customer` in einer gemeinsamen `UserList`?

`Agent` und `Customer` erben beide von der Basisklasse `User`. Man könnte sie
daher in **einer** gemeinsamen Verwaltungsklasse `UserList` (mit einer
`ArrayList<User>`) zusammenfassen, statt zwei getrennte Listen zu pflegen.

- **Vorteil:** Methoden wie `findById` und `findByName` sind für beide Typen
  identisch — kein doppelter Code.
- **Nachteil:** Typspezifische Suchen (z. B. `findByLevel` nur für Agenten)
  würden Typprüfungen (`instanceof`) und Casts erfordern.

> **Frage:** Sollen `Agent` und `Customer` über ihre gemeinsame Basisklasse `User`
> in einer `UserList` zusammengefasst werden, oder bevorzugen Sie strikt zwei
> getrennte Listen (`AgentList`, `CustomerList`)?

### Frage 2: Braucht `Comment` eine eigene `CommentList`?

Ein `Comment` ist immer fest an genau **ein** `Ticket` gebunden und existiert
nie ohne Ticket (das Ticket besitzt bereits eine `ArrayList<Comment>`). Wir
verwalten die Kommentare deshalb ausschließlich im Ticket und verzichten auf
eine eigene globale `CommentList` (Komposition statt eigener Liste).

> **Frage:** Ist dieses Vorgehen in Ordnung, oder sollen wir – strikt nach
> Arbeitsblatt – dennoch eine eigene Verwaltungsklasse für `Comment` anlegen?

### Frage 3: Übergeordnete Bündelung der Listen?

Aktuell existieren die vier Listen einzeln. Zusätzlich gibt es noch die ältere
Klasse `TicketAdministration`, die Tickets, Kategorien, Agenten und Kunden
gleichzeitig verwaltet — dadurch werden manche Objekte doppelt gehalten.

> **Frage:** Sollen wir die vier Verwaltungsklassen über eine übergeordnete
> Fassade (z. B. `TicketSystem`) als einen gemeinsamen Einstiegspunkt bündeln und
> `TicketAdministration` entsprechend ablösen?
