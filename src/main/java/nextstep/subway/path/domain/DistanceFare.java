package nextstep.subway.path.domain;

public enum DistanceFare {

    DISTANCE_10_TO_50(10, 5),
    DISTANCE_OVER_50(50, 8);

    private static final int BASIC_FARE = 1250;
    private static final int EXTRA_FARE = 100;

    private final int minDistance;
    private final int extraDistanceUnit;

    DistanceFare(int minDistance, int extraDistanceUnit) {
        this.minDistance = minDistance;
        this.extraDistanceUnit = extraDistanceUnit;
    }

    public static int calculateDistanceFare(int distance) {
        int fare = BASIC_FARE;

        if (DISTANCE_OVER_50.greaterThan(distance)) {
            fare += DISTANCE_OVER_50.calculateExtraFare(distance - DISTANCE_OVER_50.minDistance);
            distance = DISTANCE_OVER_50.minDistance;
        }

        if (DISTANCE_10_TO_50.greaterThan(distance)) {
            fare += DISTANCE_10_TO_50.calculateExtraFare(distance - DISTANCE_10_TO_50.minDistance);
        }
        return fare;
    }

    private boolean greaterThan(int distance) {
        return distance > minDistance;
    }

    private int calculateExtraFare(int distance) {
        return (int) ((Math.ceil((distance - 1) / extraDistanceUnit) + 1) * EXTRA_FARE);
    }

}