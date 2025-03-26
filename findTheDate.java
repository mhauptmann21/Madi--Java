/*******************************************
*                MyDate                    *
*------------------------------------------*
* -year: int                               *
* -month: int                              *
* -day: int                                *
*                                          *
* +MyDate()                                *
* +MyDate(elapsedTime: long)               *
* +MyDate(year: int, month: int, day: int) *
* +getYear(): int                          *
* +getMonth(): int                         *
* +getDay(): int                           *
* +setDate(elapsedTime: long)              *
*******************************************/

import java.util.GregorianCalendar;

// implement the myDate class
class myDate {
    private int year;
    private int month;
    private int day;

    // no-arg constructor for the current date
    myDate() {
        GregorianCalendar calendar = new GregorianCalendar();
        year = calendar.get(GregorianCalendar.YEAR);
        month = calendar.get(GregorianCalendar.MONTH);
        day = calendar.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /*
    constructs an object with a specified elapsed time since 
    midnight, January 1,1970, in milliseconds.
     */ 
    myDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    /* 
     * creates an object with the
     *  specified year, month, and day
    */
    myDate (int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // getter mthods that will find the year, month, and day
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month + 1;
    }

    public int getDay() {
        return day;
    }

    /*
    method that sets a new date for
    the object using the elapsed time.
    */
    public void setDate(long elapsedTime) {
		GregorianCalendar calander = new GregorianCalendar();
		calander.setTimeInMillis(elapsedTime);
		year = calander.get(GregorianCalendar.YEAR);
		month = calander.get(GregorianCalendar.MONTH);
		day = calander.get(GregorianCalendar.DAY_OF_MONTH);
	}

    // methods that set the year, month, and day
    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }
}

public class findTheDate {
    public static void main(String[] args) {
        myDate date1 = new myDate();
        myDate date2 = new myDate(34355555133101L);

        System.out.println("First Date - Year: " + date1.getYear() + " Month: " + date1.getMonth() + " Day: " + date1.getDay());
        System.out.println("First Date - Year: " + date2.getYear() + " Month: " + date2.getMonth() + " Day: " + date2.getDay());
    }
}