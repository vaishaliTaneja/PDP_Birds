package enums;

public enum WaterSource {
    WETLANDS("wetlands"),
    FRESHWATER_SHORELANDS("freshwater shorelands"),
    SALTWATER_SHORELANDS("saltwater shorelands"),
    FRESHWATER_LAKE("freshwater lake")
    ;
    private String name;
    WaterSource(String name) {
        this.name = name;
    }
}
