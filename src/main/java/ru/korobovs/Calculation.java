package ru.korobovs;

public class Calculation {

    public static final int MIN_COST = 400;

    public static int getCostDistance(int distance) {
        if (distance <= 2) {
            return 50;
        } else if (distance <= 10) {
            return 100;
        } else if (distance <= 30) {
            return 200;
        }
        return 300;
    }

    public static int getCostBig(boolean big) {
        if (big) {
            return 200;
        }
        return 100;
    }

    public static int getCostFragile(boolean fragile, int distance) {
        if (fragile && distance <= 30) {
            return 300;
        } else if (!fragile) {
            return 0;
        }
        return 1000000;
    }

    public static double calculation(Cargo cargo, double workload) {
        return (getCostDistance(cargo.getDistance())
                + getCostBig(cargo.isBig())
                + getCostFragile(cargo.isFragile(), cargo.getDistance())
        ) * workload + MIN_COST;
    }
}
