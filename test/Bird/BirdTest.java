package Bird;

import Bird.species.Owl;
import enums.BirdType;
import enums.Food;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BirdTest {

    Owl bird;
    String name;
    BirdType birdType;

    boolean isExtinct;
    boolean isMammal;
    Set<String> prefFood = new HashSet<>();
    @Before
    public void setup(){
        name = "OWL1";
        isExtinct = false;
        isMammal = true;
        prefFood.add(Food.FRUIT.toString());
        birdType = BirdType.OWL;
        bird = new Owl(name, Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, isExtinct, Owl.HAS_WINGS, isMammal, prefFood);
    }

    @org.junit.Test
    public void getName() {
        assertEquals( name, bird.getName());
    }

    @org.junit.Test
    public void setName() {
        String newName = "gundu";
        bird.setName(newName);
        assertEquals( newName, bird.getName());
    }

    @Test
    public void getIsExtinct() {
        assertEquals(isExtinct, bird.getIsExtinct());
    }

    @Test
    public void setIsExtinct() {
        boolean newIsExtinct = true;
        bird.setIsExtinct(newIsExtinct);
        assertEquals(newIsExtinct, bird.getIsExtinct());
    }

    @Test
    public void getIsMammal() {
        assertEquals(isMammal, bird.getIsMammal());
    }

    @Test
    public void setIsMammal() {
        boolean newIsMammal = false;
        bird.setIsMammal(newIsMammal);
        assertEquals(newIsMammal, bird.getIsMammal());
    }

    @Test
    public void getPreferredFoods() {
        assertEquals(prefFood, bird.getPreferredFoods());
    }

    @Test
    public void setPreferredFoods() {
        Set<String> newFood = new HashSet<>();
        newFood.add("Grass");
        newFood.add("Mushroom");
        bird.setPreferredFoods(newFood);
        assertEquals(newFood, bird.getPreferredFoods());
    }

    @org.junit.Test
    public void getTypeOfBird() {
        assertEquals( birdType, bird.getTypeOfBird());
    }

    @org.junit.Test
    public void getNameWithType() {
        assertEquals( name + "(" + birdType.toString() + ")", bird.getNameWithType());
    }

    @org.junit.Test
    public void setTypeOfBird() {
        BirdType newType = BirdType.MIX;
        bird.setTypeOfBird(newType);
        assertEquals( newType, bird.getTypeOfBird());
    }

    @org.junit.Test
    public void setCharacteristic() {
        String characteristics = "Big beak, long wings";
        bird.setCharacteristic(characteristics);
        assertEquals(characteristics, bird.getCharacteristic());
    }

    @org.junit.Test
    public void getCharacteristic() {
        assertEquals(Owl.TYPE_CHARACTERISTICS ,bird.getCharacteristic());
    }

    @org.junit.Test
    public void getHasWings() {
        assertEquals(true, bird.getHasWings());
    }

    @org.junit.Test
    public void setHasWings() {
        boolean newVal = false;
        bird.setHasWings(newVal);
        assertEquals(newVal, bird.getHasWings());
    }

    @org.junit.Test
    public void testToString() {
        String desc = "Bird.species.Owl {name=OWL1, type=OWL, characteristic=facial disks that frame the eyes and bill, isExtinct=false, hasWings=true, favoriteFoods=[FRUIT], isMammal=true}";
        assertEquals(desc, bird.toString());
    }
}