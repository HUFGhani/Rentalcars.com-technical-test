package io.github.hufghani.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hufghani.model.specification.VehicleSIPPSpecification;
import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.Rentalcars;
import io.github.hufghani.model.vehicle.VehicleList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleService implements VehicleServiceInterface {

    private Rentalcars rentalcars;
    private VehicleSIPPSpecification vehicleSIPPSpecification;
    private List<VehicleList> vehicleLists;

    public VehicleService() {
        loadJsonData();
    }

    private void loadJsonData() {
        try {
            InputStream vehicleResourceAsStream = VehicleService.class.getClassLoader()
                    .getResourceAsStream("vehicles.json");
            ObjectMapper objectMapper = new ObjectMapper();

            InputStream vehicleSpecificationResourceAsStream = VehicleService.class.getClassLoader()
                    .getResourceAsStream("sipp_spec.json");


            this.rentalcars = objectMapper.readValue(vehicleResourceAsStream,Rentalcars.class);
            this.vehicleLists = this.rentalcars.getSearch().getVehicleList();
            this.vehicleSIPPSpecification = objectMapper.
                    readValue(vehicleSpecificationResourceAsStream,VehicleSIPPSpecification.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<VehicleList> getAllVehicles() {
        return this.vehicleLists;
    }

    public List<VehicleList> vehiclePriceOrder() {
        Collections.sort(getAllVehicles(), new Comparator<VehicleList>() {
            public int compare(VehicleList vehicle1, VehicleList vehicle) {
                return Double.compare(vehicle1.getPrice(),vehicle.getPrice());
            }
        });
        return getAllVehicles();
    }

    public List<VehicleSpecification> vehicleSpecification() {
        List<VehicleList> vehicleLists = this.getAllVehicles();
        List<VehicleSpecification> temp = new ArrayList<VehicleSpecification>();
        vehicleLists.forEach(
                vehicle->{
                    char[] sipp = vehicle.getSipp().toCharArray();
                    VehicleSpecification vehicleSpecification = new VehicleSpecification();
                    vehicleSpecification.setVehicleList(vehicle);
                    vehicleSpecification.setCarType(this.vehicleSIPPSpecification.getCarTypeMap().get(sipp[0]));
                    vehicleSpecification.setDoors(this.vehicleSIPPSpecification.getDoorsMap().get(sipp[1]));
                    vehicleSpecification.setTransmission(this.vehicleSIPPSpecification
                            .getTransmissionMap().get(sipp[2]));
                    String [] fuelAc = this.vehicleSIPPSpecification.getFuelAcMap().get(sipp[3]).split("/");
                    vehicleSpecification.setFuel(fuelAc[0]);
                    vehicleSpecification.setAc(fuelAc[1]);
                    temp.add(vehicleSpecification);
                });
        return Collections.unmodifiableList(temp);
    }

    @Override
    public List<VehicleSpecification> supplierRatingPerCarType() {
        List<VehicleList> vehicleLists = this.getAllVehicles();
        List<VehicleSpecification> vehicleSpecifications = vehicleSpecification();
        List<VehicleSpecification> temp = new ArrayList<VehicleSpecification>(vehicleLists.size());
        vehicleSpecifications.stream()
                .collect(Collectors.groupingBy(VehicleSpecification::getCarType, Collectors.toList()))
                .forEach(
                        (vehicleType,vehicleSpec) ->{
                            VehicleSpecification vehicleSpecification = vehicleSpec.stream()
                                    .max((vehicleSpec1, vehicleSpec2) -> Double.compare(vehicleSpec1.getVehicleList().getRating(),vehicleSpec2.getVehicleList().getRating()))
                                    .get();
                            temp.add(vehicleSpecification);
                        }
                );

        return Collections.unmodifiableList(
                temp.stream()
                .sorted((vehicleSpec1,vehicleSpec2) -> vehicleSpec2.getCarType().compareTo(vehicleSpec1.getCarType()))
                .collect(Collectors.toList())
        );
    }

    @Override
    public List<VehicleList> calculateCombineScore() {
        List<VehicleList> vehicleLists = this.getAllVehicles();
        for (int i = 0; i < vehicleLists.size(); i++) {
            int vehicleScore = 0;
            char[] vehicleSipp = vehicleLists.get(i).getSipp().toCharArray();
            if(vehicleSipp[2] == 'M'){
                vehicleScore += 1;
            } else if (vehicleSipp[2] == 'A') {
                vehicleScore += 5;
            }

            if (vehicleSipp[3] == 'R') {
                vehicleScore += 2;
            }

            vehicleLists.get(i).setVehicleScore(vehicleScore);
            vehicleLists.get(i).setCombinedScore(vehicleScore + vehicleLists.get(i).getRating());
        }
        return Collections.unmodifiableList(
                vehicleLists.stream()
                        .sorted((vehicle1,vehicle2) -> Double.compare(vehicle2.getCombinedScore(),vehicle1.getCombinedScore()))
                        .collect(Collectors.toList())
        );
    }


}
