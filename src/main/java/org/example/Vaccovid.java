package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

public class Vaccovid {
    private String population;
    private int totalCases;
    private int totalDeaths;
    private String totalRecovered;

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }

    public int getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(int totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    @SuppressWarnings("unchecked")
    @JsonProperty("")
    private void unpackNested(Map<String,Object> main) {
        this.population = (String) main.get("Population");
        this.totalCases = (int) main.get("TotalCases");
        this.totalDeaths = (int) main.get("TotalDeaths");
        this.totalRecovered = (String) main.get("TotalRecovered");
    }

    @Override
    public String toString() {
        return "Vaccovid{" + "population='" + population + '\'' + ", totalCases=" + totalCases
                + ", totalDeaths=" + totalDeaths + ", totalRecovered='" + totalRecovered + '\''
                + '}';
    }
}