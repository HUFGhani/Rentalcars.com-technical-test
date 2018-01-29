package io.github.hufghani.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.hufghani.model.Rentalcars;
import io.github.hufghani.model.VehicleList;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class CarService implements CarServiceInterface {

    private Rentalcars rentalcars;
    private List<VehicleList> vehicleLists;

    public CarService() {
        loadJsonData();

    }

    private void loadJsonData() {
        try {
            InputStream resourceAsStream = CarService.class.getClassLoader().getResourceAsStream("vehicles.json");
            ObjectMapper objectMapper = new ObjectMapper();
            this.rentalcars = objectMapper.readValue(resourceAsStream,Rentalcars.class);
            this.vehicleLists = this.rentalcars.getSearch().getVehicleList();
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
        return null;
    }


}
