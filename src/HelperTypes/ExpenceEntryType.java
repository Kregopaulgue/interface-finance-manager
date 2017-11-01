package HelperTypes;

/**
 * Created by Master on 18.10.2017.
 */
public enum ExpenceEntryType {
    FOOD("FOOD"),
    CLOTH("CLOTH"),
    TECHNIC("TECHNIC"),
    SERVICE("SERVICE"),
    ENTERTAINMENT("ENTERTAINMENT"),
    BILL("BILL"),
    OTHER("OTHER");

    private String stringEquivalent;

    ExpenceEntryType(String stringEquivalent) {
        this.stringEquivalent = stringEquivalent;
    }

    String getStringEquivalent() {
        return stringEquivalent;
    }
}
