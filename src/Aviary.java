import java.util.*;

public class Aviary {
    // maximum capacity of each aviary
    public static final int MAX_CAPACITY = 5;
    private final String id;
    private List<Bird> birds;
    private Location location;

    private BirdType aviaryType;

    public Aviary(Location location, String id) {
        this.birds = new ArrayList<Bird>();
        this.location = location;
        this.id = id;
    }

    public BirdType getAviaryType(){
        return this.aviaryType;
    }

    public String getAviaryID(){
        return this.id;
    }

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
            if (this.aviaryType == null) {
                this.setAviaryType();
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

    public void printAviarySign(){
        System.out.println(getAviaryType() + " Aviary : ");
        Set<String> characteristics = new HashSet<>();
        for (int i = 1; i <= birds.size(); i++) {
            characteristics.add(birds.get(i).getCharacteristic());
        }
        String aviaryCharacteristics = "";
        for (String characteristic : characteristics) {
            aviaryCharacteristics += characteristic + " ";
        }
        System.out.println("The birds in this enclosure are known for" + aviaryCharacteristics );
    }

}
