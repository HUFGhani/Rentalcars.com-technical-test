package io.github.hufghani.service;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;

import java.util.List;

public interface CarServiceInterface {

    public List<VehicleList>getAllVehicles();

    public List<VehicleList>vehiclePriceOrder();

    public List<VehicleSpecification> vehicleSpecification();

    public List<VehicleSpecification> supplierRatingPerCarType();

    public List<VehicleList> calculateCombineScore();
}
