import Builders.AddressBuilder;
import Builders.CarBuilder;
import Models.Car;
import Models.Color;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class FilterCarsTest {
    String KIA = "KIA";
    
    Car kia = new CarBuilder().with($ -> {
        $.make = KIA;
        $.model = "Sportage";
        $.color = Color.WHITE;
        $.registrationDate = LocalDateTime.now();
    }).with($ -> {
        $.ownersAddress = new AddressBuilder().with($_ownersAddress -> {
            $_ownersAddress.city = "Chelmsford";
            $_ownersAddress.country = "UK";
            $_ownersAddress.firstLine = "123 Agent Street";
        }).createAddress();
    }).createCar();

    Car kia2 = new CarBuilder().with($ -> {
        $.make = KIA;
        $.model = "Niro";
        $.color = Color.RED;
        $.registrationDate = LocalDateTime.now();
    }).with($ -> {
        $.ownersAddress = new AddressBuilder().with($_ownersAddress -> {
            $_ownersAddress.city = "Braintree";
            $_ownersAddress.country = "UK";
            $_ownersAddress.firstLine = "123 Agent Street";
        }).createAddress();
    }).createCar();

    Car fiat = new CarBuilder().with($ -> {
        $.make = "FIAT";
        $.model = "500";
        $.color = Color.WHITE;
        $.registrationDate = LocalDateTime.now();
    }).with($ -> {
        $.ownersAddress = new AddressBuilder().with($_ownersAddress -> {
            $_ownersAddress.city = "Chelmsford";
            $_ownersAddress.country = "UK";
            $_ownersAddress.firstLine = "456 Liverpool Street";
        }).createAddress();
    }).createCar();

    Car mg = new CarBuilder().with($ -> {
        $.make = "MG";
        $.model = "ZS EV";
        $.color = Color.BLUE;
        $.registrationDate = LocalDateTime.now();
    }).createCar();

    Car tesla = new CarBuilder().with($ -> {
        $.make = "TESLA";
        $.model = "Series S";
        $.color = Color.BLACK;
        $.registrationDate = LocalDateTime.now();
    }).with($ -> {
        $.ownersAddress = new AddressBuilder().with($_ownersAddress -> {
            $_ownersAddress.city = "Amsterdam";
            $_ownersAddress.country = "NL";
            $_ownersAddress.firstLine = "36 Ams St";
        }).createAddress();
    }).createCar();

    List<Car> carList = Arrays.asList(kia, kia2, fiat, mg, tesla);

    @Test
    public void noFilterShouldReturnAllCars() {
        assertEquals(carList.size(), FilterCars.filterCars(carList, null, null, null).size());
    }


    @Test
    public void kiaAndTeslafiltersShouldReturnOnlyKiaAndTeslaCars() {
        List<String> carFilters = Arrays.asList("KIA", "TESLA");
        int expected = carList.stream().filter(car -> car.getMake().equals("KIA") || car.getMake().equals("TESLA")).collect(Collectors.toList()).size();
        int actual = FilterCars.filterCars(carList, carFilters, null, null).size();
        assertEquals(expected, actual);
    }

    @Test
    public void sportageFiltersShouldReturnOnlySportage() {
        List<String> modelFilters = Arrays.asList("Sportage", "ZS EV");
        int expected = carList.stream().filter(car -> car.getModel().equals("Sportage") || car.getModel().equals("ZS EV")).collect(Collectors.toList()).size();
        int actual = FilterCars.filterCars(carList, null, modelFilters, null).size();
        assertEquals(expected, actual);
    }


    @Test
    public void blackAndWhiteColorFiltersShouldReturnOnlyBlacnAndWhiteCars() {
        List<Color> colorFilters = Arrays.asList(Color.WHITE, Color.BLACK);
        int expected = carList.stream().filter(car -> car.getColor() == Color.WHITE || car.getColor() == Color.BLACK ).collect(Collectors.toList()).size();
        int actual = FilterCars.filterCars(carList, null, null, colorFilters).size();
        assertEquals(expected, actual);
    }
}