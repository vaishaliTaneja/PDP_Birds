package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Parrot is a type of Bird
 */
public class Parrot extends Bird {
    public final static BirdType SPECIES_TYPE = BirdType.PARROT;
    public final static String TYPE_CHARACTERISTICS = "short, curved beak and are known for their intelligence";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;
    public final static  Boolean IS_MAMMAL = false;
    private Set<String> vocabulary = new HashSet<>();
    private String favoriteWord;

    /**
     * Creates an object of type parrot with following arguments
     * @param name
     * @param typeOfBird
     * @param typeCharacteristic
     * @param isExtinct
     * @param hasWings
     * @param isMammal
     * @param preferredFoods
     * @param vocabulary
     * @param favoriteWord
     */
    public Parrot(String name,BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<String> vocabulary, String favoriteWord) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
        this.vocabulary = vocabulary;
        this.favoriteWord = favoriteWord;
    }

    /**
     * Creates an object of type parrot with following arguments
     * @param name
     * @param vocabulary
     * @param favoriteWord
     */
    public Parrot(String name, Set<String> vocabulary, String favoriteWord) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
        this.vocabulary = vocabulary;
        this.favoriteWord = favoriteWord;
    }

    /**
     * Creates an object of type parrot with following arguments
     * @param name
     */
    public Parrot(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAL, name, Collections.emptySet());
    }

    /**
     * to get the size of vocabulary
     * @return vocabulary size
     */
    public int getVocabularySize() {
        return vocabulary.size();
    }

    /**
     * To get the current vocabulary of parrot
     * @return vocabulary
     */
    public Set<String> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Set<String> words) {
        this.vocabulary = words;
    }

    /**
     * Adds new word to vocabulary
     * @param word
     * @throws IllegalStateException if size of vocabulary is already 100
     */
    public void addWordToVocabulary(String word) throws IllegalStateException {
        if (this.getVocabularySize() > 100) {
            throw new IllegalStateException("More than 100 words");
        }
        vocabulary.add(word);
    }

    /**
     * Removes word from vocabulary
     * @param word
     */
    public void removeWordFromVocabulary(String word) {
        if(!vocabulary.contains(word)){
            throw new IllegalStateException("Word not in vocabulary");
        }
        vocabulary.remove(word);
    }

    /**
     * get favorite word of parrot
     * @return favorite word
     */
    public String getFavoriteWord() {
        return favoriteWord;
    }

    /**
     * Set favorite word
     * @param favoriteWord
     */
    public void setFavoriteWord(String favoriteWord) {
        this.favoriteWord = favoriteWord;
    }

    /**
     * Prints a string with all the characteristics it has
     * @return a string with all the attributes of Parrot object
     */
    @Override
    public String toString() {
        return "Bird.species.Parrot {" +
                "name=" + getName() +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", hasWings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                ", favoriteFoods=" + getIsMammal() +
                ", Vocabulary size=" + getVocabularySize() +
                ", favorite Word=" + getFavoriteWord() +
                ", Vocabulary=" + getVocabulary() +
                "}";
    }
}
