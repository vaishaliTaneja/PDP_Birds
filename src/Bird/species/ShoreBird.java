package Bird.species;

import Bird.Bird;
import enums.BirdType;
import enums.WaterSource;

import java.util.Set;

/**
 * Shore Bird is a type of bird that implements Water Bird
 */
public class ShoreBird extends Bird implements WaterBird{

    public final static BirdType SPECIES_TYPE = BirdType.SHORE_BIRD;
    public final static String TYPE_CHARACTERISTICS = "live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean.";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;
    public final static Boolean IS_MAMMAL = false;

    private Set<WaterSource> waterSources;

    /**
     * To create shore bird with below arguments
     * @param name
     * @param typeOfBird
     * @param typeCharacteristic
     * @param isExtinct
     * @param hasWings
     * @param isMammal
     * @param preferredFoods
     * @param waterSources
     */
    public ShoreBird(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<WaterSource> waterSources) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
        this.waterSources = waterSources;
    }

    /**
     * To create shore bird with below arguments
     * @param name
     * @param food
     */
    public ShoreBird(String name, Set<String> food) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, food);
    }

    /**
     * To create shore bird with below arguments
     * @param name
     * @param food
     * @param waterSources
     */
    public ShoreBird(String name, Set<String> food, Set<WaterSource> waterSources) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, food);
        this.waterSources = waterSources;
    }

    /**
     * To get water sources
     * @return water sources
     */
    @Override
    public Set<WaterSource> getWaterSources() {
        return waterSources;
    }

    /**
     * To set water resources
     * @param waterSources
     */
    @Override
    public void setWaterSources(Set<WaterSource> waterSources) {
        this.waterSources = waterSources;
    }

    /**
     * To add new water source to existing list
     * @param waterSource
     */
    @Override
    public void addWaterSource(WaterSource waterSource) {
        this.waterSources.add(waterSource);
    }

    /**
     * To remove water source from existing list of water sources
     * @param waterSource
     */
    @Override
    public void removeWaterSource(WaterSource waterSource) {
        if (!waterSources.contains(waterSource)) {
            throw new IllegalStateException("Water Sources doesnt exist in list!");
        } else {
            this.waterSources.remove(waterSource);
        }
    }

    /**
     * Returns a string with all the feature of Shore bird
     * @return a string
     */
    @Override
    public String toString() {
        return "Shore Bird {" +
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
