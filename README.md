# Ticketing-Tool

Ein objektorientiertes Ticketing-System, entwickelt im Rahmen des Moduls
**Objektorientierte Programmierung (Semester 2)**. Das Programm verwaltet Support-Tickets,
ordnet sie Kategorien, Kunden und Agenten zu und bietet Auswertungen über ein Dashboard.

## Funktionen

- **Tickets** anlegen, mit Status, Kategorie, Fälligkeitsdatum und Kommentaren verwalten
- **Benutzer**: Unterscheidung zwischen Kunden (`Customer`) und Agenten (`Agent`) per Vererbung
- **Kommentare** an Tickets (Autor und Datum werden festgehalten)
- **Verwaltung** (`TicketAdministration`): Tickets suchen nach ID, Kategorie, Agent, Kunde oder Status; sortieren nach Agent oder Fälligkeitsdatum
- **Dashboard**: offene Tickets, Filter nach Kategorie/Agent/Kunde/Status/Zeitraum, Zählung pro Kategorie

## Projektstruktur

- `src` – Quelldateien (Java)
- `lib` – Abhängigkeiten (aktuell keine externen Libraries)
- `bin` – kompilierte `.class`-Dateien (wird generiert, nicht eingecheckt)

## Klassenübersicht

| Klasse | Beschreibung |
|---|---|
| `User` | Basisklasse für Benutzer (ID, Name, E-Mail) |
| `Agent` | Support-Mitarbeiter (Abteilung, Rolle, Kategorie, Support-Level) – erbt von `User` |
| `Customer` | Kunde mit zugeordneter Kategorie – erbt von `User` |
| `Ticket` | Kernobjekt mit Titel, Beschreibung, Status, Datumsangaben, Ersteller, Bearbeiter und Kommentaren |
| `Comment` | Kommentar zu einem Ticket (Inhalt, Autor, Datum) |
| `Category` | Kategorie für Tickets, Kunden und Agenten |
| `Status` | Enum: `OPEN`, `IN_PROGRESS`, `WAITING_FOR_FEEDBACK`, `CLOSED` |
| `Date` | Eigene Datumsklasse (Tag/Monat/Jahr) mit Vergleichsoperationen |
| `TicketAdministration` | Verwaltung und Suche über alle Tickets, Kategorien, Agenten und Kunden |
| `Dashboard` | Auswertungen und Filteransichten |
| `Testklasse` | Manueller Smoke-Test, der die Klassen beispielhaft verwendet |
| `App` | Einstiegspunkt |

## Kompilieren und Ausführen

Im Ordner `TicketingTool`:

```sh
# Kompilieren
javac -d bin src/*.java

# Beispielablauf ausführen (manueller Test)
java -cp bin Testklasse
```

## Entwicklung

Das Projekt ist für die Entwicklung in **Visual Studio Code** mit der Java-Erweiterung eingerichtet.
Die Ordnerstruktur kann in `.vscode/settings.json` angepasst werden.
