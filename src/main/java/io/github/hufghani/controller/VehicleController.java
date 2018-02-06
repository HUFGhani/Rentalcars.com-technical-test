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


// /vehicles endpoint controller
@RestController
@RequestMapping(path = "vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private VehicleOutputFormat vehicleOutputFormat;

    // /score endpoint controller.
    // gets all the vehicles, calculates their scores, orders them by their combined score Highest to lowest.
    // which is add into a list and displayed
    @RequestMapping(path = "/score", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getScore() {
        List<VehicleList> vehicle = vehicleService.calculateCombineScore();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatCalculateCombineScore(vehicle));
        return ResponseEntity.ok(vehicleResponse);
    }

    // /supplierRatingPerCarType endpoint controller.
    // gets all the vehicles, groups them by their type, selects the highest supplier' ratings for each every type.
    // which is add into a list and displayed
    @RequestMapping(path = "/supplierRatingPerCarType", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getSupplierRatingPerCarType() {
        List<VehicleSpecification> vehicleSpecification = vehicleService.supplierRatingPerCarType();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatSupplierRatingPerCarType(vehicleSpecification));
        return ResponseEntity.ok(vehicleResponse);
    }

    // /specificationBySipp endpoint controller.
    // gets all the vehicles specifications based on their SIPP.
    // which is add into a list and displayed
    @RequestMapping(path = "/specificationBySipp", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getVehicleSpecification() {
        List<VehicleSpecification> vehicleSpecification = vehicleService.vehicleSpecification();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatVehicleSpecification(vehicleSpecification));
        return ResponseEntity.ok(vehicleResponse);
    }

    // /priceOrder endpoint controller.
    // gets all the vehicles, orders them in price order ascending.
    // which is add into a list and displayed
    @RequestMapping(path = "/priceOrder", method = {RequestMethod.GET}, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<VehicleResponse> getVehiclePriceOrder() {
        List<VehicleList> vehicle = vehicleService.vehiclePriceOrder();
        VehicleResponse vehicleResponse = new VehicleResponse();
        vehicleResponse.setResult(vehicleOutputFormat.formatPriceOrder(vehicle));
        return ResponseEntity.ok(vehicleResponse);
    }

    //Basic endpoint - Prints out the available endpoints.
    @RequestMapping(path = "", method = {RequestMethod.GET}, produces = MediaType.TEXT_HTML_VALUE)
    public ResponseEntity<String> root() {
        return ResponseEntity.ok("Available endpoints:<br/>" +
                "/priceOrder <br/>" +
                "/specificationBySipp <br/>" +
                "/supplierRatingPerCarType <br/>" +
                "/score</br>");
    }
}
