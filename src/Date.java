/* Diese Klasse repräsentiert ein Datum. Sie enthält Informationen über den Tag, den Monat und das Jahr. Es gibt zwei Möglichkeiten, ein Datum zu initialisieren: entweder durch manuelle Eingabe von Tag, Monat und Jahr oder durch die Verwendung des aktuellen Datums. Die Klasse bietet auch eine Methode zum Drucken des Datums in einem bestimmten Format.
*/
import java.util.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
   private int day;
   private int month;
   private int year;

   public void init(int day, int month, int year){ // Datum manuell eingeben
    this.day = day;
    this.month = month;
    this.year= year;
   }

   public void init(){ // Aktuelles Datum
    GregorianCalendar cal = new GregorianCalendar();
    this.day = cal.get(Calendar.DATE);
    this.month = cal.get(Calendar.MONTH)+1;
    this.year = cal.get(Calendar.YEAR);
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

   public int compareTo(Date other) {
        if (this.year != other.year) return Integer.compare(this.year, other.year);
        if (this.month != other.month) return Integer.compare(this.month, other.month);
        return Integer.compare(this.day, other.day);
    }

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
