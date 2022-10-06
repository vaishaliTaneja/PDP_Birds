package Bird.species;

import enums.BirdType;
import enums.Food;
import enums.WaterSource;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FlightlessBirdTest {

    FlightlessBird defaultflightlessBird, flightlessBird;
    String name;
    Set<String> prefFood = new HashSet<>();

    @Before
    public void Setup(){
        prefFood.add(Food.BERRIES.toString());
        name = "flightless";
        defaultflightlessBird = new FlightlessBird(name);
        flightlessBird = new FlightlessBird(name,FlightlessBird.SPECIES_TYPE, FlightlessBird.TYPE_CHARACTERISTICS, FlightlessBird.IS_EXTINCT,FlightlessBird.HAS_WINGS,FlightlessBird.IS_MAMMAL,prefFood );
    }

    @Test
    public void testDefaultToString() {
        String desc = "Flightless {name=flightless, type=FLIGHT_LESS, characteristic=live on the ground and have no (or undeveloped) wings, isExtinct=false, hasWings=false, favoriteFoods=[]}";
        assertEquals(desc, defaultflightlessBird.toString());
    }

    @Test
    public void testToString() {
        String desc = "Flightless {name=flightless, type=FLIGHT_LESS, characteristic=live on the ground and have no (or undeveloped) wings, isExtinct=false, hasWings=false, favoriteFoods=[BERRIES]}";
        assertEquals(desc, flightlessBird.toString());
    }

    @org.junit.Test
    public void getName() {
        assertEquals( name, flightlessBird.getName());
    }

    @org.junit.Test
    public void setName() {
        String newName = "gundu";
        flightlessBird.setName(newName);
        assertEquals( newName, flightlessBird.getName());
    }

    @Test
    public void getIsExtinct() {
        assertEquals(FlightlessBird.IS_EXTINCT, flightlessBird.getIsExtinct());
    }

    @Test
    public void setIsExtinct() {
        boolean newIsExtinct = true;
        flightlessBird.setIsExtinct(newIsExtinct);
        assertEquals(newIsExtinct, flightlessBird.getIsExtinct());
    }

    @Test
    public void getIsMammal() {
        assertEquals(FlightlessBird.IS_MAMMAL, flightlessBird.getIsMammal());
    }

    @Test
    public void setIsMammal() {
        boolean newIsMammal = false;
        flightlessBird.setIsMammal(newIsMammal);
        assertEquals(newIsMammal, flightlessBird.getIsMammal());
    }

    @Test
    public void getPreferredFoods() {
        assertEquals(prefFood, flightlessBird.getPreferredFoods());
    }

    @Test
    public void setPreferredFoods() {
        Set<String> newFood = new HashSet<>();
        newFood.add("Grass");
        newFood.add("Mushroom");
        flightlessBird.setPreferredFoods(newFood);
        assertEquals(newFood, flightlessBird.getPreferredFoods());
    }

    @org.junit.Test
    public void getTypeOfBird() {
        assertEquals( FlightlessBird.SPECIES_TYPE, flightlessBird.getTypeOfBird());
    }

    @org.junit.Test
    public void getNameWithType() {
        assertEquals( name + "(" + FlightlessBird.SPECIES_TYPE.toString() + ")", flightlessBird.getNameWithType());
    }

    @org.junit.Test
    public void setTypeOfBird() {
        BirdType newType = BirdType.MIX;
        flightlessBird.setTypeOfBird(newType);
        assertEquals( newType, flightlessBird.getTypeOfBird());
    }

    @org.junit.Test
    public void setCharacteristic() {
        String characteristics = "Big beak, long wings";
        flightlessBird.setCharacteristic(characteristics);
        assertEquals(characteristics, flightlessBird.getCharacteristic());
    }

    @org.junit.Test
    public void getCharacteristic() {
        assertEquals(FlightlessBird.TYPE_CHARACTERISTICS ,flightlessBird.getCharacteristic());
    }

    @org.junit.Test
    public void getHasWings() {
        assertEquals(FlightlessBird.HAS_WINGS, flightlessBird.getHasWings());
    }

    @org.junit.Test
    public void setHasWings() {
        boolean newVal = false;
        flightlessBird.setHasWings(newVal);
        assertEquals(newVal, flightlessBird.getHasWings());
    }


}