package Bird.species;

import enums.BirdType;
import enums.Food;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ParrotTest {

    Parrot defaultParrot, parrot;
    String name;
    Set<String> prefFood = new HashSet<>();

    Set<String> vocabulary = new HashSet<>();
    String favoriteWord;

    @Before
    public void Setup(){
        prefFood.add(Food.BERRIES.toString());
        name = "Parrot";
        defaultParrot = new Parrot(name);
        vocabulary.add("Hello");
        vocabulary.add("Hi");
        favoriteWord = "joke";
        parrot = new Parrot(name,Parrot.SPECIES_TYPE, Parrot.TYPE_CHARACTERISTICS, Parrot.IS_EXTINCT,Parrot.HAS_WINGS,Parrot.IS_MAMMAl,prefFood, vocabulary, favoriteWord);
    }
    @Test
    public void getVocabularySize() {
        assertEquals(vocabulary.size(), parrot.getVocabularySize());
    }

    @Test
    public void getVocabulary() {
        assertEquals(vocabulary, parrot.getVocabulary());
    }

    @Test
    public void setVocabulary() {
        Set<String> newVoc = new HashSet<>();
        newVoc.add("lemon");
        parrot.setVocabulary(newVoc);
        assertEquals(newVoc, parrot.getVocabulary());
    }

    @Test
    public void addWordToVocabulary() {
        String newWord = "home";
        Set<String> temp = parrot.getVocabulary();
        temp.add(newWord);
        parrot.addWordToVocabulary(newWord);
        assertEquals(temp.toArray(), parrot.getVocabulary().toArray());
    }

    @Test
    public void removeWordFromVocabulary() {
        String newWord = "home";
        Set<String> temp = parrot.getVocabulary();
        temp.remove(newWord);
        parrot.removeWordFromVocabulary(newWord);
        assertEquals(temp.toArray(), parrot.getVocabulary().toArray());
    }

    @Test
    public void getFavoriteWord() {
        assertEquals(favoriteWord, parrot.getFavoriteWord());
    }

    @Test
    public void setFavoriteWord() {
        String newFavWord = "Biscuits";
        parrot.setFavoriteWord(newFavWord);
        assertEquals(newFavWord, parrot.getFavoriteWord());
    }

    @Test
    public void testDefaultToString() {
        String desc = "Bird.species.Parrot {name=Parrot, type=PARROT, characteristic=short, curved beak and are known for their intelligence, isExtinct=false, hasWings=true, favoriteFoods=[], favoriteFoods=false, Vocabulary size=0, favorite Word=null, Vocabulary=[]}";
        assertEquals(desc, defaultParrot.toString());
    }

    @Test
    public void testToString() {
        String desc = "Bird.species.Parrot {name=Parrot, type=PARROT, characteristic=short, curved beak and are known for their intelligence, isExtinct=false, hasWings=true, favoriteFoods=[BERRIES], favoriteFoods=false, Vocabulary size=2, favorite Word=joke, Vocabulary=[Hi, Hello]}";
        assertEquals(desc, parrot.toString());
    }

    @org.junit.Test
    public void getName() {
        assertEquals( name, parrot.getName());
    }

    @org.junit.Test
    public void setName() {
        String newName = "gundu";
        parrot.setName(newName);
        assertEquals( newName, parrot.getName());
    }

    @Test
    public void getIsExtinct() {
        assertEquals(Parrot.IS_EXTINCT, parrot.getIsExtinct());
    }

    @Test
    public void setIsExtinct() {
        boolean newIsExtinct = true;
        parrot.setIsExtinct(newIsExtinct);
        assertEquals(newIsExtinct, parrot.getIsExtinct());
    }

    @Test
    public void getIsMammal() {
        assertEquals(Parrot.IS_MAMMAl, parrot.getIsMammal());
    }

    @Test
    public void setIsMammal() {
        boolean newIsMammal = false;
        parrot.setIsMammal(newIsMammal);
        assertEquals(newIsMammal, parrot.getIsMammal());
    }

    @Test
    public void getPreferredFoods() {
        assertEquals(prefFood, parrot.getPreferredFoods());
    }

    @Test
    public void setPreferredFoods() {
        Set<String> newFood = new HashSet<>();
        newFood.add("Grass");
        newFood.add("Mushroom");
        parrot.setPreferredFoods(newFood);
        assertEquals(newFood, parrot.getPreferredFoods());
    }

    @org.junit.Test
    public void getTypeOfBird() {
        assertEquals( Parrot.SPECIES_TYPE, parrot.getTypeOfBird());
    }

    @org.junit.Test
    public void getNameWithType() {
        assertEquals( name + "(" + Parrot.SPECIES_TYPE.toString() + ")", parrot.getNameWithType());
    }

    @org.junit.Test
    public void setTypeOfBird() {
        BirdType newType = BirdType.MIX;
        parrot.setTypeOfBird(newType);
        assertEquals( newType, parrot.getTypeOfBird());
    }

    @org.junit.Test
    public void setCharacteristic() {
        String characteristics = "Big beak, long wings";
        parrot.setCharacteristic(characteristics);
        assertEquals(characteristics, parrot.getCharacteristic());
    }

    @org.junit.Test
    public void getCharacteristic() {
        assertEquals(Parrot.TYPE_CHARACTERISTICS ,parrot.getCharacteristic());
    }

    @org.junit.Test
    public void getHasWings() {
        assertEquals(Parrot.HAS_WINGS, parrot.getHasWings());
    }

    @org.junit.Test
    public void setHasWings() {
        boolean newVal = false;
        parrot.setHasWings(newVal);
        assertEquals(newVal, parrot.getHasWings());
    }
}