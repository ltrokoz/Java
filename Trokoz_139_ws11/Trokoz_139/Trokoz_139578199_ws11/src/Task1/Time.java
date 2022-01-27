/**********************************************
 Workshop # 11
 Course:	    JAC444 - Winter 2021
 Last Name: 	Trokoz
 First Name: 	Liubov
 ID:		    139578199
 Section: 	    NBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature
 Date: 		    20-04-2021
 **********************************************/

package Task1;

import java.util.Calendar;
import java.util.Scanner;

public class Time implements Comparable<Time>, Cloneable {

    //	1. A data field of the long time that stores the elapsed time since midnight, Jan 1, 1970
    private long elapsedTime;
    private int hour;
    private int minute;
    private int second;

    //	2. A no-arg constructor that constructs a Time for the current time
    public Time() {
        Calendar calendar = Calendar.getInstance();
        this.hour = calendar.get(Calendar.HOUR);
        this.minute = calendar.get(Calendar.MINUTE);
        this.second = calendar.get(Calendar.SECOND);
    }

    //	3. A constructor with the specified hour, minute, and second to create a Time
    public Time(int hr, int mnt, int scd) {
        elapsedTime = (hr * 3600) + (mnt * 60) + scd;
        getHour();
        getMinute();
        getSecond();
    }

    //	4. A constructor with the specified elapsed time since midnight, Jan 1, 1970
    public Time(long elapsedTime2) {
        this.elapsedTime = elapsedTime2;
        getHour();
        getMinute();
        getSecond();
    }

    //	5. The getHour() method that returns the current hour in the range 0-23
    public int getHour() {
        this.hour = (int) (this.elapsedTime / 3600) % 24;
        return this.hour >= 0 && this.hour <= 23 ? this.hour : 0;
    }

    //	6. The getMinute() method that returns the current minute in the range 0-59
    public int getMinute() {
        this.minute = (int) (this.elapsedTime / 60) % 60;
        return this.minute >= 0 && this.minute <= 59 ? this.minute : 0;
    }

    //	7. The getSecond() method that returns the current second in the range 0-59
    public int getSecond() {
        this.second = (int) this.elapsedTime % 60;
        return this.second >= 0 && this.second <= 59 ? this.second : 0;
    }

    //	8. The getSeconds() method that returns the elapsed total seconds
    public long getSeconds() { return this.elapsedTime;  }

    //	9. The toString() method that returns a string such as "1 hour 2 minutes 1 second" and "14 hours 21 minutes 1 second"
    public String toString() {
        return this.hour + (this.hour == 0 || this.hour == 1? " hour " : " hours ")
                + this.minute + (this.minute == 0 || this.minute == 1? " minute " : " minutes ")
                + this.second + (this.second == 0 || this.second == 1? " second " : " seconds ");
    }

    //	10. Implement the Comparable<Time> interface to compare this Time with another one based on their elapse seconds. The compareTo method returns the difference between this object’s elapse seconds and the another’s
    @Override
    public int compareTo(Time time1) {
        long difElapsedTime = this.elapsedTime - time1.elapsedTime;
        return (int) difElapsedTime;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int hour, minute, second;
        long elapsedTime;
        System.out.println("\nSample Run - 1");
        System.out.print("Enter time1 (hour minute second): ");
        hour = input.nextInt();
        minute = input.nextInt();
        second = input.nextInt();
        Time time1 = new Time(hour, minute, second);
        System.out.println(time1.toString());
        System.out.println("Elapsed seconds in time1: " + time1.getSeconds());
        System.out.print("\nEnter time2 (elapsed time in seconds): ");
        elapsedTime = input.nextInt();
        Time time2 = new Time(elapsedTime);
        System.out.println(time2.toString());
        System.out.println("Elapsed seconds in time2: " + time2.getSeconds());
        System.out.println("time1.compareTo(time2)? " + time1.compareTo(time2));
        System.out.println("time3 is created as a clone of time1");

        // 11. Implement the Cloneable interface to clone a Time object
        try {
            Time time3 = (Time) time1.clone();
            System.out.println("time1.compareTo(time3)? " + time1.compareTo(time3));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("End Sample Run - 1 \n");
        System.out.println("Sample Run - 2");
        System.out.print("Enter time1 (hour minute second): ");
        hour = input.nextInt();
        minute = input.nextInt();
        second = input.nextInt();
        Time time1_sec = new Time(hour, minute, second);
        System.out.println(time1_sec.toString());
        System.out.println("Elapsed seconds in time1: " + time1_sec.getSeconds());
        System.out.print("\nEnter time2 (elapsed time in seconds): ");
        elapsedTime = input.nextInt();
        Time time2_sec = new Time(elapsedTime);
        System.out.println(time2_sec.toString());
        System.out.println("Elapsed seconds in time2: " + time2_sec.getSeconds());
        System.out.println("time1.compareTo(time2)? " + time1_sec.compareTo(time2_sec));
        System.out.println("time3 is created as a clone of time1");

        // 11. Implement the Cloneable interface to clone a Time object
        try {
            Time s2_time3 = (Time) time1_sec.clone();
            System.out.println("time1.compareTo(time3)? " + time1_sec.compareTo(s2_time3));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("End Sample Run - 2");
    }
}