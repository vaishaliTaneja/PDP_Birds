import java.util.Collections;
import java.util.Set;

public class FlightlessBird extends Bird {
    private final static String SPECIES_TYPE = "Flight Less Bird";
    private final static String TYPE_CHARACTERISTICS = "live on the ground and have no (or undeveloped) wings";
    private final static Boolean IS_EXTINCT = false;
    private final static Boolean HAS_WINGS = false;

    private final static Boolean IS_MAMMAL = false;


    public FlightlessBird(String typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<WaterSource> waterSources) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, preferredFoods);
        /**
         * Check if user passes has wings as true
         */
    }

    public FlightlessBird() {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, Collections.emptySet());
    }

    @Override
    public String toString() {
        return "Parrot {" +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", numOfWings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                "}";
    }
}
