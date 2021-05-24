package controller.Użytkownik;

import controller.MainController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class UWybor_miejscaController<Intreger> {
    private MainController main;
    public Label test;
    public int a =0;
    public void init(MainController main) {
        this.main = main;


        KeyFrame rotate = new KeyFrame(
                Duration.millis(0.5),
                event -> {
                    this.test.setText(a+++"");
                }
        );
        Timeline timeline = new Timeline(
                rotate
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();



    }





}
