package Bird.species;

import enums.BirdType;
import enums.Food;
import enums.WaterSource;
import junit.framework.TestCase;
import org.junit.Before;

import java.util.HashSet;
import java.util.Set;

public class PreyBirdTest extends TestCase {

    private PreyBird eagle;
    @Before
    public void setUp() throws Exception {
        Set<String> favoriteFoods = new HashSet<>();
        favoriteFoods.add(Food.INSECTS.toString());
        eagle = new PreyBird("eagle", favoriteFoods);
        PreyBird defaultWaterFoul = new PreyBird("hawks");
        PreyBird swan = new PreyBird("osprey", BirdType.WATER_FOUL, "I am a osprey", WaterFoul.IS_EXTINCT, WaterFoul.HAS_WINGS, WaterFoul.IS_MAMMAL, favoriteFoods);
    }

    public void testTestToString() {
        assertEquals("PreyBird {name=eagle, type=PREY_BIRD, characteristic=have sharp, hooked beaks with visible nostrils, isExtinct=false, has Wings=true, favoriteFoods=[INSECTS]}", eagle.toString());
    }
}