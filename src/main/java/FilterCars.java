import Models.Car;
import Models.Color;
import java.util.List;
import java.util.stream.Collectors;

import static Models.CarFilter.*;

public class FilterCars {

    public static List<Car> filterCars(List<Car> carList, List<String> make, List<String> model, List<Color> color) {
        List<Car> filteredList = carList.stream()
                .filter(makeFilter(make)
                        .and(modelFilter(model))
                        .and(colorFilter(color)))
                .collect(Collectors.toList());
        return filteredList;
    }
}
