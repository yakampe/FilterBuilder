package Models;

import java.util.function.Predicate;

public class CarFilter {

    public static Predicate<Car> makePredicate(String make) {
        return car -> car.getMake().equals(make);
    }
}
