package Builders;

import Models.Address;
import Models.Car;
import Models.Color;

import java.time.LocalDateTime;
import java.util.function.Consumer;

public class CarBuilder {
    public String make;
    public String model;
    public LocalDateTime registrationDate;
    public Color color;
    public Address ownersAddress;

    public CarBuilder with(Consumer<CarBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Car createCar() {
        return new Car(make, model, registrationDate, color, ownersAddress);
    }
}
