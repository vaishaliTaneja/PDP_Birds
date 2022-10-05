import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conservatory {

    private final static int MAX_AVIARIES = 20;
    private Map<String, Integer> foodRequirements = new HashMap<String, Integer>();
    List<Aviary> aviaries;

    /**
     * constructor of conservatory
     */
    public Conservatory() {

    }

    public void rescueBird(Bird bird) {

        if (bird.getIsExtinct()) {
            throw new IllegalArgumentException("Cannot rescue an extinct bird");
        }

        boolean isRescued = birdAssignedToAviary(bird);

        if (isRescued)
            addFoodRequirementsOfBird(bird);

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
        }
        aviaries.remove(aviary);
    }

    /**
     * assign a bird to a aviary. Need to check if it is possible or not.
     *
     * @param bird target bird
     */
    public Boolean birdAssignedToAviary(Bird bird) {
        boolean isBirdAssigned = false;
        for (Aviary aviary : aviaries) {
            //KEWAL BOTH TYPES SHOULD GET FROM ENUM ?
            if (aviary.getAllBirds().size() < Aviary.MAX_CAPACITY && aviary.getAviaryType() == bird.getTypeOfBird()) {
                aviary.addBird(bird);
                isBirdAssigned = true;
                break;
            }
        }

        if (isBirdAssigned == false) {
            if (aviaries.size() < MAX_AVIARIES) {
                Location location = Location.valueOf("LOCATION" + aviaries.size());
                Aviary newAviary = new Aviary(location);
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
    public Aviary searchBirdInAviaries(Bird bird) {
        if (bird == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        for (Aviary aviary : aviaries) {
            if (aviary.getAllBirdsAsList().contains(bird)) {
                return aviary;
            }
        }
        return null;
    }

    public void printAllBirdsInAlphaOrderAndTheirLocation() {
        HashMap<Bird, String> birdLocMap = new HashMap<>();
        for (Aviary aviary : aviaries) {
            for (Bird bird : aviary.getAllBirds())
                birdLocMap.put(bird, aviary.getLocation().toString());
        }

        System.out.println("Bird listed in alpha order and their location");
        for (Bird bird : birdLocMap.keySet()) {
            System.out.println(bird.getName() + " : " + birdLocMap.get(bird));
        }
    }

    /**
     * print all signs of all the aviaries
     */
    public void printSignOfAviary(Aviary aviary) {
        if (aviary != null) {
            aviary.printAviarySign();
        }
    }
}
