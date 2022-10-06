package Bird.species;

import Bird.Bird;
import enums.BirdType;
import enums.WaterSource;

import java.util.Collections;
import java.util.Set;

public class FlightlessBird extends Bird {
    public final static BirdType SPECIES_TYPE = BirdType.FLIGHT_LESS;
    public final static String TYPE_CHARACTERISTICS = "live on the ground and have no (or undeveloped) wings";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = false;

    public final static Boolean IS_MAMMAL = false;


    public FlightlessBird(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
        /**
         * Check if user passes has wings as true
         */
    }

    public FlightlessBird(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    @Override
    public String toString() {
        return "Flightless {" +
                "name=" + getName() +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", hasWings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                "}";
    }
}
