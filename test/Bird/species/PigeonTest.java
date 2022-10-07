package Bird.species;

import enums.BirdType;
import enums.Food;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PigeonTest {


    Pigeon defaultPigeon, pigeon;
    String name;
    Set<String> prefFood = new HashSet<>();

    @Before
    public void Setup(){
        prefFood.add(Food.BERRIES.toString());
        name = "Pigeon";
        defaultPigeon = new Pigeon(name);
        pigeon = new Pigeon(name,Pigeon.SPECIES_TYPE, Pigeon.TYPE_CHARACTERISTICS, Pigeon.IS_EXTINCT,Pigeon.HAS_WINGS,Pigeon.IS_MAMMAL,prefFood );
    }
    @Test
    public void testDefaultToString() {
        String desc = "Pigeon {name=Pigeon, type=PIGEON, characteristic=known for feeding their young \"bird milk\", isExtinct=false, hasWings=false, favoriteFoods=[], isMammal=true}";
        assertEquals(desc, defaultPigeon.toString());
    }

    @Test
    public void testToString() {
        String desc = "Pigeon {name=Pigeon, type=PIGEON, characteristic=known for feeding their young \"bird milk\", isExtinct=false, hasWings=false, favoriteFoods=[BERRIES], isMammal=true}";
        assertEquals(desc, pigeon.toString());
    }

    @org.junit.Test
    public void getName() {
        assertEquals( name, pigeon.getName());
    }

    @org.junit.Test
    public void setName() {
        String newName = "gundu";
        pigeon.setName(newName);
        assertEquals( newName, pigeon.getName());
    }

    @Test
    public void getIsExtinct() {
        assertEquals(Pigeon.IS_EXTINCT, pigeon.getIsExtinct());
    }

    @Test
    public void setIsExtinct() {
        boolean newIsExtinct = true;
        pigeon.setIsExtinct(newIsExtinct);
        assertEquals(newIsExtinct, pigeon.getIsExtinct());
    }

    @Test
    public void getIsMammal() {
        assertEquals(Pigeon.IS_MAMMAL, pigeon.getIsMammal());
    }

    @Test
    public void setIsMammal() {
        boolean newIsMammal = false;
        pigeon.setIsMammal(newIsMammal);
        assertEquals(newIsMammal, pigeon.getIsMammal());
    }

    @Test
    public void getPreferredFoods() {
        assertEquals(prefFood, pigeon.getPreferredFoods());
    }

    @Test
    public void setPreferredFoods() {
        Set<String> newFood = new HashSet<>();
        newFood.add("Grass");
        newFood.add("Mushroom");
        pigeon.setPreferredFoods(newFood);
        assertEquals(newFood, pigeon.getPreferredFoods());
    }

    @org.junit.Test
    public void getTypeOfBird() {
        assertEquals( Pigeon.SPECIES_TYPE, pigeon.getTypeOfBird());
    }

    @org.junit.Test
    public void getNameWithType() {
        assertEquals( name + "(" + Pigeon.SPECIES_TYPE.toString() + ")", pigeon.getNameWithType());
    }

    @org.junit.Test
    public void setTypeOfBird() {
        BirdType newType = BirdType.MIX;
        pigeon.setTypeOfBird(newType);
        assertEquals( newType, pigeon.getTypeOfBird());
    }

    @org.junit.Test
    public void setCharacteristic() {
        String characteristics = "Big beak, long wings";
        pigeon.setCharacteristic(characteristics);
        assertEquals(characteristics, pigeon.getCharacteristic());
    }

    @org.junit.Test
    public void getCharacteristic() {
        assertEquals(Pigeon.TYPE_CHARACTERISTICS ,pigeon.getCharacteristic());
    }

    @org.junit.Test
    public void getHasWings() {
        assertEquals(Pigeon.HAS_WINGS, pigeon.getHasWings());
    }

    @org.junit.Test
    public void setHasWings() {
        boolean newVal = false;
        pigeon.setHasWings(newVal);
        assertEquals(newVal, pigeon.getHasWings());
    }
}