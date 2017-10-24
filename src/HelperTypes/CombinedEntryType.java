package HelperTypes;

/**
 * Created by Master on 18.10.2017.
 */
public enum CombinedEntryType {
    FOODS_BILL("FOODS_BILL"),
    CLOTHES_BILL("CLOTHES"),
    TECHNICS_BILL("TECHNICS_BILL"),
    SERVICES_BILL("SERVICES_BILL"),
    ENTERTAINMENT_BILL("ENTERTAINMENT_BILL"),
    BILLS_BILL("BILLS_BILL"),
    OTHER_BILL("OTHER_BILL");

    private String stringEquivalent;

    CombinedEntryType(String stringEquivalent) {
        this.stringEquivalent = stringEquivalent;
    }

    String getStringEquivalent() {
        return stringEquivalent;
    }
}
