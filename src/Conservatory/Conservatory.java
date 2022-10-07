package Conservatory;

import Bird.Bird;
import Conservatory.Enclosure.Aviary;
import enums.BirdType;
import enums.Location;

import java.util.*;

public class Conservatory {

    public final static int MAX_AVIARIES = 20;
    private HashMap<String, Integer> foodRequirements = new HashMap<String, Integer>();
    private List<Aviary> aviaries = new ArrayList<>();

    /**
     * constructor of conservatory
     */
    public Conservatory() {

    }

    public boolean rescueBird(Bird bird) {

        if (bird.getIsExtinct()) {
            throw new IllegalArgumentException("Cannot rescue an extinct bird");
        } else {
            boolean isRescued = birdAssignedToAviary(bird);

            if (isRescued) {
                addFoodRequirementsOfBird(bird);
                return true;
            }
            return false;
        }
    }

    public List<Aviary> getAviaries(){
        return this.aviaries;
    }

    public void addFoodRequirementsOfBird(Bird bird) {
        for (String f : bird.getPreferredFoods()) {
            if (foodRequirements.containsKey(f)) {
                foodRequirements.put(f, foodRequirements.get(f) + 1);
            } else {
                foodRequirements.put(f, 1);
            }
        }
    }

    public HashMap<String, Integer> getFoodRequirements(){
        return this.foodRequirements;
    }


    /**
     * add new aviary
     *
     * @param aviary new aviary
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
     * remove an aviary
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
     * assign a bird to a aviary. Need to check if it is possible or not.
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
                Aviary newAviary = new Aviary(location , "Conservatory.Enclosure.Aviary" + aviaries.size());
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
     * search bird by bird's object
     *
     * @param bird target
     * @return aviary that the bird is in
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

    public String printAllBirdsInAlphaOrderAndTheirLocation() {
        HashMap<String, String> birdLocMap = new HashMap<>();
        for (Aviary aviary : aviaries) {
            for (Bird bird : aviary.getAllBirds())
                birdLocMap.put(bird.getName().toLowerCase(), aviary.getLocation().toString());
        }
        TreeMap<String, String> sorted  = new TreeMap<>(birdLocMap);
        String output = "";
        for (Map.Entry<String, String> entry: sorted.entrySet()) {
            output += entry.getKey() + " : " + entry.getValue() + '\n';
        }
        return output;
    }

    public String mapAviariesByTheirLocation() {
        String map = "";
        for (Location loc: Location.values()) {
            HashMap<String, List<String>> birdLocMap = new HashMap<>();
            for (Aviary aviary : aviaries) {
                if (loc == aviary.getLocation()) {
                    List<String> birdList = new ArrayList<>();
                    for (Bird bird : aviary.getAllBirds()){
                        birdList.add(bird.getName());
                    }
                    birdLocMap.put(aviary.getAviaryID(),birdList );
                }
            }
            if(birdLocMap.size() > 0){
                for(String aviaryID : birdLocMap.keySet()){
                    map += loc + " : " + aviaryID + " : " +birdLocMap.get(aviaryID) + "\n";
                }
            }
        }
        return map;
    }

    /**
     * print all signs of all the aviaries
     */
    public String printSignOfAviary(Aviary aviary) {
        String sign = "";
        if (aviary != null && aviaries.contains(aviary)) {
            sign = aviary.printAviarySign();
        }
        return sign;
    }

    private BirdType mapAviaryType(Bird bird) {
        BirdType birdType = BirdType.MIX;
        var typeOfBird = bird.getTypeOfBird();
        switch (typeOfBird) {
            case PREY_BIRD:
            case WATER_FOUL:
            case FLIGHT_LESS : birdType = typeOfBird;
            break;
        }
        return birdType;
    }

}
