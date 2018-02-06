package io.github.hufghani.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class VehicleResponse implements Serializable {

    @JsonProperty("Result")
    private Object result;

    public VehicleResponse() {
    }

    public VehicleResponse(Object result) {
        super();
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public VehicleResponse setResult(Object result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("VehicleResponse{")
                .append("result=").append(result)
                .append('}').toString();
    }
}
