package Bird.species;

import enums.BirdType;
import enums.Food;
import enums.WaterSource;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class WaterFoulTest extends TestCase {
    private WaterFoul duck;
    private Set<WaterSource> waterSources = new HashSet<>();
    @Before
    public void setUp() throws Exception {
        Set<String> favoriteFoods = new HashSet<>();
        favoriteFoods.add(Food.FISH.toString());
        // water source
        waterSources.add(WaterSource.FRESHWATER_SHORELANDS);
        duck = new WaterFoul("duck", favoriteFoods, waterSources);
        WaterFoul defaultWaterFoul = new WaterFoul("duck1");
        WaterFoul swan = new WaterFoul("Swan", BirdType.WATER_FOUL, "I am a swan", WaterFoul.IS_EXTINCT, WaterFoul.HAS_WINGS, WaterFoul.IS_MAMMAL, favoriteFoods, waterSources);
    }

    public void testGetWaterSources() {
        waterSources.add(WaterSource.FRESHWATER_SHORELANDS);
        assertEquals(waterSources, duck.getWaterSources());
    }

    public void testAddWaterSource() {
        waterSources.add(WaterSource.FRESHWATER_LAKE);
        duck.addWaterSource(WaterSource.FRESHWATER_LAKE);
        assertEquals(waterSources, duck.getWaterSources());
    }

    public void testSetWaterSources() {
        duck.setWaterSources(waterSources);
        assertEquals(waterSources, duck.getWaterSources());
    }

    public void testRemoveWaterSource() {
        waterSources.remove(WaterSource.FRESHWATER_LAKE);
        duck.removeWaterSource(WaterSource.FRESHWATER_LAKE);
        assertEquals(waterSources, duck.getWaterSources());
    }


    @Test(expected = IllegalStateException.class)
    public void IllegalStateException1() {
        duck.removeWaterSource(WaterSource.FRESHWATER_SHORELANDS);
        duck.removeWaterSource(WaterSource.FRESHWATER_SHORELANDS);
    }

    public void testTestToString() {
        duck.setWaterSources(waterSources);
        assertEquals("Water Foul {name=duck, type=WATER_FOUL, characteristic=near water sources (fresh or salt), isExtinct=false, hasWings=true, favoriteFoods=[FISH], Water resources=[FRESHWATER_SHORELANDS]}", duck.toString());
    }
}