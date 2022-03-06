package Models;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CarFilter {

    public static Predicate<Car> makeFilter(List<String> make) {
        return car -> make == null || make.contains(car.getMake());
    }

}
