package Exceptions;

/**
 * Created by Master on 01.11.2017.
 */
public class WeekNotFoundException extends Exception {

    public WeekNotFoundException() {}

    public String toString() {
        return "Exception[Week entry not found]";
    }

}
