import java.util.Set;

public abstract class Bird extends Animal {
    private String typeOfBird;
    private String typeCharacteristic;
    private Boolean hasWings;
    private static String generalCharacteristic = "warm-blooded, bipedal, vertebrate";

    public Bird(String typeOfBird, String typeCharacteristic, Boolean isExtinct, Boolean hasWings, Boolean isMammal, String name, Set<String> preferredFoods) {
        super(name, isExtinct, isMammal, preferredFoods);
        this.typeOfBird = typeOfBird;
        this.typeCharacteristic = typeCharacteristic;
        this.hasWings = hasWings;
    }

    public String getTypeOfBird() {
        return typeOfBird;
    }
    public  String getNameWithType() {
        return  this.getName() + "(" + getTypeOfBird() + ")";
    }
    protected void setTypeOfBird(String typeOfBird) {
        this.typeOfBird = typeOfBird;
    }

    public void setCharacteristic(String typeCharacteristic) {
        this.typeCharacteristic = typeCharacteristic;
    }

    public String getCharacteristic() {
        return this.typeCharacteristic;
    }


    public Boolean getHasWings() {
        return hasWings;
    }


    public void setHasWings(Boolean hasWings) {
        this.hasWings = hasWings;
    }


    public abstract String toString();
}
