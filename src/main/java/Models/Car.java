package Models;

import java.time.LocalDateTime;

public class Car {
    String make;
    String model;
    LocalDateTime registrationDate;
    Color color;
    Address ownersAddress;

    public Car(String make, String model, LocalDateTime registrationDate, Color color, Address ownersAddress) {
        this.make = make;
        this.model = model;
        this.registrationDate = registrationDate;
        this.color = color;
        this.ownersAddress = ownersAddress;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Address getOwnersAddress() {
        return ownersAddress;
    }

    public void setOwnersAddress(Address ownersAddress) {
        this.ownersAddress = ownersAddress;
    }
}
