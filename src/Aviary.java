import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aviary {
    // maximum capacity of each aviary
    public static final int MAX_CAPACITY = 5;

    private List<Bird> birds;
    private Location location;

    private String aviaryType;

    public Aviary(Location location) {
        this.birds = new ArrayList<Bird>();
        this.location = location;
        this.setAviaryType();
    }

    private void setAviaryType() {
        var typeOfBird = this.birds.get(0).getTypeOfBird();
        switch (typeOfBird) {
            case "Prey Bird":
            case "Water Foul":
            case "Flight Less Bird" : this.aviaryType = typeOfBird;
            break;
            case "DEFAULT": this.aviaryType = "MIX";
        }
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
     * add new bird to this aviary
     *
     * @param bird bird to be added
     */
    public void addBird(Bird bird) {
        if (bird == null) {
            throw new IllegalArgumentException("Bird should be an object of type Bird");
        }
        if (this.birds.size() < MAX_CAPACITY) {
            this.birds.add(bird);
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
    public void setLocation(Location location) {
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        this.location = location;
    }

    /**
     * return number of types in this aviary
     *
     * @return number of types
     */
    public Integer getNumOfBirds() {
        return birds.size();
    }

    /**
     * check if this aviary is empty
     *
     * @return return true if this aviary is empty
     */
    public boolean isEmpty() {
        return birds.size() == 0;
    }
}
