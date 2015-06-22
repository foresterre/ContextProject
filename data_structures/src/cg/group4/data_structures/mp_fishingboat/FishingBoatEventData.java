package cg.group4.data_structures.mp_fishingboat;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Data for the fishing boat event.
 */
public class FishingBoatEventData implements Serializable {

    /**
     * The amount of fish that the players need to catch.
     */
    protected final int cAmountOfFish = 10;
    /**
     * Data about the boat.
     */
    protected BoatData cBoatData;
    /**
     * Rotation of the crane in radians.
     */
    protected double cCraneRotation;
    /**
     * Hashmap containing the coordinates of all the smallfish.
     */
    protected HashMap<Integer, SmallFishData> cSmallFishCoordinates;

    /**
     * Constructs new FishingBoatEventData object.
     * Places the boat in the middle of the screen with a crane rotation of 0.
     */
    public FishingBoatEventData() {
        final float baseCoordinate = 0.5f;
        cBoatData = new BoatData(new Coordinate(baseCoordinate, baseCoordinate), 0);
        cCraneRotation = 0f;
        cSmallFishCoordinates = spawnFish();
    }

    /**
     * Creates the smallfish and stores them.
     *
     * @return HashMap<Integer, SmallFishData> containing all the newly made smallfish objects.
     */
    protected HashMap<Integer, SmallFishData> spawnFish() {
        HashMap<Integer, SmallFishData> fishes = new HashMap<Integer, SmallFishData>();
        for (int i = 0; i < cAmountOfFish; i++) {
            fishes.put(i, new SmallFishData());
        }
        return fishes;
    }

    /**
     * Returns the boat data.
     *
     * @return BoatData
     */
    public BoatData getcBoatData() {
        return cBoatData;
    }

    /**
     * Sets the boat data to the given boat data.
     *
     * @param boatData new boat data.
     */
    public void setcBoatData(BoatData boatData) {
        this.cBoatData = boatData;
    }

    /**
     * Returns the current crane rotation in radians.
     *
     * @return crane rotation in radians.
     */
    public double getcCraneRotation() {
        return cCraneRotation;
    }

    /**
     * Sets the crane rotation to the given rotation.
     *
     * @param craneRotation new rotation in radians.
     */
    public void setcCraneRotation(double craneRotation) {
        this.cCraneRotation = craneRotation;
    }

    /**
     * Returns the hashmap containing all the coordinates of the smallfish.
     *
     * @return HashMap<Integer, SmallFishData> containing the coordinates of the smallfish.
     */
    public HashMap<Integer, SmallFishData> getcSmallFishCoordinates() {
        return cSmallFishCoordinates;
    }

    /**
     * Replaces the coordinates of all the smallfish with the given coordinates.
     *
     * @param smallFishCoordinates new smallfish coordinates.
     */
    public void setcSmallFishCoordinates(HashMap<Integer, SmallFishData> smallFishCoordinates) {
        this.cSmallFishCoordinates = smallFishCoordinates;
    }
}