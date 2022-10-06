package Animal;

import java.util.Set;

public class Animal {

    private Boolean isExtinct;
    private Boolean isMammal;

    private Set<String> preferredFoods;

    private String name;

    public Animal (String name, Boolean isExtinct, Boolean isMammal, Set<String> preferredFoods) {
        if (name == null) {
            throw new IllegalArgumentException("Bird.Bird should have a name identifier");
        }
        this.name = name;
        this.isExtinct = isExtinct;
        this.isMammal = isMammal;
        this.preferredFoods = preferredFoods;
    }
    public  String getName() {
        return  this.name;
    }
    public  void setName(String name) { this.name = name;}
    public Boolean getIsExtinct() {
        return isExtinct;
    }

    public void setIsExtinct(Boolean isExtinct) {
        this.isExtinct = isExtinct;
    }

    public Boolean getIsMammal() {
        return isMammal;
    }

    public void setIsMammal(Boolean isMammal) {
        this.isMammal = isMammal;
    }

    public Set<String> getPreferredFoods() {
        return preferredFoods;
    }

    public void setPreferredFoods(Set<String> preferredFoods) {
        this.preferredFoods = preferredFoods;
    }

    public Animal(Boolean isExtinct, Boolean isMammal, Set<String> preferredFoods) {
        this.isMammal = isMammal;
        this.isExtinct = isExtinct;
        this.preferredFoods = preferredFoods;
    }
}
