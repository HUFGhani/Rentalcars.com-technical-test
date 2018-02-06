package io.github.hufghani.service;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VehicleServiceTest {

    private VehicleService vehicleService;
    private List<VehicleList> vehicleLists;

    @Before
    public void setUp() {
        vehicleLists = new ArrayList<>();
        VehicleList vehicle1 = new VehicleList();
        vehicle1.setName("Vehicle 1");
        vehicle1.setPrice(100.0);
        vehicle1.setRating(10.0);
        vehicle1.setSipp("MBMN");
        vehicle1.setSupplier("Supplier 1");

        VehicleList vehicle2 = new VehicleList();
        vehicle2.setName("Vehicle 2");
        vehicle2.setPrice(90.0);
        vehicle2.setRating(9.0);
        vehicle2.setSipp("ECAR");
        vehicle2.setSupplier("Supplier 1");

        VehicleList vehicle3 = new VehicleList();
        vehicle3.setName("Vehicle 3");
        vehicle3.setPrice(80.0);
        vehicle3.setRating(8.0);
        vehicle3.setSipp("CDMN");
        vehicle3.setSupplier("Supplier 1");

        VehicleList vehicle4 = new VehicleList();
        vehicle4.setName("Vehicle 4");
        vehicle4.setPrice(110.0);
        vehicle4.setRating(11.0);
        vehicle4.setSipp("IWAR");
        vehicle4.setSupplier("Supplier 1");

        VehicleList vehicle5 = new VehicleList();
        vehicle5.setName("Vehicle 5");
        vehicle5.setPrice(70.0);
        vehicle5.setRating(7.0);
        vehicle5.setSipp("STMN");
        vehicle5.setSupplier("Supplier 2");

        VehicleList vehicle6 = new VehicleList();
        vehicle6.setName("Vehicle 6");
        vehicle6.setPrice(60.0);
        vehicle6.setRating(6.0);
        vehicle6.setSipp("FFAR");
        vehicle6.setSupplier("Supplier 2");

        VehicleList vehicle7 = new VehicleList();
        vehicle7.setName("Vehicle 7");
        vehicle7.setPrice(90.0);
        vehicle7.setRating(9.0);
        vehicle7.setSipp("PPMN");
        vehicle7.setSupplier("Supplier 2");

        VehicleList vehicle8 = new VehicleList();
        vehicle8.setName("Vehicle 8");
        vehicle8.setPrice(80.0);
        vehicle8.setRating(8.0);
        vehicle8.setSipp("LVAR");
        vehicle8.setSupplier("Supplier 3");

        VehicleList vehicle9 = new VehicleList();
        vehicle9.setName("Vehicle 9");
        vehicle9.setPrice(90.0);
        vehicle9.setRating(9.0);
        vehicle9.setSipp("XBMN");
        vehicle9.setSupplier("Supplier 3");

        VehicleList vehicle10 = new VehicleList();
        vehicle10.setName("Vehicle 10");
        vehicle10.setPrice(800.0);
        vehicle10.setRating(80.0);
        vehicle10.setSipp("CDMN");
        vehicle10.setSupplier("Supplier 3");

        vehicleLists.add(vehicle1);
        vehicleLists.add(vehicle2);
        vehicleLists.add(vehicle3);
        vehicleLists.add(vehicle4);
        vehicleLists.add(vehicle5);
        vehicleLists.add(vehicle6);
        vehicleLists.add(vehicle7);
        vehicleLists.add(vehicle8);
        vehicleLists.add(vehicle9);
        vehicleLists.add(vehicle10);

        vehicleService = new VehicleService() {
            public List<VehicleList> getAllVehicles() {
                return vehicleLists;
            }
        };
    }
    @Test
    public void testGetAllVehicles() {
        List <VehicleList> vehicle = vehicleService.getAllVehicles();
        assertNotNull(vehicle);
        assertTrue(vehicle.size() == 10);
    }


    @Test
    public void testVehiclePriceOrder() {
        List <VehicleList> vehicle = vehicleService.vehiclePriceOrder();
        assertNotNull(vehicle);
        assertEquals(this.vehicleLists.size(), vehicle.size());
        Double price = vehicle.get(0).getPrice();
        for (VehicleList v : vehicle) {
            if (v.getPrice() < price) {
                assertTrue(false);
            } else {
                price = v.getPrice();
            }
        }
    }


    @Test
    public void testVehicleSpecification() {
        List<VehicleSpecification> vehicleSpecifications = this.vehicleService.vehicleSpecification();
        assertNotNull(vehicleSpecifications);
        assertEquals(this.vehicleLists.size(), vehicleSpecifications.size());
        VehicleSpecification vehicleSpecification = vehicleSpecifications.get(0);
        assertEquals("Mini", vehicleSpecification.getCarType());
        assertEquals("2 doors", vehicleSpecification.getDoors());
        assertEquals("Manual", vehicleSpecification.getTransmission());
        assertEquals("Petrol", vehicleSpecification.getFuel());
        assertEquals("no AC", vehicleSpecification.getAc());

        vehicleSpecification = vehicleSpecifications.get(1);
        assertEquals("Economy", vehicleSpecification.getCarType());
        assertEquals("4 doors", vehicleSpecification.getDoors());
        assertEquals("Automatic", vehicleSpecification.getTransmission());
        assertEquals("Petrol", vehicleSpecification.getFuel());
        assertEquals("AC", vehicleSpecification.getAc());

        vehicleSpecification = vehicleSpecifications.get(2);
        assertEquals("Compact", vehicleSpecification.getCarType());
        assertEquals("5 doors", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(3);
        assertEquals("Intermediate", vehicleSpecification.getCarType());
        assertEquals("Estate", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(4);
        assertEquals("Standard", vehicleSpecification.getCarType());
        assertEquals("Convertible", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(5);
        assertEquals("Full size", vehicleSpecification.getCarType());
        assertEquals("SUV", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(6);
        assertEquals("Premium", vehicleSpecification.getCarType());
        assertEquals("Pick up", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(7);
        assertEquals("Luxury", vehicleSpecification.getCarType());
        assertEquals("Passenger Van", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(8);
        assertEquals("Special", vehicleSpecification.getCarType());

    }

    @Test
    public void testSupplierRatingPerCarType() {
        List<VehicleSpecification> vehicleSpecifications = this.vehicleService.supplierRatingPerCarType();
        assertNotNull(vehicleSpecifications);
        assertEquals(this.vehicleLists.size() -1, vehicleSpecifications.size());
        for(VehicleSpecification vehicleSpecification: vehicleSpecifications){
            VehicleList vehicleList = vehicleSpecification.getVehicleList();
            if (vehicleList.getName().equals("Vehicle 3")){
                assertEquals(Double.valueOf(80.0), vehicleList.getRating());
                assertEquals(Double.valueOf(800.0), vehicleList.getPrice());
                assertEquals("Supplier 3", vehicleList.getSupplier());
                break;
            }
        }
    }

    @Test
    public void testCalculateCombineScore() {
        List<VehicleList> vehicles = this.vehicleService.calculateCombineScore();
        assertNotNull(vehicles);
        assertEquals(vehicleLists.size(),vehicles.size());
        Double combinedScore = vehicles.get(0).getCombinedScore();
        for (VehicleList vehicle : vehicles) {
            assertNotNull(vehicle.getVehicleScore());
            if (vehicle.getVehicleScore() > combinedScore) {
                assertTrue(false);
            } else {
                combinedScore = vehicle.getPrice();
            }

            if ("Car 1".equals(vehicle.getName())) {
                assertEquals(Integer.valueOf(1), vehicle.getVehicleScore());
                assertEquals(Integer.valueOf(11), vehicle.getCombinedScore());
            }

            if ("Car 2".equals(vehicle.getName())) {
                assertEquals(Integer.valueOf(7),vehicle.getVehicleScore());
                assertEquals(Integer.valueOf(16), vehicle.getCombinedScore());
            }
        }

    }
}