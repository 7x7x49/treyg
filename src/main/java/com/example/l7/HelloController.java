package com.example.l7;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import static com.example.l7.HelloApplication.primaryStage;

public class HelloController {
    @FXML TextField ax1;
    @FXML TextField ax2;
    @FXML TextField ax3;
    @FXML TextField ay1;
    @FXML TextField ay2;
    @FXML TextField ay3;

    @FXML TextField bx1;
    @FXML TextField bx2;
    @FXML TextField bx3;
    @FXML TextField by1;
    @FXML TextField by2;
    @FXML TextField by3;

    @FXML
    void buttonPressed(ActionEvent ae){
        int ax11 = 0;
        int ax22 = 0;
        int ax33 = 0;
        int ay11 = 0;
        int ay22 = 0;
        int ay33 = 0;

        int bx11 = 0;
        int bx22 = 0;
        int bx33 = 0;
        int by11 = 0;
        int by22 = 0;
        int by33 = 0;

        try {
            ax11 = Integer.parseInt(ax1.getText());
            ax22 = Integer.parseInt(ax2.getText());
            ax33 = Integer.parseInt(ax3.getText());
            ay11 = Integer.parseInt(ay1.getText());
            ay22 = Integer.parseInt(ay2.getText());
            ay33 = Integer.parseInt(ay3.getText());

            bx11 = Integer.parseInt(bx1.getText());
            bx22 = Integer.parseInt(bx2.getText());
            bx33 = Integer.parseInt(bx3.getText());
            by11 = Integer.parseInt(by1.getText());
            by22 = Integer.parseInt(by2.getText());
            by33 = Integer.parseInt(by3.getText());
        } catch (NumberFormatException e) {
            popup("Enter number, not text!");
            return;
        }

        int s1 = ((ax22 - ax11) * (ay33 - ay11) - (ax33 - ax11) * (ay22 - ay11)) / 2;
        int s2 = ((bx22 - bx11) * (by33 - by11) - (bx33 - bx11) * (by22 - by11)) / 2;

        if (s1 > s2){
            popup("The area of the first triangle is larger than the area of the second.");
        } else if (s2 > s1) {
            popup("The area of the second triangle is larger than the area of the first.");
        } else{
            popup("The areas of the triangles are equal.");
        }

    }

    static void popup(String text){
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        VBox dialogVbox = new VBox(20);
        dialogVbox.getChildren().add(new Text(text));
        Scene dialogScene = new Scene(dialogVbox, 360, 50);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}