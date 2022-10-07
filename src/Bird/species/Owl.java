package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.Set;

/**
 * Owl is type of bird
 */
public class Owl extends Bird {

    public final static BirdType SPECIES_TYPE = BirdType.OWL;
    public final static String TYPE_CHARACTERISTICS = "facial disks that frame the eyes and bill";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;

    public final static Boolean IS_MAMMAL = false;

    /**
     * Creates an object of type Owl with following arguments
     * @param name
     * @param typeOfBird
     * @param typeCharacteristic
     * @param isExtinct
     * @param hasWings
     * @param isMammal
     * @param preferredFoods
     */
    public Owl(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }

    /**
     * Creates an object of type Owl with following arguments
     * @param name
     */
    public Owl(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    /**
     * Prints a string with all the characteristics it has
     * @return a string with all the attributes of Owl object
     */
    @Override
    public String toString() {
        return "Bird.species.Owl {" +
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
