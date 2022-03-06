import Models.Car;

import java.util.List;
import java.util.stream.Collectors;

public class FilterCars {

    public static List<Car> filterCars(List<Car> carList, List<String> make) {
        List<Car> filteredList = carList.stream().filter(car -> make == null || make.contains(car.getMake())).collect(Collectors.toList());
        return filteredList;
    }
}
