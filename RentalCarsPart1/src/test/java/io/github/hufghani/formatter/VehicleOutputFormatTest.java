package io.github.hufghani.formatter;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class VehicleOutputFormatTest {
    private final static String LINE_SEPARATOR = System.lineSeparator();
    private List<VehicleList> vehicles;
    private List<VehicleSpecification> vehicleSpecifications;
    private VehicleOutputFormat vehicleOutputFormat;

    @Before
    public void setUp() throws Exception {
        VehicleList vehicle = new VehicleList();
        vehicle.setName("Vehicle 1");
        vehicle.setPrice(100.0);
        vehicle.setRating(10.0);
        vehicle.setSipp("MBMN");
        vehicle.setSupplier("Supplier 1");
        vehicle.setScore(11.0);

        vehicles = new ArrayList<>();
        vehicles.add(vehicle);

        VehicleSpecification vehicleSpecification = new VehicleSpecification();
        vehicleSpecification.setAc("no AC");
        vehicleSpecification.setVehicleList(vehicle);
        vehicleSpecification.setCarType("Mini");
        vehicleSpecification.setDoors("2 doors");
        vehicleSpecification.setFuel("Petrol");
        vehicleSpecification.setTransmission("Manual");

        vehicleSpecifications = new ArrayList<>();
        this.vehicleSpecifications.add(vehicleSpecification);

        this.vehicleOutputFormat = new VehicleOutputFormat();
    }


    @Test
    public void testFormatPriceOrder() {
        String output = vehicleOutputFormat.formatPriceOrder(vehicles);
        Assert.assertEquals("1. Car 1 - 100,00" + LINE_SEPARATOR,output);
    }
}