# ToDo-Liste – Ticketing-Tool

Sammlung offener Aufgaben und Ideen. Diese Notizen lagen ursprünglich als Kommentare
verstreut im Quellcode und wurden hier zusammengeführt, um den Code übersichtlich zu halten.

## Fachliche Erweiterungen

- [ ] **Priorisierung der Wichtigkeit** eines Users / Tickets hinzufügen (z. B. Enum `Priority`).
- [ ] **First- und Second-Level-Support**: Kategorie-Zuordnung beim Agenten ausbauen
      (Felder `level` und `category` in `Agent` sind vorhanden, aber noch nicht in der Logik genutzt).
- [ ] **Automatischer Statuswechsel**: Nach Kunden-Feedback Ticket automatisch von
      `WAITING_FOR_FEEDBACK` auf `IN_PROGRESS` setzen.
- [ ] **Fälligkeiten anzeigen**: Das System soll überfällige Tickets (`dueDate` < heute)
      erkennen und im Dashboard hervorheben.
- [ ] **Kommentare als Chatverlauf**: Wer sagt was, wann und an wen – Kommentare bleiben
      Objekte in Listen (umgesetzt über die `Comment`-Klasse, ggf. erweitern).
- [ ] **`Category.agents` nutzen**: Die Liste der Agenten je Kategorie wird angelegt,
      aber noch nicht befüllt oder ausgewertet.

## Architektur / Qualität

- [ ] **Kein reines Datenbank-Projekt**: Drei-Schichten-System vermeiden. Java-Objekte sollen
      miteinander interagieren – nicht alles soll nur in eine Datenbank geschrieben werden.
- [ ] **Persistenz / Datenspeicherung**: Serialisierung umsetzen – Objekte aus Dateien laden
      und in Dateien speichern.
- [ ] **Getter/Setter prüfen**: Nur tatsächlich benötigte Getter und Setter behalten.
- [ ] **Lesbarkeit & Kommentare**: Beschreibende Kommentare ergänzen (laufend).
- [ ] **Tests**: Echte Tests ergänzen (aktuell nur manueller Smoke-Test in `Testklasse`).

## Dashboard / Analyse

- [ ] **Arbeiten mit Tickets / Analyse**: Auswertungen im Dashboard ausbauen, z. B. nach Kategorie.
- [ ] **Grafische Darstellung** der Ticket-Zählung pro Kategorie (z. B. Balken- oder Kreisdiagramm).
- [ ] Prüfen, ob das `Dashboard` eine `toString()`-Methode benötigt.

## Dokumentation

- [ ] **Klassendiagramm** erstellen.
