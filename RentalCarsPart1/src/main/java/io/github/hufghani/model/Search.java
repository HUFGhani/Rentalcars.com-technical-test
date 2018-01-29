
package io.github.hufghani.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "VehicleList"
})
public class Search implements Serializable
{

    @JsonProperty("VehicleList")
    private List<VehicleList> vehicleList = new ArrayList<VehicleList>();
    private final static long serialVersionUID = -7209920633061246705L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Search() {
    }

    /**
     * 
     * @param vehicleList
     */
    public Search(List<VehicleList> vehicleList) {
        super();
        this.vehicleList = vehicleList;
    }

    @JsonProperty("VehicleList")
    public List<VehicleList> getVehicleList() {
        return vehicleList;
    }

    @JsonProperty("VehicleList")
    public void setVehicleList(List<VehicleList> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "Search{" +
                "vehicleList=" + vehicleList +
                '}';
    }
}
