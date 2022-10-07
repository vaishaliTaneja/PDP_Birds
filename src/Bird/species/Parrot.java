package Bird.species;

import Bird.Bird;
import enums.BirdType;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Parrot extends Bird {
    public final static BirdType SPECIES_TYPE = BirdType.PARROT;
    public final static String TYPE_CHARACTERISTICS = "short, curved beak and are known for their intelligence";
    public final static Boolean IS_EXTINCT = false;
    public final static Boolean HAS_WINGS = true;
    public final static  Boolean IS_MAMMAl = false;
    private Set<String> vocabulary = new HashSet<>();
    private String favoriteWord;

    public Parrot(String name,BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<String> vocabulary, String favoriteWord) {
        super(typeOfBird, typeCharacteristic, isExtinct, hasWings, isMammal, name, preferredFoods);
        this.vocabulary = vocabulary;
        this.favoriteWord = favoriteWord;
    }

    public Parrot(String name, Set<String> vocabulary, String favoriteWord) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAl, name, Collections.emptySet());
        this.vocabulary = vocabulary;
        this.favoriteWord = favoriteWord;
    }

    public Parrot(String name) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAl, name, Collections.emptySet());
    }


    public int getVocabularySize() {
        return vocabulary.size();
    }

    public Set<String> getVocabulary() {
        return vocabulary;
    }

    public void setVocabulary(Set<String> words) {
        this.vocabulary = words;
    }

    public void addWordToVocabulary(String word) throws IllegalStateException {
        if (this.getVocabularySize() >= 100) {
            throw new IllegalStateException("More than 100 words");
        }
        vocabulary.add(word);
    }
    public void removeWordFromVocabulary(String word) {
        vocabulary.remove(word);
    }

    /**
     * get favorite saying
     */
    public String getFavoriteWord() {
        return favoriteWord;
    }

    /**
     * set favorite saying
     */
    public void setFavoriteWord(String favoriteWord) {
        this.favoriteWord = favoriteWord;
    }

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
