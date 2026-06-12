/*
Diese Klasse repräsentiert ein Datum. Sie enthält Informationen über den Tag, den Monat und das Jahr. Es gibt zwei Möglichkeiten, ein Datum zu initialisieren: entweder durch manuelle Eingabe von Tag, Monat und Jahr oder durch die Verwendung des aktuellen Datums. Die Klasse bietet auch eine Methode zum Drucken des Datums in einem bestimmten Format.

Ausnahmebehandlung: Die manuelle Initialisierung prüft Tag, Monat und Jahr auf
Plausibilität (gültiger Monat, gültiger Tag für den jeweiligen Monat inkl.
Schaltjahr-Berechnung) und wirft bei ungültigen Werten eine InvalidDateException.
*/
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    // Anzahl der Tage je Monat (Index 0 = Januar ... 11 = Dezember), Februar mit 28 Tagen
    private static final int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    // Untere Grenze für plausible Jahresangaben (rein fachliche Schranke, kein technisches Limit)
    private static final int MIN_YEAR = 1900;
    private static final int MAX_YEAR = 2200;

    // Datum manuell mit Tag, Monat und Jahr setzen.
    // Wirft InvalidDateException, wenn die Kombination aus Tag, Monat und Jahr
    // kein gültiges Kalenderdatum ergibt (z. B. 31.04., 29.02. in einem Nicht-Schaltjahr,
    // Monat 0 oder 13, negative bzw. unrealistische Jahreszahlen).
    public void init(int day, int month, int year) throws InvalidDateException {
        if(!isValid(day, month, year)){
            throw new InvalidDateException(day, month, year);
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Datum auf das heutige Datum setzen (System-Kalender).
    // Kann nicht fehlschlagen, da der Systemkalender immer ein gültiges Datum liefert.
    public void init(){
        GregorianCalendar cal = new GregorianCalendar();
        this.day = cal.get(Calendar.DATE);
        this.month = cal.get(Calendar.MONTH) + 1; // Calendar.MONTH ist 0-basiert, daher +1
        this.year = cal.get(Calendar.YEAR);
    }

    // Prüft, ob day/month/year ein gültiges Kalenderdatum ergeben.
    private boolean isValid(int day, int month, int year){
        if(year < MIN_YEAR || year > MAX_YEAR){
            return false;
        }
        if(month < 1 || month > 12){
            return false;
        }
        int maxDay = DAYS_IN_MONTH[month - 1];
        if(month == 2 && isLeapYear(year)){
            maxDay = 29;
        }
        return day >= 1 && day <= maxDay;
    }

    // Schaltjahr-Berechnung nach dem gregorianischen Kalender.
    private boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int getYear(){
        return year;
    }

    // Vergleicht zuerst Jahr, dann Monat, dann Tag (für Sortierung nötig).
    public int compareTo(Date other) {
        if (this.year != other.year) return Integer.compare(this.year, other.year);
        if (this.month != other.month) return Integer.compare(this.month, other.month);
        return Integer.compare(this.day, other.day);
    }

    // Liefert true, wenn dieses Datum zeitlich NACH dem anderen liegt.
    public boolean after(Date other){
        if(this.year > other.year){
            return true;
        } else if(this.year == other.year){
            if(this.month > other.month){
                return true;
            } else if(this.month == other.month){
                if(this.day > other.day){
                    return true;
                }
            }
        }
        return false;
    }

    // Liefert true, wenn dieses Datum zeitlich VOR dem anderen liegt.
    public boolean before(Date other){
        if(this.year < other.year){
            return true;
        } else if(this.year == other.year){
            if(this.month < other.month){
                return true;
            } else if(this.month == other.month){
                if(this.day < other.day){
                    return true;
                }
            }
        }
        return false;
    }

    public String toString(){
        return day + "." + month + "." + year;
    }
}
}
