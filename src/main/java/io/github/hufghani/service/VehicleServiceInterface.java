package io.github.hufghani.service;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;

import java.util.List;

//This interface defines all operation on cars related methods.
public interface VehicleServiceInterface {

    // gets all the vehicles.
    List<VehicleList>getAllVehicles();

    //gets all the vehicles, orders them in price order ascending.
    List<VehicleList>vehiclePriceOrder();

    //gets all the vehicles specifications based on their SIPP.
    List<VehicleSpecification> vehicleSpecification();

    //gets all the vehicles, groups them by their type, selects the highest supplier' ratings for each every type.
    List<VehicleSpecification> supplierRatingPerCarType();

    //gets all the vehicles, calculates their scores, orders them by their combined score Highest to lowest.
    List<VehicleList> calculateCombineScore();
}
