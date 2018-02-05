package io.github.hufghani.controller;

import io.github.hufghani.formatter.VehicleOutputFormat;
import io.github.hufghani.model.VehicleResponse;
import io.github.hufghani.service.VehicleService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

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
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Test", result.getBody().getResult());
    }

    @Test
    public void testGetSupplierRatingPerCarType() {
        Mockito.when(vehicleOutputFormat.formatSupplierRatingPerCarType(Mockito.anyList())).thenReturn("Test");

        ResponseEntity<VehicleResponse> result = vehicleController.getSupplierRatingPerCarType();

        Mockito.verify(vehicleService, Mockito.times(1)).supplierRatingPerCarType();
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Test", result.getBody().getResult());
    }

    @Test
    public void testGetVehicleSpecification() {
        Mockito.when(vehicleOutputFormat.formatVehicleSpecification(Mockito.anyList())).thenReturn("Test");

        ResponseEntity<VehicleResponse> result = vehicleController.getVehicleSpecification();

        Mockito.verify(vehicleService, Mockito.times(1)).vehicleSpecification();
        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Test", result.getBody().getResult());
    }
}