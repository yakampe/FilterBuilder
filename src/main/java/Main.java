import Builders.CarBuilder;
import Models.Car;
import Models.Color;

import java.time.LocalDateTime;

public class Main {
    public static void main(String args[]) {
        Car kia = new CarBuilder().with($ -> {
            $.make = "Kia";
            $.model = "Sportage";
            $.color = Color.WHITE;
            $.registrationDate = LocalDateTime.now();
        }).createCar();

        

        System.out.println(kia);
    }
}
