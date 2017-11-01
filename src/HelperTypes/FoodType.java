package HelperTypes;

/**
 * Created by Master on 18.10.2017.
 */
public enum FoodType {

    //important types (importance from 5 to 10)
    MAIN_FOOD("MAIN_FOOD"),
    WATER("WATER"),

    //unimportant types (importance from 4 to 0)
    SWEETS("SWEETS"),
    UNIMPORTANT_FOOD("UNIMPORTANT_FOOD"),

    //meens String declaration by hand
    OTHER("OTHER");

    private String stringEquivalent;

    FoodType(String stringEquivalent) {
        this.stringEquivalent = stringEquivalent;
    }

    String getStringEquivalent() {
        return stringEquivalent;
    }
}
