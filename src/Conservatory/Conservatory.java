package Conservatory;

import Bird.Bird;
import Conservatory.Enclosure.Aviary;
import enums.BirdType;
import enums.Location;

import java.util.*;

/**
 * A conservatory for animals, which has a fixed number of aviaries to rescue birds
 */
public class Conservatory {
    //Max avaries in the conservatory
    public final static int MAX_AVIARIES = 20;
    //Map to track list of food and its count
    private HashMap<String, Integer> foodRequirements = new HashMap<String, Integer>();
    //List to maintain all the available avaries in the conservatory
    private List<Aviary> aviaries = new ArrayList<>();

    /**
     * constructor of conservatory
     */
    public Conservatory() {

    }


    /**
     * Method to rescue a bird, throws exception if its not possible to rescue
     *
     * @param bird
     */
    public void rescueBird(Bird bird) {

        if (bird.getIsExtinct()) {
            throw new IllegalArgumentException("Cannot rescue an extinct bird");
        } else {
            boolean isRescued = birdAssignedToAviary(bird);

            if (isRescued) {
                addFoodRequirementsOfBird(bird);
            }
        }
    }

    /**
     * Returns list of all avaries
     *
     * @return aviares : List<Aviary
     */
    public List<Aviary> getAviaries() {
        return this.aviaries;
    }

    /**
     * Function to add food to the exisiting food map
     *
     * @param bird
     */
    public void addFoodRequirementsOfBird(Bird bird) {
        for (String f : bird.getPreferredFoods()) {
            if (foodRequirements.containsKey(f)) {
                foodRequirements.put(f, foodRequirements.get(f) + 1);
            } else {
                foodRequirements.put(f, 1);
            }
        }
    }


    /**
     * Returns the map containing the food and its count
     *
     * @return foodReqirements : Map<String, Integer>
     */
    public HashMap<String, Integer> getFoodRequirements() {
        return this.foodRequirements;
    }


    /**
     * Function to add new aviary to the conservatory , if aviary count is < 20
     *
     * @param aviary : Aviary
     */
    public Aviary addAviary(Aviary aviary) throws IllegalStateException {
        if (aviary == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        }
        if (aviaries.size() >= 20) {
            throw new IllegalStateException("Already has 20 aviaries!");
        }
        aviaries.add(aviary);
        return aviary;
    }

    /**
     * Function to remove an aviary
     *
     * @param aviary the one need to delete
     */
    public void removeAviary(Aviary aviary) {
        if (aviary == null) {
            throw new IllegalArgumentException("Argument cannot be null");
        } else {
            aviaries.remove(aviary);
        }
    }

    /**
     * Assign a bird to an aviary. Need to check if it is possible or not.
     *
     * @param bird target bird
     */
    public Boolean birdAssignedToAviary(Bird bird) {
        boolean isBirdAssigned = false;
        BirdType birdType = mapAviaryType(bird);
        for (Aviary aviary : aviaries) {
            if (aviary.getAllBirds().size() < Aviary.MAX_CAPACITY && aviary.getAviaryType() == birdType) {
                aviary.addBird(bird);
                isBirdAssigned = true;
                break;
            }
        }

        if (isBirdAssigned == false) {
            if (aviaries.size() < MAX_AVIARIES) {
                int LocNum = getAviaries().size() + 1;
                Location location = Location.valueOf("LOCATION" + LocNum);
                Aviary newAviary = new Aviary(location, "Conservatory.Enclosure.Aviary" + aviaries.size());
                this.addAviary(newAviary);
                newAviary.addBird(bird);
                isBirdAssigned = true;
            } else {
                if (checkIfAnyAviaryHasSpace()) {
                    throw new IllegalArgumentException("Conflicting birds and no empty aviary! Can't rescue");
                } else {
                    throw new IllegalStateException("All 20 Avaries full capacity! Can't rescue");
                }
            }
        }
        return isBirdAssigned;
    }


    /**
     * Helper function to check if there is an aviary that is not full capacity
     *
     * @return hasSpace : boolean
     */
    private boolean checkIfAnyAviaryHasSpace() {
        boolean HasSpace = false;
        for (Aviary aviary : aviaries) {
            if (aviary.getAllBirds().size() < Aviary.MAX_CAPACITY) {
                HasSpace = true;
                break;
            }
        }
        return HasSpace;
    }

    /**
     * Search for a specific bird in the conservatory
     *
     * @param bird
     * @return aviary : Aviary
     */
    public Aviary searchBirdInAviaries(Bird bird) throws IllegalArgumentException {
        if (bird == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        } else {
            for (Aviary aviary : aviaries) {
                if (aviary.getAllBirdsAsList().contains(bird)) {
                    return aviary;
                }
            }
            return null;
        }
    }

    /**
     * Print all birds in the conservatory in alphbetical order and their location
     *
     * @return String
     */
    public String printAllBirdsInAlphaOrderAndTheirLocation() {
        HashMap<String, String> birdLocMap = new HashMap<>();
        for (Aviary aviary : aviaries) {
            for (Bird bird : aviary.getAllBirds())
                birdLocMap.put(bird.getName().toLowerCase(), aviary.getLocation().toString());
        }
        TreeMap<String, String> sorted = new TreeMap<>(birdLocMap);
        String output = "";
        for (Map.Entry<String, String> entry : sorted.entrySet()) {
            output += entry.getKey() + " : " + entry.getValue() + '\n';
        }
        return output;
    }

    /**
     * Returns the map of avaries by location along with the birds in them
     *
     * @return String
     */
    public String mapAviariesByTheirLocation() {
        String map = "";
        for (Location loc : Location.values()) {
            HashMap<String, List<String>> birdLocMap = new HashMap<>();
            for (Aviary aviary : aviaries) {
                if (loc == aviary.getLocation()) {
                    List<String> birdList = new ArrayList<>();
                    for (Bird bird : aviary.getAllBirds()) {
                        birdList.add(bird.getName());
                    }
                    birdLocMap.put(aviary.getAviaryID(), birdList);
                }
            }
            if (birdLocMap.size() > 0) {
                for (String aviaryID : birdLocMap.keySet()) {
                    map += loc + " : " + aviaryID + " : " + birdLocMap.get(aviaryID) + "\n";
                }
            }
        }
        return map;
    }

    /**
     * print the sign of the particular aviary
     *
     * @param aviary : Aviary
     * @return String
     */
    public String printSignOfAviary(Aviary aviary) {
        String sign = "";
        if (aviary != null && aviaries.contains(aviary)) {
            sign = aviary.printAviarySign();
        }
        return sign;
    }

    /**
     * Helper function to map bird to respective aviary compatible type
     *
     * @param bird
     * @return BirdType
     */
    private BirdType mapAviaryType(Bird bird) {
        BirdType birdType = BirdType.MIX;
        var typeOfBird = bird.getTypeOfBird();
        switch (typeOfBird) {
            case PREY_BIRD:
            case WATER_FOUL:
            case FLIGHT_LESS:
                birdType = typeOfBird;
                break;
        }
        return birdType;
    }

}
