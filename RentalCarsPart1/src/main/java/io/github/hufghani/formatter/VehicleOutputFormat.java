package io.github.hufghani.formatter;

import io.github.hufghani.model.vehicle.VehicleList;

import java.util.List;

public class VehicleOutputFormat {

    private int index;
    private final static String LINE_SEPARATOR = System.lineSeparator();

    public VehicleOutputFormat() {
        index = 1;
    }

    public String formatPriceOrder(List<VehicleList> vehicles) {
        String output = "";

        if (index !=1){
            index = 1;
        }

        for (int i = 0; i <vehicles.size(); i++) {
            output+= String.format("%d. %s - %.2f%s",
                    index++,vehicles.get(i).getName(),vehicles.get(i).getPrice(),LINE_SEPARATOR);
        }

        return output;
    }
}
