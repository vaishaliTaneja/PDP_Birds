package Bird;

import Animal.Animal;
import enums.BirdType;
import java.util.Set;

/**
 * Abstract class for bird, contains all its associated properties and methods.
 */
public abstract class Bird extends Animal {
    //Bird type
    private BirdType typeOfBird;
    //Description of the birds characteristics
    private String typeCharacteristic;
    //To track if bird can fly or not
    private Boolean hasWings;

    private static String generalCharacteristic = "warm-blooded, bipedal, vertebrate";

    /**
     * Constructor for Bird
     * @param typeOfBird
     * @param typeCharacteristic
     * @param isExtinct
     * @param hasWings
     * @param isMammal
     * @param name
     * @param preferredFoods
     */
    public Bird(BirdType typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, String name, Set<String> preferredFoods) {
        super(name, isExtinct, isMammal, preferredFoods);
        this.typeOfBird = typeOfBird;
        this.typeCharacteristic = typeCharacteristic;
        this.hasWings = hasWings;
    }


    /**
     * Getter for the type of bird
     * @return BirdType
     */
    public BirdType getTypeOfBird() {
        return typeOfBird;
    }

    /**
     * Returns name of the bird along with its type
     * @return String
     */
    public  String getNameWithType() {
        return  this.getName() + "(" + getTypeOfBird() + ")";
    }

    /**
     * Setter for the type of bird
     * @param typeOfBird
     */
    public void setTypeOfBird(BirdType typeOfBird) {
        this.typeOfBird = typeOfBird;
    }

    /**
     * Setter for the bird's characteristics
     * @param typeCharacteristic
     */
    public void setCharacteristic(String typeCharacteristic) {
        this.typeCharacteristic = typeCharacteristic;
    }

    /**
     * Getter for the bird's characteristics
     * @return typeCharacteristic : String
     */
    public String getCharacteristic() {
        return this.typeCharacteristic;
    }


    /**
     * Getter to check if bird can fly or not
     * @return hasWing : Boolean
     */
    public Boolean getHasWings() {
        return hasWings;
    }


    /**
     * Setter for haswings to identify if bird can fly
     * @param hasWings
     */
    public void setHasWings(Boolean hasWings) {
        this.hasWings = hasWings;
    }


    /**
     * To define the bird with words.
     * @return String
     */
    public abstract String toString();
}
