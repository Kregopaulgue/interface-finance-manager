package Exceptions;

/**
 * Created by Master on 01.11.2017.
 */
public class ExpenceNotFoundException extends Exception {

    ExpenceNotFoundException() {}

    public String toString() {
        return "Exception[Expence entry not found]";
    }

}
