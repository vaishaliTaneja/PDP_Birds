package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.Set;

public class Pigeon extends Bird {

    public final static BirdType SPECIES_TYPE = BirdType.PIGEON;
    public final static String TYPE_CHARACTERISTICS = "known for feeding their young \"bird milk\"";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = false;

    public final static Boolean IS_MAMMAL = true;
    public Pigeon(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }
    public Pigeon(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    @Override
    public String toString() {
        return "Bird.species.Pigeon {" +
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
