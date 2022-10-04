import java.util.Collections;
import java.util.Set;

public class WaterFoul extends Bird implements WaterBird{
    private final static String SPECIES_TYPE = "Water Foul";
    private final static String TYPE_CHARACTERISTICS = "near water sources (fresh or salt)";
    private final static Boolean IS_EXTINCT = false;
    private final static Boolean HAS_WINGS = true;
    private final static  Boolean IS_MAMMAL = false;

    private Set<WaterSource> waterSources;
    public WaterFoul(String typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<WaterSource> waterSources) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, preferredFoods);
        this.waterSources = waterSources;
    }

    public WaterFoul() {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, Collections.emptySet());
    }

    public WaterFoul(Set<WaterSource> waterSources) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, Collections.emptySet());
        this.waterSources = waterSources;
    }

    @Override
    public Set<WaterSource> getWaterSources() {
        return null;
    }

    @Override
    public void setWaterSources(Set<WaterSource> waterSources) {

    }

    @Override
    public void addWaterSource(WaterSource waterSource) {

    }

    @Override
    public void removeWaterSource(WaterSource waterSource) {

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
