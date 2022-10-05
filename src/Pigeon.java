import java.util.Collections;
import java.util.Set;

public class Pigeon extends  Bird{

    private final static BirdType SPECIES_TYPE = BirdType.OWL;
    private final static String TYPE_CHARACTERISTICS = "facial disks that frame the eyes and bill";
    private final static Boolean IS_EXTINCT = false;
    private final static Boolean HAS_WINGS = false;

    private final static Boolean IS_MAMMAL = true;
    public Pigeon(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
    }
    public Pigeon(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    @Override
    public String toString() {
        return "Pigeon {" +
                "name=" + getName() +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", numOfWings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                "}";
    }
}
