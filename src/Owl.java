import java.util.Collections;
import java.util.Set;

public class Owl extends Bird{

    private final static String SPECIES_TYPE = "Owl";
    private final static String TYPE_CHARACTERISTICS = "acial disks that frame the eyes and bill";
    private final static Boolean IS_EXTINCT = false;
    private final static Boolean HAS_WINGS = false;

    private final static Boolean IS_MAMMAL = false;

    public Owl(String typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, preferredFoods);
    }
    public Owl() {
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
