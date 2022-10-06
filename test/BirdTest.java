import enums.BirdType;
import Bird.species.Owl;
import org.junit.Before;

import static org.junit.Assert.*;

public class BirdTest {

    Owl bird;
    String name;
    BirdType birdType;
    @Before
    public void setup(){
        name = "OWL1";
        birdType = BirdType.OWL;
        bird = new Owl(name);
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
        String desc = "Bird.species.Owl {name=OWL1, type=OWL, characteristic=facial disks that frame the eyes and bill, isExtinct=false, hasWings=true, favoriteFoods=[], isMammal=false}";
        assertEquals(desc, bird.toString());
    }
}