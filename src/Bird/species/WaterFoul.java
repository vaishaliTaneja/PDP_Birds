package Bird.species;

import Bird.Bird;
import enums.BirdType;
import enums.WaterSource;

import java.util.Collections;
import java.util.Set;

public class WaterFoul extends Bird implements WaterBird{
    public final static BirdType SPECIES_TYPE = BirdType.WATER_FOUL;
    public final static String TYPE_CHARACTERISTICS = "near water sources (fresh or salt)";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;
    public final static  Boolean IS_MAMMAL = false;

    private Set<WaterSource> waterSources;
    public WaterFoul(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<WaterSource> waterSources) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
        this.waterSources = waterSources;
    }

    public WaterFoul(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    public WaterFoul(String name, Set<String> food, Set<WaterSource> waterSources) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, food);
        this.waterSources = waterSources;
    }

    @Override
    public Set<WaterSource> getWaterSources() {
        return waterSources;
    }

    @Override
    public void setWaterSources(Set<WaterSource> waterSources) {
        this.waterSources = waterSources;
    }

    @Override
    public void addWaterSource(WaterSource waterSource) {
        this.waterSources.add(waterSource);
    }

    @Override
    public void removeWaterSource(WaterSource waterSource) throws IllegalStateException{
        if (this.waterSources.isEmpty()) {
            throw new IllegalStateException("Water Sources is empty");
        } else {
            this.waterSources.remove(waterSource);
        }
    }

    @Override
    public String toString() {
        return "Water Foul {" +
                "name=" + getName() +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", hasWings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                ", Water resources=" + getWaterSources() +
                "}";
    }
}
