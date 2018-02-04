
package io.github.hufghani.model.vehicle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Search"
})
public class Rentalcars implements Serializable
{

    @JsonProperty("Search")
    private Search search;
    private final static long serialVersionUID = 8695253466996681598L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Rentalcars() {
    }

    /**
     * 
     * @param search
     */
    public Rentalcars(Search search) {
        super();
        this.search = search;
    }

    @JsonProperty("Search")
    public Search getSearch() {
        return search;
    }

    @JsonProperty("Search")
    public void setSearch(Search search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "Rentalcars{" +
                "search=" + search +
                '}';
    }
}
