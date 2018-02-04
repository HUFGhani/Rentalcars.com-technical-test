package io.github.hufghani.formatter;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;

import java.util.List;

public class VehicleOutputFormat {

    private int index;
    private final static String LINE_SEPARATOR = System.lineSeparator();

    public VehicleOutputFormat() {
        index = 0;
    }

    public String formatPriceOrder(List<VehicleList> vehicles) {
        String output = "";

        if (index !=1){
            index = 1;
        }

        for (int i = 0; i <vehicles.size(); i++) {
            output+= String.format("%d. %s - %.2f%s",
                    index++,
                    vehicles.get(i).getName(),
                    vehicles.get(i).getPrice(),
                    LINE_SEPARATOR);
        }

        return output;
    }

    public String formatVehicleSpecification(List<VehicleSpecification> vehicleSpecifications) {
        String output = "";

        if (index !=1){
            index = 1;
        }
        for (int i = 0; i <vehicleSpecifications.size(); i++) {
            output+= String.format("%d. %s - %s - %s - %s - %s - %s - %s%s",
                    index++,
                    vehicleSpecifications.get(i).getVehicleList().getName(),
                    vehicleSpecifications.get(i).getVehicleList().getSipp(),
                    vehicleSpecifications.get(i).getCarType(),
                    vehicleSpecifications.get(i).getDoors(),
                    vehicleSpecifications.get(i).getTransmission(),
                    vehicleSpecifications.get(i).getFuel(),
                    vehicleSpecifications.get(i).getAc(),
                    LINE_SEPARATOR);
        }
        return output;
    }

    public String formatSupplierRatingPerCarType(List<VehicleSpecification> vehicleSpecifications) {
        String output = "";

        if (index !=1){
            index = 1;
        }
        for (int i = 0; i < vehicleSpecifications.size(); i++) {
            output+= String.format("%d. %s - %s - %s - %s%s",
                    index++,
                    vehicleSpecifications.get(i).getVehicleList().getName(),
                    vehicleSpecifications.get(i).getCarType(),
                    vehicleSpecifications.get(i).getVehicleList().getSupplier(),
                    vehicleSpecifications.get(i).getVehicleList().getRating(),
                    LINE_SEPARATOR);
        }
        return output;

    }

    public String formatCalculateCombineScore(List<VehicleList> vehicles) {
        String output = "";

        if (index !=1){
            index = 1;
        }
        for (int i = 0; i < vehicles.size(); i++) {
            output+= String.format("%d. %s - %d - %.2f - %.2f%s",
                    index++,
                    vehicles.get(i).getName(),
                    vehicles.get(i).getVehicleScore(),
                    vehicles.get(i).getRating(),
                    vehicles.get(i).getCombinedScore(),
                    LINE_SEPARATOR);
        }
        return output;
    }
}
