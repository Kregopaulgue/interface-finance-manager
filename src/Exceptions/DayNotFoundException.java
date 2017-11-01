package Exceptions;

/**
 * Created by Master on 01.11.2017.
 */
public class DayNotFoundException extends Exception {

    public DayNotFoundException() {}

    public String toString() {
        return "Exception[Day entry not found]";
    }

}
