import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conservatory {


    private final static int MAX_AVIARIES  = 20;

    private Map<String, Integer> foodRequirements = new HashMap<String, Integer>();
        List<Aviary> aviaries;

        /**
         * constructor of conservatory
         */
        public Conservatory() {

        }

        public void rescueBird(Bird bird){

            if(bird.getIsExtinct()) {
                throw new IllegalArgumentException("Cannot rescue an extinct bird");
            }

            //Logic to check existing aviary for space.or instantiate a new one. is total < 20;
            //If bird can be rescued
            addFoodRequirementsOfBird(bird);

        }

        public void addFoodRequirementsOfBird(Bird bird){
            for(String f : bird.getPreferredFoods()){
                if(foodRequirements.containsKey(f)){
                    foodRequirements.put(f, foodRequirements.get(f) + 1);
                }
                else{
                    foodRequirements.put(f, 1);
                }
            }
        }

        /**
         * get all birds in conservatory(including those in aviaries)
         *
         * @return birds in conservatory(including those in aviaries)
         */
        public Map<String, List<Bird>> getAllBirds() {
            Map<String, List<Bird>> res = new HashMap<>(birds);
            // iterate aviaries
            for (Aviary aviary : aviaries) {
                res.putAll(aviary.getAllBirds());
            }
            return res;
        }

        /**
         * get all birds in conservatory(excluding those in aviaries)
         *
         * @return birds in conservatory(excluding those in aviaries)
         */
        public Map<String, List<Bird>> getAllBirdsNotInAviary() {
            return birds;
        }

        /**
         * get a list of all birds in conservatory(including those in aviaries)
         *
         * @return birds in conservatory(including those in aviaries)
         */
        public List<Bird> getAllBirdsAsList() {
            List<Bird> ans = new ArrayList<>();
            // add all birds to ans
            for (List<Bird> birdList : birds.values()) {
                System.out.println(birdList);
                ans.addAll(birdList);
            }
            // iterate all aviaries
            for (Aviary aviary : aviaries) {
                System.out.println(aviary.getAllBirdsAsList());
                ans.addAll(aviary.getAllBirdsAsList());
            }
            System.out.println();
            return ans;
        }

        /**
         * Print an index that lists all birds in the conservatory in alphabetical order and their location
         *
         * @return List of birds info with location info
         */
        public List<BirdWithLocationInfo> getAllBirdsWithLocation() {
            List<BirdWithLocationInfo> res = new ArrayList<>();
            // iterate all these aviaries
            for (Aviary aviary : aviaries) {
                for (Bird bird : aviary.getAllBirdsAsList()) {
                    res.add(new BirdWithLocationInfo(bird, aviary.getLocation()));
                }
            }
            // sort by bird's type
            res.sort(Comparator.comparing(o -> o.getBird().getType()));
            return res;
        }

        /**
         * Print a “map” that lists all the aviaries by location and the birds they house
         *
         * @return map contains aviaries and respective birds inside
         */
        public Map<Aviary, List<Bird>> getAviaryAndBirdsAsMap() {
            Map<Aviary, List<Bird>> res = new HashMap<>();
            for (Aviary aviary : aviaries) {
                res.put(aviary, aviary.getAllBirdsAsList());
            }
            return res;
        }

        /**
         * Calculate what food needs to be kept and in what quantities
         *
         * @return Map of foods and required quantities
         */
        public Map<Food, Integer> getFoodsRequirements() {
            Map<Food, Integer> ans = new HashMap<>();
            // iterate all birds
            List<Bird> allBirds = getAllBirdsAsList();
            for (Bird bird : allBirds) {
                for (Food food : bird.getFavoriteFoods()) {
                    // food requirement + 1
                    ans.put(food, ans.getOrDefault(food, 0) + 1);
                }
            }
            return ans;
        }

        /**
         * get all aviaries
         *
         * @return list of all aviaries
         */
        public List<Aviary> getAllAviaries() {
            return aviaries;
        }

        /**
         * add new aviary
         *
         * @param aviary new aviary
         */
        public void addAviary(Aviary aviary) throws IllegalStateException {
            if (aviary == null) {
                throw new IllegalArgumentException("Argument cannot be null");
            }
            if (aviaries.size() >= 20) {
                throw new IllegalStateException("Already has 20 aviaries!");
            }
            aviaries.add(aviary);
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
         * @param bird   target bird
         * @param aviary target aviary
         */
        public void assignBirdToAviary(Bird bird) {
            boolean isBirdAssigned = false;
            for (Aviary aviary : aviaries) {
                if (aviary.birds.length < Aviary.MAX_CAPACITY && aviary.type == bird) {
                    aviary.addBird(bird);
                    isBirdAssigned = true;
                    break;
                }
            }


            if (isBirdAssigned == false) {
                if (aviaries.size() < MAX_AVIARIES) {
                    Aviary newAviary = new Aviary();
                    newAviary.addBird(bird);
                    isBirdAssigned = true;
                } else {
                    if (checkIfAnyAviaryHasSpace()) {
                        throw new IllegalArgumentException("Conflicting birds but no new avary! Can't rescue");
                    } else {
                        throw new IllegalStateException("All Avaries full capacity! Can't rescue");
                    }
                }

            }
        }

        private boolean checkIfAnyAviaryHasSpace(){
            boolean HasSpace = false;
            for (Aviary aviary : aviaries) {
                if (aviary.birds.length < Aviary.MAX_CAPACITY) {
                    HasSpace = true;
                    break;
                }
            }

            return HasSpace ;
        }


        /**
         * search bird by bird's id
         *
         * @param id target bird's id
         * @return aviary that the bird is in
         */
        public Aviary searchBird(Integer id) {
            if (id == null) {
                throw new IllegalArgumentException("Arguments cannot be null");
            }
            for (Aviary aviary : aviaries) {
                for (aviaries.bird.length < 5 && aviaries.type == bird) {
                    if (bird.getId().equals(id)) {
                        return aviary;
                    }
                }
            }
            return null;
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

        public void printAllBirdsInAlphaOrderAndTheirLocation(){
            HashMap<Bird, String> birdLocMap = new HashMap<>();
            for (Aviary aviary : aviaries) {
                for(Bird bird : aviary.birds)
                birdLocMap.put(bird, aviary.getLocation());
            }

            System.out.println("Bird listed in alpha order and their location");
            for(Bird bird : birdLocMap.keySet()){
                System.out.println(bird.getName() + " : " + birdLocMap.get(bird));
            }
        }

        /**
         * print all signs of all the aviaries
         */
        public void printSignOfAviary(Aviary aviary) {
            if(aviary != null){
                System.out.println(aviary.getSign());
            }
        }
}
