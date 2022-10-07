package Conservatory.Enclosure;

import Bird.Bird;
import Bird.species.ShoreBird;
import Bird.species.WaterFoul;
import enums.BirdType;
import enums.Food;
import enums.Location;
import enums.WaterSource;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class AviaryTest extends TestCase {

    private Aviary aviary1;
    private  WaterFoul duck;
    private ShoreBird great_auk;
    @Before
    public void setUp() throws Exception {
        Set<String> favoriteFoods = new HashSet<>();
        favoriteFoods.add(Food.FISH.toString());
        // water source
        Set<WaterSource> waterSources = new HashSet<>();
        waterSources.add(WaterSource.FRESHWATER_SHORELANDS);
        aviary1 = new Aviary(Location.LOCATION1, "Aviary1");
        duck = new WaterFoul("duck", favoriteFoods, waterSources);
        great_auk = new ShoreBird("great_auk", favoriteFoods, waterSources);
    }
    @Test
    public void testGetAviaryID() {
        assertEquals("Aviary1", aviary1.getAviaryID());
    }
    @Test
    public void testGetAviaryType() {
        aviary1.addBird(duck);
        assertEquals(BirdType.WATER_FOUL, aviary1.getAviaryType());

    }
    @Test
    public void testGetAllBirdsAsList() {
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(great_auk);
        aviary1.addBird(great_auk);
        assertEquals(birds, aviary1.getAllBirdsAsList());
    }
    @Test
    public void testAddBird() {
        List<Bird> birds = new ArrayList<Bird>();
        birds.add(great_auk);
        aviary1.addBird(great_auk);
        assertEquals(birds, aviary1.getAllBirdsAsList());
        assertEquals(new Integer(1), aviary1.getNumOfBirds());
    }
    @Test
    public void testGetLocation() {
        assertEquals(Location.LOCATION1, aviary1.getLocation());
    }
    @Test
    public void testSetLocation() {
        aviary1.setLocation(Location.LOCATION3);
        assertEquals(Location.LOCATION3, aviary1.getLocation());
    }
    @Test
    public void testGetNumOfBirds() {
        aviary1.addBird(great_auk);
        assertEquals(new Integer(1), aviary1.getNumOfBirds());
    }
    @Test
    public void testIsEmpty() {
        assertEquals(true, aviary1.isEmpty());
    }
    @Test
    public void testPrintAviarySign() {
        aviary1.setLocation(Location.LOCATION3);
        aviary1.addBird(duck);
        aviary1.addBird(great_auk);
        assertEquals("WATER_FOUL Aviary : The birds in this enclosure are known for live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean. near water sources (fresh or salt) ", aviary1.printAviarySign());
    }

    @Test(expected = IllegalArgumentException.class)
    public void IllegalArgsException1() {
        aviary1.addBird(null);
    }
    @Test(expected =  IllegalArgumentException.class)
    public void IllegalArgsException2() {
        aviary1.setLocation(null);
    }
}