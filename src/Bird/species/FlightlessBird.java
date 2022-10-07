package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.Set;

/**
 * Flightless bird is a type of Bird
 */
public class FlightlessBird extends Bird {
    public final static BirdType SPECIES_TYPE = BirdType.FLIGHT_LESS;
    public final static String TYPE_CHARACTERISTICS = "live on the ground and have no (or undeveloped) wings";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = false;

    public final static Boolean IS_MAMMAL = false;

    /**
     * Creates an object of type Flight less bird with following arguments
     * @param name
     * @param typeOfBird
     * @param typeCharacteristic
     * @param isExtinct
     * @param hasWings
     * @param isMammal
     * @param preferredFoods
     */
    public FlightlessBird(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }

    /**
     * Creates an object of type Flight less bird with following arguments
     * @param name
     */
    public FlightlessBird(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    /**
     * Prints a string with all the characteristics it has
     * @return a string with all the attributes of Flightless object
     */
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
