import java.util.Collections;
import java.util.Set;

public class PreyBird extends Bird{
    private final static String SPECIES_TYPE = "Prey Bird";
    private final static String TYPE_CHARACTERISTICS = "have sharp, hooked beaks with visible nostrils";
    private final static Boolean IS_EXTINCT = false;
    private final static Boolean HAS_WINGS = true;
    private final static Boolean IS_MAMMAL = false;
    public PreyBird(String typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, preferredFoods);
    }
    public PreyBird() {
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
