package Bird.species;

import enums.BirdType;
import enums.Food;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class OwlTest {

    Owl defaultOwl, owl;
    String name;
    Set<String> prefFood = new HashSet<>();

    @Before
    public void Setup(){
        prefFood.add(Food.BERRIES.toString());
        name = "Owl";
        defaultOwl = new Owl(name);
        owl = new Owl(name,Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, Owl.IS_EXTINCT,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood );
    }
    @Test
    public void testDefaultToString() {
        String desc = "Bird.species.Owl {name=Owl, type=OWL, characteristic=facial disks that frame the eyes and bill, isExtinct=false, hasWings=true, favoriteFoods=[], isMammal=false}";
        assertEquals(desc, defaultOwl.toString());
    }

    @Test
    public void testToString() {
        String desc = "Bird.species.Owl {name=Owl, type=OWL, characteristic=facial disks that frame the eyes and bill, isExtinct=false, hasWings=true, favoriteFoods=[BERRIES], isMammal=false}";
        assertEquals(desc, owl.toString());
    }

    @org.junit.Test
    public void getName() {
        assertEquals( name, owl.getName());
    }

    @org.junit.Test
    public void setName() {
        String newName = "gundu";
        owl.setName(newName);
        assertEquals( newName, owl.getName());
    }

    @Test
    public void getIsExtinct() {
        assertEquals(Owl.IS_EXTINCT, owl.getIsExtinct());
    }

    @Test
    public void setIsExtinct() {
        boolean newIsExtinct = true;
        owl.setIsExtinct(newIsExtinct);
        assertEquals(newIsExtinct, owl.getIsExtinct());
    }

    @Test
    public void getIsMammal() {
        assertEquals(Owl.IS_MAMMAL, owl.getIsMammal());
    }

    @Test
    public void setIsMammal() {
        boolean newIsMammal = false;
        owl.setIsMammal(newIsMammal);
        assertEquals(newIsMammal, owl.getIsMammal());
    }

    @Test
    public void getPreferredFoods() {
        assertEquals(prefFood, owl.getPreferredFoods());
    }

    @Test
    public void setPreferredFoods() {
        Set<String> newFood = new HashSet<>();
        newFood.add("Grass");
        newFood.add("Mushroom");
        owl.setPreferredFoods(newFood);
        assertEquals(newFood, owl.getPreferredFoods());
    }

    @org.junit.Test
    public void getTypeOfBird() {
        assertEquals( Owl.SPECIES_TYPE, owl.getTypeOfBird());
    }

    @org.junit.Test
    public void getNameWithType() {
        assertEquals( name + "(" + Owl.SPECIES_TYPE.toString() + ")", owl.getNameWithType());
    }

    @org.junit.Test
    public void setTypeOfBird() {
        BirdType newType = BirdType.MIX;
        owl.setTypeOfBird(newType);
        assertEquals( newType, owl.getTypeOfBird());
    }

    @org.junit.Test
    public void setCharacteristic() {
        String characteristics = "Big beak, long wings";
        owl.setCharacteristic(characteristics);
        assertEquals(characteristics, owl.getCharacteristic());
    }

    @org.junit.Test
    public void getCharacteristic() {
        assertEquals(Owl.TYPE_CHARACTERISTICS ,owl.getCharacteristic());
    }

    @org.junit.Test
    public void getHasWings() {
        assertEquals(Owl.HAS_WINGS, owl.getHasWings());
    }

    @org.junit.Test
    public void setHasWings() {
        boolean newVal = false;
        owl.setHasWings(newVal);
        assertEquals(newVal, owl.getHasWings());
    }
}