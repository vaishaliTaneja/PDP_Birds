package Animal;

import java.util.Set;

/**
 * Base class for all animals, holds properties and methods for animals in general
 */
public class Animal {

    //Property to hold if animal is extinct or not
    private Boolean isExtinct;

    //Property to hold if animal is a mammal or not
    private Boolean isMammal;

    //Property to hold list of all unique food items preferred by animal
    private Set<String> preferredFoods;

    //Property to hold name of the name to identify them (Not unique) : Required
    private String name;

    /**
     * Constructor for Animal class
     * @param name
     * @param isExtinct
     * @param isMammal
     * @param preferredFoods
     */
    public Animal (String name, Boolean isExtinct, Boolean isMammal, Set<String> preferredFoods) {
        if (name == null) {
            throw new IllegalArgumentException("Bird.Bird should have a name identifier");
        }
        this.name = name;
        this.isExtinct = isExtinct;
        this.isMammal = isMammal;
        this.preferredFoods = preferredFoods;
    }

    /**
     * Getter for the animal name
     * @return name : String
     */
    public String getName() {
        return  this.name;
    }

    /**
     * Setter for animal name
     * @param name : String
     */
    public  void setName(String name) { this.name = name;}

    /**
     * Getter for animal extinct status
     * @return is extinct : boolean
     */
    public Boolean getIsExtinct() {
        return isExtinct;
    }

    /**
     * Setters for animal extinct status
     * @param isExtinct : boolean
     */
    public void setIsExtinct(Boolean isExtinct) {
        this.isExtinct = isExtinct;
    }

    /**
     * Getter for if the animal a mammal or not
     * @return is mammal : boolean
     */
    public Boolean getIsMammal() {
        return isMammal;
    }

    /**
     * Setter for if the animal is mammal or not.
     * @param isMammal : boolean
     */
    public void setIsMammal(Boolean isMammal) {
        this.isMammal = isMammal;
    }

    /**
     * Returns a list of unique food items preferred by the animal
     * @return preferred food : Set<String>
     */
    public Set<String> getPreferredFoods() {
        return preferredFoods;
    }

    /**
     * Setter for adding the list of preferred food by the animal
     * @param preferredFoods : Set<String>
     */
    public void setPreferredFoods(Set<String> preferredFoods) {
        this.preferredFoods = preferredFoods;
    }


    /**
     * ToString to define the animal
     */
    @Override
    public String toString() {
        return "Animal {"+
                "name=" + getName() +
                ", isExtinct=" + getIsExtinct() +
                ", isMammal=" + getIsMammal() +
                ", PreferredFood=" + getPreferredFoods() +"}";
    }

}
