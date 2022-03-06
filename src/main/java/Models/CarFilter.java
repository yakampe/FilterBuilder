package Models;

import java.util.List;
import java.util.function.Predicate;

public class CarFilter {

    public static Predicate<Car> makeFilter(List<String> make) {
        return car -> make == null || make.contains(car.getMake());
    }

    public static Predicate<Car> modelFilter(List<String> model) {
        return car -> model == null || model.contains(car.getModel());
    }

    public static Predicate<Car> colorFilter(List<Color> color) {
        return car -> color == null || color.contains(car.getColor());
    }
}
