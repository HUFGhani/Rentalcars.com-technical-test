package io.github.hufghani.formatter;

import io.github.hufghani.model.specification.VehicleSpecification;
import io.github.hufghani.model.vehicle.VehicleList;
import org.springframework.stereotype.Component;

import java.util.List;

//defines all vehicles output formation related methods.
@Component
public class VehicleOutputFormat {

    private int index;
    private final static String LINE_SEPARATOR = System.lineSeparator();

    public VehicleOutputFormat() {
        index = 0;
    }

    //Formats the vehicles output in the list by the following format:
    //{index}. {Vehicle name} – {Price}
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

    //Formats the vehicleSpecification output by the following format:
    //{index}. {Vehicle name} – {SIPP} – {Car type} – {Car type/doors} – {Transmission} – {Fuel} – {Air con}
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

    //Formats the vehicleSpecification output by the following format:
    //{index}. {Vehicle name} – {Car type} – {Supplier} – {Rating}
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

    //Formats the vehicles output by the following format:
    //{index}. {Vehicle name} – {Vehicle score} – {Supplier rating} – {Sum of scores}
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
