package com.krzychu.Pogodo;

import javafx.fxml.FXML;
import javafx.scene.text.Text;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PogodoService
{

    final String basicUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
    String location = "leszno";
    String country = ",pl";
    final String apiKey = "&appid=9d39577a7a924298804c8c75af175174";
    private RestTemplate rt;

    PogodoService()
    {
        RestTemplateBuilder rtp = new RestTemplateBuilder();
        this.rt = rtp.build();
    }

    /*@Bean
    public CommandLineRunner run(RestTemplate restTemplate)
    {
        return (args) ->
        {
            System.out.println("===============================================================\n===============================================================\n");
            Pogoda pogoda = restTemplate.getForObject(basicUrl + location + country + apiKey, Pogoda.class);
            System.out.println(pogoda);
            System.out.println("\n===============================================================\n===============================================================");
        };
    } */
    public Pogoda printInfo()
    {
        System.out.println("===============================================================\n===============================================================\n");
        System.out.println("Wysyłam zapytanie do: "+basicUrl + location + country + apiKey);
        Pogoda pogoda = rt.getForObject(basicUrl + location + country + apiKey, Pogoda.class);
        System.out.println(pogoda);
        System.out.println("\n===============================================================\n===============================================================");
        return pogoda;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

}

