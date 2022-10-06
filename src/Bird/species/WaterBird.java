package Bird.species;

import enums.WaterSource;

import java.util.Set;

public interface WaterBird {


    /**
     * get water sources that this bird live near
     */
    public Set<WaterSource> getWaterSources();

    /**
     * set water sources
     */
    public void setWaterSources(Set<WaterSource> waterSources);

    /**
     * add one water source to water sources
     */
    public void addWaterSource(WaterSource waterSource);

    /**
     * remove one water source from water sources
     */
    public void removeWaterSource(WaterSource waterSource);
}
