package io.github.hufghani.service;

import io.github.hufghani.model.VehicleList;

import java.util.List;

public interface CarServiceInterface {

    public List<VehicleList>getAllVehicles();

    public List<VehicleList>vehiclePriceOrder();
}
