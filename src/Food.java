public enum Food {
    BERRIES("berries"),
    SEEDS("seeds"),
    FRUIT("fruit"),
    INSECTS("insects"),
    OTHER_BIRDS("other birds"),
    EGGS("eggs");

    private String name;

    Food(String name) {
        this.name = name;
    }
}
