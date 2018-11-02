package com.krzychu.Pogodo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class PogodoController
{

    @FXML
    Text informacje;
    @FXML
    Text informacjeDod;
    @FXML
    Button checkWeatherButton;
    @FXML
    ChoiceBox<String> locationChoiceBox;
    @Autowired
    PogodoService ps;
    String location;

    private Pogoda pogoda;

    public void initialize()
    {
        locationChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> selectionHandler());
        locationChoiceBox.getItems().addAll("Leszno", "Poznan", "Wroclaw", "Gdansk", "Warszawa", "Krakow", "Katowice", "Lodz", "Czempin", "Jarogniewice");
        locationChoiceBox.setValue("Leszno");
        setLocation("leszno");
        checkWeather(location);
    }

    public void checkWeather(String place)
    {
        ps.setLocation(place);
        pogoda = ps.printInfo();
        informacje.setText(pogoda.toString());
        informacjeDod.setText(pogoda.getDetails());
    }

    public void checkWeatherButtonHandler()
    {
        checkWeather(location);
    }

    public void selectionHandler()
    {
        setLocation(locationChoiceBox.getValue());
        System.out.println("\n"+location);
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

}
