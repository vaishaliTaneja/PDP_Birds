package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.Set;

/**
 * Prey Bird is a type of Bird
 */
public class PreyBird extends Bird {
    public final static BirdType SPECIES_TYPE = BirdType.PREY_BIRD;
    public final static String TYPE_CHARACTERISTICS = "have sharp, hooked beaks with visible nostrils";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;
    public final static Boolean IS_MAMMAL = false;

    /**
     * To create Prey bird with following characteristics
     * @param name
     * @param typeOfBird
     * @param typeCharacteristic
     * @param isExtinct
     * @param hasWings
     * @param isMammal
     * @param preferredFoods
     */
    public PreyBird(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }

    /**
     * To create Prey bird with following characteristics
     * @param name
     */
    public PreyBird(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    /**
     * To create Prey bird with following characteristics
     * @param name
     * @param preferredFoods
     */
    public PreyBird(String name, Set<String> preferredFoods) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, preferredFoods);
    }

    /**
     * To print all the characteristics of prey bird
     * @return a string with prey bird characteristics
     */
    @Override
    public String toString() {
        return "PreyBird {" +
                "name=" + getName() +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", has Wings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                "}";
    }
}
