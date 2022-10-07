package Conservatory.Enclosure;

import Bird.Bird;
import enums.BirdType;
import enums.Location;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Aviary is a place to store birds.
 */
public class Aviary {
    // maximum capacity of each aviary
    public static final int MAX_CAPACITY = 5;
    private final String id;
    private List<Bird> birds;
    private Location location;
    private BirdType aviaryType;
    /**
     * constructor of aviary
     * @param location location of the aviary from Enum location
     * @param id unique id of the aviary
     *
     */
    public Aviary(Location location, String id) {
        this.birds = new ArrayList<Bird>();
        this.location = location;
        this.id = id;
    }
    /**
     * set type of Aviary based on the type of birds it contains
     */
    private void setAviaryType() {
        var typeOfBird = this.birds.get(0).getTypeOfBird();
        switch (typeOfBird) {
            case PREY_BIRD:
            case WATER_FOUL:
            case FLIGHT_LESS : this.aviaryType = typeOfBird;
            break;
            case SHORE_BIRD:
            case PIGEON:
            case OWL:
            case PARROT: this.aviaryType = BirdType.MIX;
            break;
        }
    }
    /**
     * get ID of the aviary
     *
     * @return ID of the aviary
     */
    public String getAviaryID(){
        return this.id;
    }
    /**
     * get type of aviary
     *
     * @return type of Aviary
     */
    public BirdType getAviaryType(){
        return this.aviaryType;
    }

    /**
     * get all birds in this aviary
     *
     * @return map of birds
     */
    public List<Bird> getAllBirds() {
        return birds;
    }

    /**
     * get a list of all birds in this array
     *
     * @return list of birds
     */
    public List<Bird> getAllBirdsAsList() {
        return birds;
    }

    /**
     * add new bird to this aviary throws Illegal Argument exception if argument is null
     *
     * @param bird to be added
     */
    public void addBird(Bird bird) throws IllegalArgumentException{
        if (bird == null) {
            System.out.println("I am here");
            throw new IllegalArgumentException("Bird.Bird should be an object of type Bird.Bird");
        }
        else{
            // if aviary size is less then max capacity
            if (this.birds.size() < MAX_CAPACITY) {
                this.birds.add(bird);
                if (this.aviaryType == null) {
                    this.setAviaryType();
                }
            }
        }
    }

    /**
     * get location of this aviary
     *
     * @return location of this aviary
     */
    public Location getLocation() {
        return location;
    }

    /**
     * set location of this aviary
     *
     * @param location new location
     */
    public void setLocation(Location location) throws IllegalArgumentException {
        if (location == null) {
            throw new IllegalArgumentException("enums.Location cannot be null");
        }
        this.location = location;
    }

    /**
     * return number of types in this aviary
     *
     * @return number of types
     */
    public Integer getNumOfBirds() {
        System.out.println(this.birds);
        return this.birds.size();
    }

    /**
     * check if this aviary is empty
     *
     * @return return true if this aviary is empty
     */
    public boolean isEmpty() {
        return birds.isEmpty();
    }

    /**
     * Print the sign of Aviary
     *
     * @return return a string that returns aviary type and unique characteristics about aviary
     */

    public String printAviarySign(){
        String sign = getAviaryType() + " Aviary : ";
        Set<String> characteristics = new HashSet<>();
        for (int i = 0; i < birds.size(); i++) {
            characteristics.add(birds.get(i).getCharacteristic());
        }
        String aviaryCharacteristics = "";
        for (String characteristic : characteristics) {
            aviaryCharacteristics += characteristic + " ";
        }
        return(sign + "The birds in this enclosure are known for " + aviaryCharacteristics );
    }
}
