package io.github.hufghani.controller;

import io.github.hufghani.formatter.VehicleOutputFormat;
import io.github.hufghani.model.VehicleResponse;
import io.github.hufghani.model.specification.VehicleSpecification;
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


    @RequestMapping(path = "/score", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getScore() {
        List<VehicleList> vehicle = vehicleService.calculateCombineScore();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatCalculateCombineScore(vehicle));
        return ResponseEntity.ok(vehicleResponse);
    }

    @RequestMapping(path = "/supplierRatingPerCarType", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getSupplierRatingPerCarType() {
        List<VehicleSpecification> vehicleSpecification = vehicleService.supplierRatingPerCarType();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatSupplierRatingPerCarType(vehicleSpecification));
        return ResponseEntity.ok(vehicleResponse);
    }

    @RequestMapping(path = "/specificationBySipp", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getVehicleSpecification() {
        List<VehicleSpecification> vehicleSpecification = vehicleService.vehicleSpecification();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatVehicleSpecification(vehicleSpecification));
        return ResponseEntity.ok(vehicleResponse);
    }

}
