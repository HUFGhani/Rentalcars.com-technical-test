package io.github.hufghani.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class RootVehicleControllerTest {

    private RootVehicleController rootVehicleController;

    @Before
    public void setUp() throws Exception {
        rootVehicleController = new RootVehicleController();
    }

    @Test
    public void testRoot() {
        ResponseEntity<String> result = rootVehicleController.root();
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("endpoints:<br/>/vehicles - list the vehicle related endpoints.", result.getBody().toString());
    }
}