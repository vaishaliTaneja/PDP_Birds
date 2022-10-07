package Animal;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AnimalTest {

    Animal animal;
    String name ;
    boolean isExtinct;
    boolean isMammal;
    Set<String> prefFood = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        name =  "Cat";
        isExtinct = false;
        isMammal = true;
        prefFood.add("Meat");
        animal = new Animal(name, isExtinct, isMammal, prefFood);
    }

    @Test
    public void testAnimalConstructorWithNoName(){
        try{
            Animal animal = new Animal(null, false, true, Collections.emptySet());
        }catch (Exception e){
            assertEquals("Bird should have a name identifier", e.getMessage());
        }
    }

    @Test
    public void getName() {
        assertEquals(name, animal.getName());
    }

    @Test
    public void setName(){
        String newName = "gundu";
        animal.setName(newName);
        assertEquals( newName, animal.getName());
    }

    @Test
    public void getIsExtinct() {
        assertEquals(isExtinct, animal.getIsExtinct());
    }

    @Test
    public void setIsExtinct() {
        boolean newIsExtinct = true;
        animal.setIsExtinct(newIsExtinct);
        assertEquals(newIsExtinct, animal.getIsExtinct());
    }

    @Test
    public void getIsMammal() {
        assertEquals(isMammal, animal.getIsMammal());
    }

    @Test
    public void setIsMammal() {
        boolean newIsMammal = false;
        animal.setIsMammal(newIsMammal);
        assertEquals(newIsMammal, animal.getIsMammal());
    }

    @Test
    public void getPreferredFoods() {
        assertEquals(prefFood, animal.getPreferredFoods());
    }

    @Test
    public void setPreferredFoods() {
        Set<String> newFood = new HashSet<>();
        newFood.add("Grass");
        newFood.add("Mushroom");
        animal.setPreferredFoods(newFood);
        assertEquals(newFood, animal.getPreferredFoods());
    }

    @Test
    public void testToString(){
        String def = "Animal {name=Cat, isExtinct=false, isMammal=true, PreferredFood=[Meat]}";
        assertEquals(def, animal.toString());
    }
}