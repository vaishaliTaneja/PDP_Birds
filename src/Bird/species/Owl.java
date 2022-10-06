package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.Set;

public class Owl extends Bird {

    public final static BirdType SPECIES_TYPE = BirdType.OWL;
    public final static String TYPE_CHARACTERISTICS = "facial disks that frame the eyes and bill";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;

    public final static Boolean IS_MAMMAL = false;

    public Owl(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }
    public Owl(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

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
