package Bird.species;

import java.util.Set;

import Bird.Bird;
import enums.BirdType;
import enums.WaterSource;

public class ShoreBird extends Bird implements WaterBird{

    public final static BirdType SPECIES_TYPE = BirdType.SHORE_BIRD;
    public final static String TYPE_CHARACTERISTICS = "live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean.";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;
    public final static Boolean IS_MAMMAL = false;

    private Set<WaterSource> waterSources;


    public ShoreBird(String name, BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<WaterSource> waterSources) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
        this.waterSources = waterSources;
    }

    public ShoreBird(String name, Set<String> food) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, food);
    }

    public ShoreBird(String name, Set<String> food, Set<WaterSource> waterSources) {
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
    public void removeWaterSource(WaterSource waterSource) {
        System.out.println("I am here");
        System.out.println(this.waterSources);
        if (this.waterSources.isEmpty()) {
            throw new IllegalStateException("Water Sources is empty");
        } else {
            this.waterSources.remove(waterSource);
        }
    }

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
