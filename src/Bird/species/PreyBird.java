package Bird.species;

import Bird.Bird;
import enums.BirdType;
import enums.Food;

import java.util.Collections;
import java.util.Set;

public class PreyBird extends Bird {
    public final static BirdType SPECIES_TYPE = BirdType.PREY_BIRD;
    public final static String TYPE_CHARACTERISTICS = "have sharp, hooked beaks with visible nostrils";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;
    public final static Boolean IS_MAMMAL = false;
    public PreyBird(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }
    public PreyBird(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    public PreyBird(String name, Set<String> preferredFoods) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, preferredFoods);
    }

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
