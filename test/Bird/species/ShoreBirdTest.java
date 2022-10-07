package Bird.species;

import enums.BirdType;
import enums.Food;
import enums.WaterSource;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ShoreBirdTest {
    private ShoreBird great_auk;
    private  ShoreBird horned_puffin;
    private Set<WaterSource> waterSources = new HashSet<>();
    /**
     * We need to init before each test.
     * So we use @Before instead of @BeforeClass
     */
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

    /**
     * To test get water sources
     */
    @Test
    public void testGetWaterSources() {
        waterSources.add(WaterSource.FRESHWATER_SHORELANDS);
        assertEquals(waterSources, great_auk.getWaterSources());
    }

    /**
     * To test set water sources
     */
    @Test
    public void testSetWaterSources() {
        horned_puffin.setWaterSources(waterSources);
        assertEquals(waterSources, horned_puffin.getWaterSources());
    }
    /**
     * To test add water sources
     */
    @Test
    public void testAddWaterSource() {
        waterSources.add(WaterSource.WETLANDS);
        great_auk.addWaterSource(WaterSource.WETLANDS);
        assertEquals(waterSources, great_auk.getWaterSources());
    }

    /**
     * To test remove water source
     */
    @Test
    public void testRemoveWaterSource() {
        waterSources.add(WaterSource.WETLANDS);
        waterSources.remove(WaterSource.WETLANDS);
        great_auk.addWaterSource(WaterSource.WETLANDS);
        great_auk.removeWaterSource(WaterSource.WETLANDS);
        assertEquals(waterSources, great_auk.getWaterSources());
    }

    /**
     *  To test to string method
     */
    @Test
    public void testTestToString() {
        great_auk.setWaterSources(waterSources);
        assertEquals("Shore Bird {name=great_auk, type=SHORE_BIRD, characteristic=live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean., isExtinct=false, hasWings=true, favoriteFoods=[FISH], Water resources=[SALTWATER_SHORELANDS]}", great_auk.toString());
    }

    /**
     * To test exception handling code
     */
    @Test(expected = IllegalStateException.class)
    public void IllegalStateException1() {
        great_auk.removeWaterSource(WaterSource.SALTWATER_SHORELANDS);
        great_auk.removeWaterSource(WaterSource.WETLANDS);
    }

}