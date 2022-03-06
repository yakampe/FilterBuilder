import Builders.AddressBuilder;
import Builders.CarBuilder;
import Models.Car;
import Models.Color;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        Car kia = new CarBuilder().with($ -> {
            $.make = "KIA";
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

        List<Car> carList = Arrays.asList(kia, fiat, mg);

        carList.forEach(car -> {
            System.out.println(car);
        });

    }
}
