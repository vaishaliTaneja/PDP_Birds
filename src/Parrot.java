import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Parrot extends Bird {
    private final static String SPECIES_TYPE = "Parrot";
    private final static String TYPE_CHARACTERISTICS = "short, curved beak and are known for their intelligence";
    private final static Boolean IS_EXTINCT = false;
    private final static Boolean HAS_WINGS = true;

    private final static  Boolean IS_MAMMAl = false;
    private Set<String> vocabulary = new HashSet<>();
    private String favoriteWord;

    public Parrot(String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, Set<String> preferredFoods, Set<String> vocabulary, String favoriteWord) {
        super(SPECIES_TYPE, typeCharacteristic, isExtinct, hasWings, isMammal, preferredFoods);
        this.vocabulary = vocabulary;
        this.favoriteWord = favoriteWord;
    }

    public Parrot(Set<String> vocabulary, String favoriteWord) {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAl, Collections.emptySet());
        this.vocabulary = vocabulary;
        this.favoriteWord = favoriteWord;
    }

    public Parrot() {
        super(SPECIES_TYPE, TYPE_CHARACTERISTICS, IS_EXTINCT, HAS_WINGS, IS_MAMMAl, Collections.emptySet());
    }


    public Integer getVocabularySize() {
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
        return "Parrot {" +
                ", type=" + getTypeOfBird() +
                ", characteristic=" + getCharacteristic() +
                ", isExtinct=" + getIsExtinct() +
                ", numOfWings=" + getHasWings() +
                ", favoriteFoods=" + getPreferredFoods() +
                "}";
    }
}
