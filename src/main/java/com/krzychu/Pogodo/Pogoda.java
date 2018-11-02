package com.krzychu.Pogodo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pogoda
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("main")
    private Map<String, Float> mainJ;

    //Gdyby były getery i setery to chyba nie trzeba dodawać tych @JsonProperty
    @Override
    public String toString()
    {
        float tempLoc = (float) mainJ.get("temp") - (float) 273.15;
        return "Temperatura w wybranej miejscowości (" + name + ") to " + String.format("%.1f", tempLoc) + "°C";
    }
    
    public String getDetails()
    {
        return "Szczegółowe dane: " + mainJ;
    }

}
