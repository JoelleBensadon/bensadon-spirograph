package bensadon.spirograph;

import java.util.Objects;

public class SpirographModel {
    private double largeRadius;
    private double smallRadius;
    private double penDistance;
    private int numSteps;
    private double anglePerStep;

    public SpirographModel(double largeRadius,
                           double smallRadius,
                           double penDistance,
                           int numSteps,
                           double anglePerStep) {
        this.largeRadius = largeRadius;
        this.smallRadius = smallRadius;
        this.penDistance = penDistance;
        this.numSteps = numSteps;
        this.anglePerStep = anglePerStep;
    }

    public double getLargeRadius() {
        return largeRadius;
    }

    public double getSmallRadius() {
        return smallRadius;
    }

    public double getPenDistance() {
        return penDistance;
    }

    public int getNumSteps() {
        return numSteps;
    }

    public double getAnglePerStep() {
        return anglePerStep;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SpirographModel that = (SpirographModel) o;
        return Double.compare(largeRadius, that.largeRadius) == 0
                && Double.compare(smallRadius, that.smallRadius) == 0
                && Double.compare(penDistance, that.penDistance) == 0
                && numSteps == that.numSteps
                && Double.compare(anglePerStep, that.anglePerStep) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(largeRadius, smallRadius, penDistance, numSteps, anglePerStep);
    }
}