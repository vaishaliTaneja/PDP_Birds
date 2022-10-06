package Animal;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class AnimalTest {

    Animal animal;
    String name = "Cat";
    boolean isExtinct = false;
    boolean isMammal = true;
    Set<String> prefFood = new HashSet<>();

    @Before
    public void setUp() throws Exception {
        prefFood.add("Meat");
        animal = new Animal(name, isExtinct, isMammal, prefFood);
    }

    @Test
    public void getName() {
        assertEquals(name, animal.getName());
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
}