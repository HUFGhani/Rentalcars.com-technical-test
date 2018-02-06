package io.github.hufghani.formatter;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class VehicleOutputFormat {

    private int index;
    private final static String LINE_SEPARATOR = System.lineSeparator();

    public VehicleOutputFormat() {
        index = 0;
    }

    public String formatPriceOrder(List<VehicleList> vehicles) {
        StringBuilder output = new StringBuilder();
        indexReset();
        for (VehicleList vehicle : vehicles) {
            output.append(String.format("%d. %s - %.2f%s",
                    index++,
                    vehicle.getName(),
                    vehicle.getPrice(),
                    LINE_SEPARATOR));
        }

        return output.toString();
    }

    public String formatVehicleSpecification(List<VehicleSpecification> vehicleSpecifications) {
        StringBuilder output = new StringBuilder();
        indexReset();
        for (VehicleSpecification vehicleSpecification : vehicleSpecifications) {
            output.append(String.format("%d. %s - %s - %s - %s - %s - %s - %s%s",
                    index++,
                    vehicleSpecification.getVehicleList().getName(),
                    vehicleSpecification.getVehicleList().getSipp(),
                    vehicleSpecification.getCarType(),
                    vehicleSpecification.getDoors(),
                    vehicleSpecification.getTransmission(),
                    vehicleSpecification.getFuel(),
                    vehicleSpecification.getAc(),
                    LINE_SEPARATOR));
        }
        return output.toString();
    }

    public String formatSupplierRatingPerCarType(List<VehicleSpecification> vehicleSpecifications) {
        StringBuilder output = new StringBuilder();
        indexReset();
        for (VehicleSpecification vehicleSpecification : vehicleSpecifications) {
            output.append(String.format("%d. %s - %s - %s - %s%s",
                    index++,
                    vehicleSpecification.getVehicleList().getName(),
                    vehicleSpecification.getCarType(),
                    vehicleSpecification.getVehicleList().getSupplier(),
                    vehicleSpecification.getVehicleList().getRating(),
                    LINE_SEPARATOR));
        }
        return output.toString();

    }

    public String formatCalculateCombineScore(List<VehicleList> vehicles) {
        StringBuilder output = new StringBuilder();
        indexReset();
        for (VehicleList vehicle : vehicles) {
            output.append(String.format("%d. %s - %d - %.2f - %.2f%s",
                    index++,
                    vehicle.getName(),
                    vehicle.getVehicleScore(),
                    vehicle.getRating(),
                    vehicle.getCombinedScore(),
                    LINE_SEPARATOR));
        }
        return output.toString();
    }

    private void indexReset(){
         index = 1;
    }
}
