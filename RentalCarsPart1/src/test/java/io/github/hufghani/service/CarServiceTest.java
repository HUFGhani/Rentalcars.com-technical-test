package io.github.hufghani.service;

import io.github.hufghani.model.VehicleList;
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
    public void getAllVehicles() {
        List <VehicleList> vehicle = carService.getAllVehicles();
        Assert.assertNotNull(vehicle);
        Assert.assertTrue(vehicle.size() == 10);
        System.out.println(vehicle);
    }


    @Test
    public void vehiclePriceOrder() {
        List <VehicleList> vehicle = carService.vehiclePriceOrder();
        System.out.println(vehicle);
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
}