package Bird.species;

import enums.BirdType;
import enums.Food;
import enums.WaterSource;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.HashSet;
import java.util.Set;

public class ShoreBirdTest extends TestCase {

    private ShoreBird great_auk;
    private  ShoreBird horned_puffin;
    private Set<WaterSource> waterSources = new HashSet<>();
    @Before
    public void setUp() throws Exception {
        Set<String> favoriteFoods = new HashSet<>();
        favoriteFoods.add(Food.FISH.toString());
        // water source
        waterSources.add(WaterSource.SALTWATER_SHORELANDS);
        great_auk = new ShoreBird("great_auk", favoriteFoods, waterSources);
        ShoreBird defaultWaterFoul = new ShoreBird("great_auk1", favoriteFoods);
        horned_puffin = new ShoreBird("horned puffin", BirdType.WATER_FOUL, "I am a horned puffin", WaterFoul.IS_EXTINCT, WaterFoul.HAS_WINGS, WaterFoul.IS_MAMMAL, favoriteFoods, waterSources);
    }

    public void testGetWaterSources() {
        waterSources.add(WaterSource.FRESHWATER_SHORELANDS);
        assertEquals(waterSources, great_auk.getWaterSources());
    }

    public void testSetWaterSources() {
        horned_puffin.setWaterSources(waterSources);
        assertEquals(waterSources, horned_puffin.getWaterSources());
    }

    public void testAddWaterSource() {
        waterSources.add(WaterSource.WETLANDS);
        great_auk.addWaterSource(WaterSource.WETLANDS);
        assertEquals(waterSources, great_auk.getWaterSources());
    }

    public void testRemoveWaterSource() {
        waterSources.remove(WaterSource.WETLANDS);
        great_auk.removeWaterSource(WaterSource.WETLANDS);
        assertEquals(waterSources, great_auk.getWaterSources());
    }

    public void testTestToString() {
        great_auk.setWaterSources(waterSources);
        assertEquals("Shore Bird {name=great_auk, type=SHORE_BIRD, characteristic=live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean., isExtinct=false, hasWings=true, favoriteFoods=[FISH], Water resources=[SALTWATER_SHORELANDS]}", great_auk.toString());
    }
}