package io.github.hufghani.model.specification;

import io.github.hufghani.model.vehicle.VehicleList;

public class VehicleSpecification {
    private VehicleList vehicleList;
    private String carType;
    private String doors;
    private String transmission;
    private String fuel;
    private String ac;

    public VehicleSpecification() {
    }

    public VehicleSpecification(VehicleList vehicleList, String carType, String doors, String transmission, String fuel, String ac) {
        super();
        this.vehicleList = vehicleList;
        this.carType = carType;
        this.doors = doors;
        this.transmission = transmission;
        this.fuel = fuel;
        this.ac = ac;
    }

    public VehicleList getVehicleList() {
        return vehicleList;
    }

    public VehicleSpecification setVehicleList(VehicleList vehicleList) {
        this.vehicleList = vehicleList;
        return this;
    }

    public String getCarType() {
        return carType;
    }

    public VehicleSpecification setCarType(String carType) {
        this.carType = carType;
        return this;
    }

    public String getDoors() {
        return doors;
    }

    public VehicleSpecification setDoors(String doors) {
        this.doors = doors;
        return this;
    }

    public String getTransmission() {
        return transmission;
    }

    public VehicleSpecification setTransmission(String transmission) {
        this.transmission = transmission;
        return this;
    }

    public String getFuel() {
        return fuel;
    }

    public VehicleSpecification setFuel(String fuel) {
        this.fuel = fuel;
        return this;
    }

    public String getAc() {
        return ac;
    }

    public VehicleSpecification setAc(String ac) {
        this.ac = ac;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("VehicleSpecification{")
                .append("vehicleList=").append(vehicleList)
                .append(", carType='").append(carType).append('\'')
                .append(", doors='").append(doors).append('\'')
                .append(", transmission='").append(transmission).append('\'')
                .append(", fuel='").append(fuel).append('\'')
                .append(", ac='").append(ac).append('\'')
                .append('}').toString();
    }
}
