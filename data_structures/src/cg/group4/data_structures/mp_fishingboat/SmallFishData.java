package cg.group4.data_structures.mp_fishingboat;

import java.io.Serializable;
import java.util.Random;

public class SmallFishData implements Serializable {

    protected final double fishSizeX = 64 / 1440d;
    protected final double fishSizeY = 64 / 2560d;
    protected Coordinate cPosition, cDestination;
    protected float cSpeed = 0.002f;

    public SmallFishData() {
        cPosition = generatePosition();
        cDestination = generatePosition();
    }

    public Coordinate generatePosition() {
        Random rng = new Random();
        return new Coordinate(rng.nextFloat(), rng.nextFloat());
    }

    public Coordinate getPosition() {
        return cPosition;
    }

    public void setPosition(Coordinate position) {
        cPosition = position;
    }

    public Coordinate getDestination() {
        return cDestination;
    }

    public void setDestination(Coordinate destination) {
        cDestination = destination;
    }

    public boolean destinationReached() {
        boolean xCheck = cDestination.getX() <= cPosition.getX() + fishSizeX && cDestination.getX() >= cPosition.getX();
        boolean yCheck = cDestination.getY() <= cPosition.getY() + fishSizeY && cDestination.getY() >= cPosition.getY();
        return xCheck && yCheck;
    }

    public void move() {
        float diffX = cDestination.getX() - getCenterX();
        float diffY = cDestination.getY() - getCenterY();

        float newX = cPosition.getX() + cSpeed * Math.signum(diffX);
        float newY = cPosition.getY() + cSpeed * Math.signum(diffY);

        cPosition.setX(newX);
        cPosition.setY(newY);
    }

    public float getCenterX() {
        return cPosition.getX() + (float) fishSizeX / 2;
    }

    public float getCenterY() {
        return cPosition.getY() + (float) fishSizeY / 2;
    }

    public boolean intersects(double xMin, double xMax, double yMin, double yMax) {
        double fishXMin = cPosition.getX();
        double fishYMin = cPosition.getY();
        double fishXMax = fishXMin + fishSizeX;
        double fishYMax = fishYMin + fishSizeY;

        double x_overlap = Math.max(0, Math.min(xMax, fishXMax) - Math.max(xMin, fishXMin));
        double y_overlap = Math.max(0, Math.min(yMax, fishYMax) - Math.max(yMin, fishYMin));

        return (x_overlap * y_overlap) > 0d;
    }

}
