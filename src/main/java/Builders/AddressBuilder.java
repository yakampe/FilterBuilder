package Builders;

import Models.Address;

import java.util.function.Consumer;

public class AddressBuilder {
    public String firstLine;
    public String city;
    public String country;

    public AddressBuilder with(Consumer<AddressBuilder> builderFunction) {
        builderFunction.accept(this);
        return this;
    }

    public Address createAddress() {
        return new Address(firstLine, city, country);
    }
}
