package tictactoe;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class levelsPaneBase extends AnchorPane {

    protected final Label label;
    protected final Label label0;
    protected final Button btnEasy;
    protected final Button btnNormal;
    protected final Button btnHard;
    protected final Button button;
    protected final RadioButton recordBtn;
    Stage stage;
    static boolean isRecorded = false;

    public levelsPaneBase(Stage s) {
        getStylesheets().add("/Fxmlscreens/FristScreen.css");

        stage = s;
        label = new Label();
        label.setId("tictactoe");
        label0 = new Label();
        label0.setId("tictactoe");
         recordBtn=new RadioButton();
        btnEasy = new Button();

        btnEasy.setId("back");

        btnNormal = new Button();
        btnNormal.setId("back");

        btnHard = new Button();
        btnHard.setId("back");

        button = new Button();
        setId("root");
        setPrefHeight(385.0);
        setPrefWidth(552.0);
        
        recordBtn.setLayoutX(470.0);
        recordBtn.setLayoutY(28.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Record Game");
        
        label.setLayoutX(216.0);
        label.setLayoutY(53.0);
        label.setPrefHeight(52.0);
        label.setPrefWidth(235.0);
        label.setId("tictactoe");
        label.setText("Tic Tac Toe");
        label.setFont(new Font("Arabic Typesetting", 38.0));

        label0.setLayoutX(252.0);
        label0.setLayoutY(105.0);
        label0.setPrefHeight(52.0);
        label0.setPrefWidth(120.0);
        label0.setText("Levels");
        label0.setId("tictactoe2");
        label0.setFont(new Font("Arabic Typesetting", 38.0));

        btnEasy.setLayoutX(230.0);
        btnEasy.setLayoutY(185.0);
        btnEasy.setMnemonicParsing(false);
        btnEasy.setText("Easy");
        btnEasy.setPrefWidth(100.0);

        btnNormal.setLayoutX(230.0);
        btnNormal.setLayoutY(240.0);
        btnNormal.setMnemonicParsing(false);
        btnNormal.setText("Normal");
        btnNormal.setPrefWidth(100.0);

        btnHard.setLayoutX(230.0);
        btnHard.setLayoutY(299.0);
        btnHard.setMnemonicParsing(false);
//        btnHard.setPrefHeight(31.0);
        btnHard.setPrefWidth(100.0);
        btnHard.setText("Hard");
        btnHard.setVisible(false);

        button.setMnemonicParsing(false);
        button.setText("Back");
        button.setId("BackToMain");

        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(btnEasy);
        getChildren().add(btnNormal);
        getChildren().add(btnHard);
        getChildren().add(button);
        getChildren().add(recordBtn);
        recordBtn.setOnAction((event) -> {
            isRecorded = true;
        });

        btnEasy.setOnAction((event) -> {
            Parent newRoot = new SingleGame(stage, "easy");
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        btnNormal.setOnAction((event) -> {
            Parent newRoot = new SingleGame(stage, "medium");
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        btnHard.setOnAction((event) -> {
            Parent newRoot = new SingleGame(stage, "hard");
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        button.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

    }
}
