package io.github.hufghani.controller;

import io.github.hufghani.formatter.VehicleOutputFormat;
import io.github.hufghani.model.VehicleResponse;
import io.github.hufghani.model.vehicle.VehicleList;
import io.github.hufghani.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleOutputFormat vehicleOutputFormat;

    
    @RequestMapping(path = "/score",
            method = {RequestMethod.GET},
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getScore() {
        List<VehicleList> vehicle = vehicleService.calculateCombineScore();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatCalculateCombineScore(vehicle));
        return ResponseEntity.ok(vehicleResponse);
    }

}
