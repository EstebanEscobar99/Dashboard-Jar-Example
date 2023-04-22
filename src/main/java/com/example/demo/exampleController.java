package com.example.demo;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class exampleController implements Initializable {
    @FXML
    private ImageView exit;

    @FXML
    private ToggleButton menu;

    @FXML
    private AnchorPane pane1,pane2;

    private FadeTransition fadeTransition;
    private TranslateTransition translateTransition;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exit.setOnMouseClicked(event -> {
            System.exit(0);
        });

        pane1.setVisible(false);

        fadeTransition = new FadeTransition(Duration.seconds(0.5),pane1);
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();

        translateTransition = new TranslateTransition(Duration.seconds(0.5),pane2);
        translateTransition.setByX(-600);
        translateTransition.play();

        menu.setOnMouseClicked(event -> {

//            pane1.setVisible(true);

            if (menu.isSelected()){

                fadeTransition = new FadeTransition(Duration.seconds(0.5),pane1);
                fadeTransition.setFromValue(1);
                fadeTransition.setToValue(0.15);
                fadeTransition.play();

                translateTransition = new TranslateTransition(Duration.seconds(0.5),pane2);
                translateTransition.setByX(+600);
                translateTransition.play();
            }else {
                fadeTransition = new FadeTransition(Duration.seconds(0.5),pane1);
                fadeTransition.setFromValue(0.15);
                fadeTransition.setToValue(0);
                fadeTransition.play();

                translateTransition = new TranslateTransition(Duration.seconds(0.5),pane2);
                translateTransition.setByX(-600);
                translateTransition.play();
            }

        });
    }
}
