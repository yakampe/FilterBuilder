import Models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterCars {

    public static List<Car> filterCars(List<Car> carList, String make, String model) {
        List<Car> filteredList = carList.stream().filter(car -> car.getMake().equals(make)).collect(Collectors.toList());
        return filteredList;
    }
}
