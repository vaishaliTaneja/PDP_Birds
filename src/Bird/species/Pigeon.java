package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.Set;

/**
 * Pigeon is a type of Bird
 */
public class Pigeon extends Bird {

    public final static BirdType SPECIES_TYPE = BirdType.PIGEON;
    public final static String TYPE_CHARACTERISTICS = "known for feeding their young \"bird milk\"";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = false;

    public final static Boolean IS_MAMMAL = true;

    /**
     * To create an object of type pigeon with below arguments
     * @param name
     * @param typeOfBird
     * @param typeCharacteristic
     * @param isExtinct
     * @param hasWings
     * @param isMammal
     * @param preferredFoods
     */
    public Pigeon(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }

    /**
     * To create an object of type pigeon with below argument
     * @param name
     */
    public Pigeon(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    /**
     * Prints a string with all the characteristics it has
     * @return a string with all the attributes of Pigeon object
     */
    @Override
    public String toString() {
        return "Pigeon {" +
                "name=" + getName() +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", hasWings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                ", isMammal=" + getIsMammal() +
                "}";
    }
}
