package org.example.javafxprojekt;

import javafx.animation.*;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

public class JavaFXAnimationApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Komponentë vizuale
        Circle rreth = new Circle(40, Color.DARKORANGE);
        Rectangle drejtkendesh = new Rectangle(100, 60, Color.CORNFLOWERBLUE);
        Label label = new Label("Kliko mbi figurat për animime");
        Button buttonAnim = new Button("Animacion Butoni");
        TextField input = new TextField();
        input.setPromptText("Shkruaj diçka...");
        ImageView imageView = new ImageView(new Image("https://via.placeholder.com/80"));
        imageView.setPreserveRatio(true);

        // Event 1: ActionEvent mbi Button 
        buttonAnim.setOnAction(e -> {
            RotateTransition rotate = new RotateTransition(Duration.seconds(2), drejtkendesh);
            rotate.setByAngle(360);
            rotate.setCycleCount(1);
            rotate.play();
        });

        // Event 2: MouseEvent mbi Circle
        rreth.setOnMouseClicked(e -> {
            TranslateTransition move = new TranslateTransition(Duration.seconds(1), rreth);
            move.setByY(100);
            move.setAutoReverse(true);
            move.setCycleCount(2);
            move.play();
        });

        // Event 3: Mouse Enter mbi ImageView
        imageView.setOnMouseEntered(e -> {
            FadeTransition fade = new FadeTransition(Duration.seconds(1), imageView);
            fade.setFromValue(1.0);
            fade.setToValue(0.3);
            fade.setAutoReverse(true);
            fade.setCycleCount(2);
            fade.play();
        });

        // Event 4: KeyEvent për TextField
        input.setOnKeyTyped((KeyEvent e) -> {
            label.setText("Shtype: " + e.getCharacter());
        });

        // Animim 4: Scale Transition tek drejtkendeshi
        drejtkendesh.setOnMouseEntered((MouseEvent e) -> {
            ScaleTransition scale = new ScaleTransition(Duration.seconds(0.5), drejtkendesh);
            scale.setToX(1.5);
            scale.setToY(1.5);
            scale.setAutoReverse(true);
            scale.setCycleCount(2);
            scale.play();
        });

        VBox layout = new VBox(15, label, rreth, drejtkendesh, buttonAnim, input, imageView);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Ngjarje dhe Animime në JavaFX");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
