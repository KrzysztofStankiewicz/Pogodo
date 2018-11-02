package com.krzychu.Pogodo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PogodoApplication extends Application
{

    final String ver = "0.1";
    private ConfigurableApplicationContext springContext;
    private Parent root;
    private FXMLLoader fxmlLoader;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        fxmlLoader.setLocation(getClass().getResource("/fxml/FXMLPogodo.fxml"));
        root = fxmlLoader.load();

        primaryStage.setTitle("Pogodo (wersja " + ver + ")");
        Scene scene = new Scene(root);//Scene(root, 800, 600);
        
        scene.setFill(new Color(0.1, 0.1, 0.8, 0));
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void init()
    {
        springContext = SpringApplication.run(PogodoApplication.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

}
