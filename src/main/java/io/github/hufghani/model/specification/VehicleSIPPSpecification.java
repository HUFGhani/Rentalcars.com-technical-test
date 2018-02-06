package io.github.hufghani.model.specification;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VehicleSIPPSpecification implements Serializable {

    @JsonProperty("carType")
    private final Map<Character, String> carTypeMap;
    @JsonProperty("doors")
    private final Map<Character, String> doorsMap;
    @JsonProperty("transmission")
    private final Map<Character, String> transmissionMap;
    @JsonProperty("fuelAc")
    private final Map<Character, String> fuelAcMap;

    public VehicleSIPPSpecification() {
        super();
        this.carTypeMap = new HashMap<>();
        this.doorsMap = new HashMap<>();
        this.transmissionMap = new HashMap<>();
        this.fuelAcMap = new HashMap<>();
    }

    public VehicleSIPPSpecification(Map<Character, String> carTypeMap, Map<Character, String> doorsMap, Map<Character, String> transmissionMap, Map<Character, String> fuelAcMap) {
        super();
        this.carTypeMap = carTypeMap;
        this.doorsMap = doorsMap;
        this.transmissionMap = transmissionMap;
        this.fuelAcMap = fuelAcMap;
    }

    public Map<Character, String> getCarTypeMap() {
        return Collections.unmodifiableMap(carTypeMap);
    }

    public Map<Character, String> getDoorsMap() {
        return Collections.unmodifiableMap(doorsMap);
    }

    public Map<Character, String> getTransmissionMap() {
        return Collections.unmodifiableMap(transmissionMap);
    }

    public Map<Character, String> getFuelAcMap() {
        return Collections.unmodifiableMap(fuelAcMap);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("VehicleSIPPSpecification{")
                .append("carTypeMap=").append(carTypeMap)
                .append(", doorsMap=").append(doorsMap)
                .append(", transmissionMap=").append(transmissionMap)
                .append(", fuelAcMap=").append(fuelAcMap)
                .append('}').toString();
    }
}
