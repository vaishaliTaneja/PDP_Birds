package Conservatory;

import Bird.Bird;
import Bird.species.Owl;
import Bird.species.PreyBird;
import Conservatory.Enclosure.Aviary;
import enums.Food;
import enums.Location;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class ConservatoryTest {

    Conservatory conservatory;

    @Before
    public void setUp(){
        conservatory = new Conservatory();
    }

    //Test cases for rescueBird
    @Test
    public void rescueBirdThatIsExtinctThrowsException() {
         Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, true,Owl.HAS_WINGS,Owl.IS_MAMMAL,null);
        try {
            conservatory.rescueBird(owl);
        }
        catch (Exception e){
            assertEquals("Cannot rescue an extinct bird", e.getMessage());
        }
    }

    @Test
    public void rescueBirdThatIsNotExtinctReturnsTrue() {
        Set<String> prefFood = new HashSet<>();
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        conservatory.rescueBird(owl);
        assertEquals(owl, conservatory.getAviaries().get(0).getAllBirds().get(0));
    }

    @Test
    public void rescueConflictingBirdThatIsNotExtinctReturnsTrue() {
        Set<String> prefFood = new HashSet<>();
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        PreyBird preyBird = new PreyBird("PreyBird",PreyBird.SPECIES_TYPE, PreyBird.TYPE_CHARACTERISTICS, false,PreyBird.HAS_WINGS,PreyBird.IS_MAMMAL,prefFood);
        conservatory.rescueBird(owl);
        conservatory.rescueBird(preyBird);
        assertEquals(2, conservatory.getAviaries().size());

    }

    @Test
    public void rescueNonConflictingBirdThatIsNotExtinctReturnsTrue() {
        Set<String> prefFood = new HashSet<>();
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl2 = new Owl("Owl2",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        conservatory.rescueBird(owl);
        conservatory.rescueBird(owl2);
        assertEquals(1, conservatory.getAviaries().size());
    }

    @Test
    public void rescueBirdWhenMaxCapacityExceededReturnsFalse() {
        Set<String> prefFood = new HashSet<>();
        try {
            for (int i = 0; i < 101; i++) {
                Bird owl = new Owl("Owl", Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false, Owl.HAS_WINGS, Owl.IS_MAMMAL, prefFood);
                conservatory.rescueBird(owl);
            }
        }catch (Exception e){
            assertEquals("All 20 Avaries full capacity! Can't rescue", e.getMessage());
        }
    }

    @Test
    public void rescueConflictingBird() {
        Set<String> prefFood = new HashSet<>();
        try {
            for (int i = 0; i < 99; i++) {
                Bird owl = new Owl("Owl", Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false, Owl.HAS_WINGS, Owl.IS_MAMMAL, prefFood);
                conservatory.rescueBird(owl);
            }
            PreyBird preyBird = new PreyBird("PreyBird",PreyBird.SPECIES_TYPE, PreyBird.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
            conservatory.rescueBird(preyBird);

        }catch (Exception e){
            System.out.println("Exception called");
            PreyBird preyBird = new PreyBird("PreyBird",PreyBird.SPECIES_TYPE, PreyBird.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
            assertEquals("Conflicting birds and no empty aviary! Can't rescue", e.getMessage());
        }
    }

    @Test
    public void addFoodRequirementsOfBird() {
        Set<String> prefFood = new HashSet<>();
        prefFood.add(Food.BERRIES.toString());
        prefFood.add(Food.FRUIT.toString());
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        conservatory.addFoodRequirementsOfBird(owl);
        assertEquals(2, conservatory.getFoodRequirements().size());
        prefFood.add(Food.INSECTS.toString());
        Bird owl2 = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        conservatory.addFoodRequirementsOfBird(owl2);
        HashMap<String, Integer> map= conservatory.getFoodRequirements();
        assertEquals(2, (int)map.get(Food.BERRIES.toString()));
    }

    @Test
    public void addAviary() {
        Aviary aviary = new Aviary(Location.LOCATION3, "Aviary1");
        conservatory.addAviary(aviary);
        assertEquals(aviary, conservatory.getAviaries().get(0));
    }

    @Test
    public void addAviaryWhenAvariesSizeGreaterThan20() {
        try{
            for(int i=0; i< 21; i++){
                String av = "Avary"+i;
            Aviary aviary = new Aviary(Location.LOCATION3, av);
            conservatory.addAviary(aviary);}
        }catch (Exception e){
            assertEquals( "Already has 20 aviaries!",e.getMessage());
        }

    }

    @Test
    public void addNullAviary() {
        try{

                Aviary aviary = null;
                conservatory.addAviary(aviary);
        }catch (Exception e){
            assertEquals( "Argument cannot be null",e.getMessage());
        }

    }

    @Test
    public void removeAviary() {
        Aviary aviary = new Aviary(Location.LOCATION3, "Aviary1");
        conservatory.addAviary(aviary);
        assertEquals(1, conservatory.getAviaries().size() );
        conservatory.removeAviary(aviary);
        assertEquals(0, conservatory.getAviaries().size() );
    }

    @Test
    public void birdAssignedToAviaryWhenEmptyReturnsTrue() {
        Set<String> prefFood = new HashSet<>();
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        assertEquals(true, conservatory.birdAssignedToAviary(owl));
    }

    @Test
    public void birdAssignedToAviaryWhenEmptyReturnsFalse() {
        Set<String> prefFood = new HashSet<>();
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        assertEquals(true, conservatory.birdAssignedToAviary(owl));
    }

    @Test
    public void searchBirdInAviariesWhenBirdExistsReturnsAviary() {
        Set<String> prefFood = new HashSet<>();
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        conservatory.rescueBird(owl);
        Aviary aviary = conservatory.getAviaries().get(0);
        assertEquals( aviary, conservatory.searchBirdInAviaries(owl) );
    }

    @Test
    public void searchBirdInAviariesWhenBirdDoesntExistsReturnsNull() {
        Set<String> prefFood = new HashSet<>();
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl2 = new Owl("Owl2",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        conservatory.rescueBird(owl);
        assertEquals( null, conservatory.searchBirdInAviaries(owl2) );
    }

    @Test
    public void printAllBirdsInAlphaOrderAndTheirLocation() {
        Set<String> prefFood = new HashSet<>();
        Bird owl3 = new Owl("bwl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl4 = new Owl("awl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);

        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl2 = new Owl("Owl2",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        conservatory.rescueBird(owl);
        conservatory.rescueBird(owl2);
        conservatory.rescueBird(owl3);
        conservatory.rescueBird(owl4);
        String alphaOrder = "awl : LOCATION1\n" +
                "bwl : LOCATION1\n" +
                "owl : LOCATION1\n" +
                "owl2 : LOCATION1\n";
        assertEquals(alphaOrder, conservatory.printAllBirdsInAlphaOrderAndTheirLocation());
    }

    @Test
    public void mapAviariesByTheirLocation() {
        Set<String> prefFood = new HashSet<>();
        Bird owl3 = new Owl("bwl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl4 = new Owl("awl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl2 = new Owl("Owl2",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl5 = new Owl("Owl5",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl6 = new Owl("Owl6",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        PreyBird preyBird = new PreyBird("PreyBird",PreyBird.SPECIES_TYPE, PreyBird.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);

        conservatory.rescueBird(owl);
        conservatory.rescueBird(owl2);
        conservatory.rescueBird(owl3);
        conservatory.rescueBird(owl4);
        conservatory.rescueBird(owl5);
        conservatory.rescueBird(owl6);
        conservatory.rescueBird(preyBird);
        String map = "LOCATION1 : Conservatory.Enclosure.Aviary0 : [Owl, Owl2, bwl, awl, Owl5]\n" +
                "LOCATION2 : Conservatory.Enclosure.Aviary1 : [Owl6]\n" +
                "LOCATION3 : Conservatory.Enclosure.Aviary2 : [PreyBird]\n";
        assertEquals(map , conservatory.mapAviariesByTheirLocation());
    }

    @Test
    public void printSignOfAviaryWhenAviaryNotInConservatory() {
        Aviary aviary = new Aviary(Location.LOCATION3, "AVIARY");
        assertEquals("",conservatory.printSignOfAviary(aviary));
    }

    @Test
    public void printSignOfAviary() {
        Set<String> prefFood = new HashSet<>();
        Bird owl3 = new Owl("bwl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl4 = new Owl("awl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl = new Owl("Owl",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl2 = new Owl("Owl2",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl5 = new Owl("Owl5",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        Bird owl6 = new Owl("Owl6",Owl.SPECIES_TYPE, Owl.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);
        PreyBird preyBird = new PreyBird("PreyBird",PreyBird.SPECIES_TYPE, PreyBird.TYPE_CHARACTERISTICS, false,Owl.HAS_WINGS,Owl.IS_MAMMAL,prefFood);

        conservatory.rescueBird(owl);
        conservatory.rescueBird(owl2);
        conservatory.rescueBird(owl3);
        conservatory.rescueBird(owl4);
        conservatory.rescueBird(owl5);
        conservatory.rescueBird(owl6);
        conservatory.rescueBird(preyBird);
        Aviary aviary = conservatory.getAviaries().get(0);
        assertEquals("MIX Aviary : The birds in this enclosure are known for facial disks that frame the eyes and bill ",conservatory.printSignOfAviary(aviary));
    }
    @Test(expected =  IllegalArgumentException.class)
    public void IllegalArgsException1() {
        conservatory.searchBirdInAviaries(null);
    }

    @Test(expected =  IllegalArgumentException.class)
    public void IllegalArgsException2() {
        conservatory.removeAviary(null);
    }
}