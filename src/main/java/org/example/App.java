package org.example;

import org.example.utils.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.http.HttpResponse;

public class App {
    public static void main(String[] args) {
        HttpResponse<String> response = HTTPHelper.sendGet();
        if (response != null) {
            System.out.println("Response != null we good..");
            System.out.println(response.body());
            Vaccovid vaccovid = parseVaccovidResponse(response.body(), Vaccovid.class);
            System.out.println(vaccovid);
        }
    }

    public static Vaccovid parseVaccovidResponse(String responseString, Class<?> elementClass) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode vacciccovidNode = objectMapper.readTree(responseString);
            Vaccovid vaccovid = new Vaccovid();



            String population = vacciccovidNode.get("Population").textValue();
            int totalCases = vacciccovidNode.get("TotalCases").intValue();
            int totalDeaths = vacciccovidNode.get("TotalDeaths").intValue();
            String totalRecovered = vacciccovidNode.get("TotalRecovered").textValue();

            vaccovid.setPopulation(population);
            vaccovid.setTotalCases(totalCases);
            vaccovid.setTotalDeaths(totalDeaths);
            vaccovid.setTotalRecovered(totalRecovered);

            return vaccovid;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
