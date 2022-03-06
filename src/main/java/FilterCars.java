import Models.Car;
import Models.CarFilter;

import java.util.List;
import java.util.stream.Collectors;

import static Models.CarFilter.makeFilter;

public class FilterCars {

    public static List<Car> filterCars(List<Car> carList, List<String> make) {
        List<Car> filteredList = carList.stream().filter(makeFilter(make)).collect(Collectors.toList());
        return filteredList;
    }
}
