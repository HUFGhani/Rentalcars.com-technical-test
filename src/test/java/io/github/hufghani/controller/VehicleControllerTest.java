package io.github.hufghani.controller;

import io.github.hufghani.formatter.VehicleOutputFormat;
import io.github.hufghani.model.VehicleResponse;
import io.github.hufghani.service.VehicleService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class VehicleControllerTest {

    private VehicleController vehicleController;
    @Mock
    private VehicleService vehicleService;
    @Mock
    private VehicleOutputFormat vehicleOutputFormat;

    @Before
    public void setUp() throws Exception {

        vehicleController = new VehicleController();

        Mockito.reset(vehicleService,vehicleOutputFormat);

        try {
            ReflectionTestUtils.setField(vehicleController,"vehicleService",vehicleService,VehicleService.class);
            ReflectionTestUtils.setField(vehicleController,"vehicleOutputFormat",vehicleOutputFormat,VehicleOutputFormat.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testGetScore() {
        Mockito.when(vehicleOutputFormat.formatCalculateCombineScore(Mockito.anyList())).thenReturn("Test");

        ResponseEntity<VehicleResponse> result = vehicleController.getScore();

        Mockito.verify(vehicleService, Mockito.times(1)).calculateCombineScore();
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Test", result.getBody().getResult());
    }

    @Test
    public void testGetSupplierRatingPerCarType() {
        Mockito.when(vehicleOutputFormat.formatSupplierRatingPerCarType(Mockito.anyList())).thenReturn("Test");

        ResponseEntity<VehicleResponse> result = vehicleController.getSupplierRatingPerCarType();

        Mockito.verify(vehicleService, Mockito.times(1)).supplierRatingPerCarType();
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Test", result.getBody().getResult());
    }

    @Test
    public void testGetVehicleSpecification() {
        Mockito.when(vehicleOutputFormat.formatVehicleSpecification(Mockito.anyList())).thenReturn("Test");

        ResponseEntity<VehicleResponse> result = vehicleController.getVehicleSpecification();

        Mockito.verify(vehicleService, Mockito.times(1)).vehicleSpecification();
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Test", result.getBody().getResult());
    }

    @Test
    public void testGetVehiclePriceOrder() {
        Mockito.when(vehicleOutputFormat.formatPriceOrder(Mockito.anyList())).thenReturn("Test");

        ResponseEntity<VehicleResponse> result = vehicleController.getVehiclePriceOrder();

        Mockito.verify(vehicleService, Mockito.times(1)).vehiclePriceOrder();
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Test", result.getBody().getResult());
    }

    @Test
    public void testRoot(){
        ResponseEntity<String> result = vehicleController.root();
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("Available endpoints:<br/>/priceOrder <br/>/specificationBySipp <br/>/supplierRatingPerCarType <br/>/score</br>", result.getBody().toString());

    }
}