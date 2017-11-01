package Exceptions;

/**
 * Created by Master on 01.11.2017.
 */
public class MonthNotFoundException extends Exception{

    public MonthNotFoundException() {}

    public String toString() {
        return "Exception[Month entry not found]";
    }

}
