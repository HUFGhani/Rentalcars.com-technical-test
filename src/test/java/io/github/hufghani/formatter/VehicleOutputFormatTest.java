package io.github.hufghani.formatter;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class VehicleOutputFormatTest {
    private final static String LINE_SEPARATOR = System.lineSeparator();
    private List<VehicleList> vehicles;
    private List<VehicleSpecification> vehicleSpecifications;
    private VehicleOutputFormat vehicleOutputFormat;

    @Before
    public void setUp() throws Exception {
        VehicleList vehicle1 = new VehicleList();
        vehicle1.setName("Vehicle 1");
        vehicle1.setPrice(100.0);
        vehicle1.setRating(10.0);
        vehicle1.setSipp("MBMN");
        vehicle1.setSupplier("Supplier 1");
        vehicle1.setCombinedScore(11.0);
        vehicle1.setVehicleScore(1);
        VehicleSpecification vehicleSpecification1 = new VehicleSpecification();
        vehicleSpecification1.setAc("no AC");
        vehicleSpecification1.setVehicleList(vehicle1);
        vehicleSpecification1.setCarType("Mini");
        vehicleSpecification1.setDoors("2 doors");
        vehicleSpecification1.setFuel("Petrol");
        vehicleSpecification1.setTransmission("Manual");

        VehicleList vehicle2 = new VehicleList();
        vehicle2.setName("Vehicle 2");
        vehicle2.setPrice(600.0);
        vehicle2.setRating(10.0);
        vehicle2.setSipp("MBMR");
        vehicle2.setSupplier("Supplier 4");
        vehicle2.setCombinedScore(11.0);
        vehicle2.setVehicleScore(1);
        VehicleSpecification vehicleSpecification2 = new VehicleSpecification();
        vehicleSpecification2.setAc("AC");
        vehicleSpecification2.setVehicleList(vehicle2);
        vehicleSpecification2.setCarType("Mini");
        vehicleSpecification2.setDoors("2 doors");
        vehicleSpecification2.setFuel("Petrol");
        vehicleSpecification2.setTransmission("Manual");


        vehicles = new ArrayList<>();
        vehicleSpecifications = new ArrayList<>();
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        vehicleSpecifications.add(vehicleSpecification1);
        vehicleSpecifications.add(vehicleSpecification2);
        vehicleOutputFormat = new VehicleOutputFormat();
    }


    @Test
    public void testFormatPriceOrder() {
        String output = vehicleOutputFormat.formatPriceOrder(vehicles);
        assertEquals("1. Vehicle 1 - 100.00" + LINE_SEPARATOR +"2. Vehicle 2 - 600.00"+LINE_SEPARATOR,output);
    }

    @Test(expected=NullPointerException.class)
    public void testFormatPriceOrderNPE() {
        String output = vehicleOutputFormat.formatPriceOrder(null);
        assertEquals(null,output);
    }

    @Test
    public void testFormatPriceOrderEmpty() {
        String output = vehicleOutputFormat.formatPriceOrder(Collections.emptyList());
        assertEquals("",output);
    }

    @Test
    public void testFormatVehicleSpecification() {
        String output = vehicleOutputFormat.formatVehicleSpecification(vehicleSpecifications);
        assertEquals("1. Vehicle 1 - MBMN - Mini - 2 doors - Manual - Petrol - no AC" + LINE_SEPARATOR +
        "2. Vehicle 2 - MBMR - Mini - 2 doors - Manual - Petrol - AC" + LINE_SEPARATOR , output);
    }

    @Test(expected=NullPointerException.class)
    public void testFormatVehicleSpecificationNPE() {
        String output = vehicleOutputFormat.formatVehicleSpecification(null);
        assertEquals(null, output);
    }

    @Test
    public void testFormatVehicleSpecificationEmpty() {
        String output = vehicleOutputFormat.formatVehicleSpecification(Collections.emptyList());
        assertEquals("", output);
    }

    @Test
    public void testFormatsupplierRatingPerCarType(){
        String result = vehicleOutputFormat.formatSupplierRatingPerCarType(vehicleSpecifications);
        assertEquals("1. Vehicle 1 - Mini - Supplier 1 - 10.0" + LINE_SEPARATOR +
                "2. Vehicle 2 - Mini - Supplier 4 - 10.0"+LINE_SEPARATOR, result);
    }

    @Test(expected=NullPointerException.class)
    public void testFormatsupplierRatingPerCarTypeNPE(){
        String result = vehicleOutputFormat.formatSupplierRatingPerCarType(null);
        assertEquals(null, result);
    }

    @Test
    public void testFormatsupplierRatingPerCarTypeEmpty(){
        String result = vehicleOutputFormat.formatSupplierRatingPerCarType(Collections.emptyList());
        assertEquals("", result);
    }

    @Test
    public void testFormatCalculateCombineScore() {
        String result = vehicleOutputFormat.formatCalculateCombineScore(vehicles);
        assertEquals("1. Vehicle 1 - 1 - 10.00 - 11.00" + LINE_SEPARATOR +
                "2. Vehicle 2 - 1 - 10.00 - 11.00" + LINE_SEPARATOR, result);
    }

    @Test(expected=NullPointerException.class)
    public void testFormatCalculateCombineScoreNPE() {
        String result = vehicleOutputFormat.formatCalculateCombineScore(null);
        assertEquals(null, result);
    }

    @Test
    public void testFormatCalculateCombineScoreEmpty() {
        String result = vehicleOutputFormat.formatCalculateCombineScore(Collections.emptyList());
        assertEquals("", result);
    }
}