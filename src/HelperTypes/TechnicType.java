package HelperTypes;

/**
 * Created by Master on 20.10.2017.
 */
public enum TechnicType {

    APPLIANCE("APPLIANCE"),
    COMPUTER("COMPUTER"),
    HARDWARE("HARDWARE"),
    AUDIO_SYSTEM("AUDIO_SYSTEM"),
    GAMING_HARDWARE("GAMING_HARDWARE"),
    OTHER("OTHER");

    private String stringEquivalent;

    TechnicType(String stringEquivalent) {
        this.stringEquivalent = stringEquivalent;
    }

    public String getStringEquivalent() {
        return stringEquivalent;
    }
}
