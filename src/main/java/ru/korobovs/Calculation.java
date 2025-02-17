package ru.korobovs;

public class Calculation {

    public static final int MIN_COST = 400;

    public static int getCostDistance(int distance) {
        if (distance < 1) {
            throw new RuntimeException("Расстояние должно быть больше 0");
        }
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
        if (fragile && distance > 30) {
            throw new RuntimeException("Хрупкие грузы нельзя возить на расстояние более 30 км");
        } else if (fragile) {
            return 300;
        }
        return 0;
    }

    public static int getCostWithCriteria(Cargo cargo) {
        return getCostDistance(cargo.getDistance())
                + getCostBig(cargo.isBig())
                + getCostFragile(cargo.isFragile(), cargo.getDistance());
    }

    public static double calculation(Cargo cargo, double workload) {
        double summa = getCostWithCriteria(cargo) * workload;

        if (summa > MIN_COST) {
            return summa ;
        }
        return MIN_COST;
    }
}
