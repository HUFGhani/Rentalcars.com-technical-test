
package io.github.hufghani.model.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "sipp",
    "name",
    "price",
    "supplier",
    "rating"
})
public class VehicleList implements Serializable
{

    @JsonProperty("sipp")
    private String sipp;
    @JsonProperty("name")
    private String name;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("supplier")
    private String supplier;
    @JsonProperty("rating")
    private Double rating;
    private Double score;
    private final static long serialVersionUID = -4507223516141218126L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public VehicleList() {
    }

    /**
     * 
     * @param price
     * @param name
     * @param rating
     * @param sipp
     * @param supplier
     */
    public VehicleList(String sipp, String name, double price, String supplier, double rating) {
        super();
        this.sipp = sipp;
        this.name = name;
        this.price = price;
        this.supplier = supplier;
        this.rating = rating;
    }

    @JsonProperty("sipp")
    public String getSipp() {
        return sipp;
    }

    @JsonProperty("sipp")
    public void setSipp(String sipp) {
        this.sipp = sipp;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("price")
    public Double getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonProperty("supplier")
    public String getSupplier() {
        return supplier;
    }

    @JsonProperty("supplier")
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @JsonProperty("rating")
    public Double getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getScore() {
        return score;
    }

    public VehicleList setScore(Double score) {
        this.score = score;
        return this;
    }

    @Override
    public String toString() {
        return "VehicleList{" +
                "sipp='" + sipp + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplier='" + supplier + '\'' +
                ", rating=" + rating +
                ", score=" + score +
                '}';
    }
}
