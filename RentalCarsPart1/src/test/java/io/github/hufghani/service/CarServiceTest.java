package io.github.hufghani.service;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CarServiceTest {

    private CarService carService;
    private List<VehicleList> vehicleLists;

    @Before
    public void setUp() {
        vehicleLists = new ArrayList<VehicleList>();
        VehicleList vehicle1 = new VehicleList();
        vehicle1.setName("Vehicle 1");
        vehicle1.setPrice(Double.valueOf(100.0));
        vehicle1.setRating(Double.valueOf(10.0));
        vehicle1.setSipp("MBMN");
        vehicle1.setSupplier("Suplier 1");

        VehicleList vehicle2 = new VehicleList();
        vehicle2.setName("Vehicle 2");
        vehicle2.setPrice(Double.valueOf(90.0));
        vehicle2.setRating(Double.valueOf(9.0));
        vehicle2.setSipp("ECAR");
        vehicle2.setSupplier("Suplier 1");

        VehicleList vehicle3 = new VehicleList();
        vehicle3.setName("Vehicle 3");
        vehicle3.setPrice(Double.valueOf(80.0));
        vehicle3.setRating(Double.valueOf(8.0));
        vehicle3.setSipp("CDMN");
        vehicle3.setSupplier("Suplier 1");

        VehicleList vehicle4 = new VehicleList();
        vehicle4.setName("Vehicle 4");
        vehicle4.setPrice(Double.valueOf(110.0));
        vehicle4.setRating(Double.valueOf(11.0));
        vehicle4.setSipp("IWAR");
        vehicle4.setSupplier("Suplier 1");

        VehicleList vehicle5 = new VehicleList();
        vehicle5.setName("Vehicle 5");
        vehicle5.setPrice(Double.valueOf(70.0));
        vehicle5.setRating(Double.valueOf(7.0));
        vehicle5.setSipp("STMN");
        vehicle5.setSupplier("Suplier 2");

        VehicleList vehicle6 = new VehicleList();
        vehicle6.setName("Vehicle 6");
        vehicle6.setPrice(Double.valueOf(60.0));
        vehicle6.setRating(Double.valueOf(6.0));
        vehicle6.setSipp("FFAR");
        vehicle6.setSupplier("Suplier 2");

        VehicleList vehicle7 = new VehicleList();
        vehicle7.setName("Vehicle 7");
        vehicle7.setPrice(Double.valueOf(90.0));
        vehicle7.setRating(Double.valueOf(9.0));
        vehicle7.setSipp("PPMN");
        vehicle7.setSupplier("Suplier 2");

        VehicleList vehicle8 = new VehicleList();
        vehicle8.setName("Vehicle 8");
        vehicle8.setPrice(Double.valueOf(80.0));
        vehicle8.setRating(Double.valueOf(8.0));
        vehicle8.setSipp("LVAR");
        vehicle8.setSupplier("Suplier 3");

        VehicleList vehicle9 = new VehicleList();
        vehicle9.setName("Vehicle 9");
        vehicle9.setPrice(Double.valueOf(90.0));
        vehicle9.setRating(Double.valueOf(9.0));
        vehicle9.setSipp("XBMN");
        vehicle9.setSupplier("Suplier 3");

        VehicleList vehicle10 = new VehicleList();
        vehicle10.setName("Vehicle 10");
        vehicle10.setPrice(Double.valueOf(800.0));
        vehicle10.setRating(Double.valueOf(80.0));
        vehicle10.setSipp("CDMN");
        vehicle10.setSupplier("Suplier 3");

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

        this.carService = new CarService() {
            public List<VehicleList> getAllVehicles() {
                return vehicleLists;
            }
        };
    }
    @Test
    public void testGetAllVehicles() {
        List <VehicleList> vehicle = carService.getAllVehicles();
        Assert.assertNotNull(vehicle);
        Assert.assertTrue(vehicle.size() == 10);
        System.out.println(vehicle);
    }


    @Test
    public void testVehiclePriceOrder() {
        List <VehicleList> vehicle = carService.vehiclePriceOrder();
        Assert.assertNotNull(vehicle);
        Assert.assertEquals(this.vehicleLists.size(), vehicle.size());
        Double price = Double.valueOf(vehicle.get(0).getPrice());
        for (VehicleList v : vehicle) {
            if (v.getPrice() < price) {
                Assert.assertTrue(false);
            } else {
                price = v.getPrice();
            }
        }
    }


    @Test
    public void testVehicleSpecification() {
        List<VehicleSpecification> vehicleSpecifications = this.carService.vehicleSpecification();
        Assert.assertNotNull(vehicleSpecifications);
        Assert.assertEquals(this.vehicleLists.size(), vehicleSpecifications.size());
        VehicleSpecification vehicleSpecification = vehicleSpecifications.get(0);
        Assert.assertEquals("Mini", vehicleSpecification.getCarType());
        Assert.assertEquals("2 doors", vehicleSpecification.getDoors());
        Assert.assertEquals("Manual", vehicleSpecification.getTransmission());
        Assert.assertEquals("Petrol", vehicleSpecification.getFuel());
        Assert.assertEquals("no AC", vehicleSpecification.getAc());

        vehicleSpecification = vehicleSpecifications.get(1);
        Assert.assertEquals("Economy", vehicleSpecification.getCarType());
        Assert.assertEquals("4 doors", vehicleSpecification.getDoors());
        Assert.assertEquals("Automatic", vehicleSpecification.getTransmission());
        Assert.assertEquals("Petrol", vehicleSpecification.getFuel());
        Assert.assertEquals("AC", vehicleSpecification.getAc());

        vehicleSpecification = vehicleSpecifications.get(2);
        Assert.assertEquals("Compact", vehicleSpecification.getCarType());
        Assert.assertEquals("5 doors", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(3);
        Assert.assertEquals("Intermediate", vehicleSpecification.getCarType());
        Assert.assertEquals("Estate", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(4);
        Assert.assertEquals("Standard", vehicleSpecification.getCarType());
        Assert.assertEquals("Convertible", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(5);
        Assert.assertEquals("Full size", vehicleSpecification.getCarType());
        Assert.assertEquals("SUV", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(6);
        Assert.assertEquals("Premium", vehicleSpecification.getCarType());
        Assert.assertEquals("Pick up", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(7);
        Assert.assertEquals("Luxury", vehicleSpecification.getCarType());
        Assert.assertEquals("Passenger Van", vehicleSpecification.getDoors());

        vehicleSpecification = vehicleSpecifications.get(8);
        Assert.assertEquals("Special", vehicleSpecification.getCarType());

    }

    @Test
    public void testSupplierRatingPerCarType() {
        List<VehicleSpecification> vehicleSpecifications = this.carService.supplierRatingPerCarType();
        Assert.assertNotNull(vehicleSpecifications);
        Assert.assertEquals(this.vehicleLists.size(), vehicleSpecifications.size());
        for(VehicleSpecification vehicleSpecification: vehicleSpecifications){
            VehicleList vehicleList = vehicleSpecification.getVehicleList();
            if (vehicleList.equals("Vehicle 3")){
                Assert.assertEquals(java.util.Optional.of(Double.valueOf(80.0)), vehicleList.getRating());
                Assert.assertEquals(java.util.Optional.of(Double.valueOf(800.0)), vehicleList.getPrice());
                Assert.assertEquals("Suplier3", vehicleList.getSupplier());
                break;
            }
        }
    }
}