package tictactoe;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;

public class MultiOfflineBase extends Pane {

    protected final Text text;
    protected final Text text0;
    protected final TextField player1NameText;
    protected final TextField player2NameText;
    protected final Button GoBtn;
    protected final Text text1;
    protected final Text text2;
    protected final Button backBtn;
    protected final Label label;
    protected final RadioButton recordBtn;
    Stage stage;
    static boolean Multiplayer = false;
    static String p1;
    static String p2;
    static boolean isRecorded = false;

    public MultiOfflineBase(Stage s) {
         getStylesheets().add("/Fxmlscreens/FristScreen.css");
        setId("root");
        stage = s;
        text = new Text();
        text0 = new Text();
        player1NameText = new TextField();
        player2NameText = new TextField();
        GoBtn = new Button();
        text1 = new Text();
        text2 = new Text();
        backBtn = new Button();
        label = new Label();
        recordBtn = new RadioButton();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        text.setFill(javafx.scene.paint.Color.valueOf("#3700ff"));
        text.setLayoutX(139.0);
        text.setLayoutY(156.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("X");
        text.setFont(new Font(32.0));

        text0.setFill(javafx.scene.paint.Color.valueOf("#e80101"));
        text0.setLayoutX(424.0);
        text0.setLayoutY(153.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("O");
        text0.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text0.setWrappingWidth(32.13671803474426);
        text0.setFont(new Font(36.0));

        player1NameText.setLayoutX(75.0);
        player1NameText.setLayoutY(200.0);

        player2NameText.setLayoutX(361.0);
        player2NameText.setLayoutY(200.0);

        GoBtn.setLayoutX(238.0);
        GoBtn.setLayoutY(304.0);
        GoBtn.setMnemonicParsing(false);
        GoBtn.setPrefHeight(31.0);
        GoBtn.setPrefWidth(121.0);
        GoBtn.setText("Go");
        GoBtn.setFont(new Font(15.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#3700ff"));
        text1.setLayoutX(116.0);
        text1.setLayoutY(260.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("Player 1");
        text1.setFont(new Font(24.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#e80101"));
        text2.setLayoutX(406.0);
        text2.setLayoutY(259.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("Player 2");
        text2.setFont(new Font(24.0));

        backBtn.setLayoutX(24.0);
        backBtn.setLayoutY(24.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        label.setLayoutX(220.0);
        label.setLayoutY(55.0);
        label.setText("Tic Tac Toe");
        label.setFont(new Font(32.0));

        recordBtn.setLayoutX(470.0);
        recordBtn.setLayoutY(28.0);
        recordBtn.setMnemonicParsing(false);
        recordBtn.setText("Record Game");

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(player1NameText);
        getChildren().add(player2NameText);
        getChildren().add(GoBtn);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(backBtn);
        getChildren().add(label);
        getChildren().add(recordBtn);
        recordBtn.setOnAction((event) -> {
            p1 = player1NameText.getText().toString();
            p2 = player2NameText.getText().toString();
            isRecorded = true;
            System.out.println("Radio button selected");

        });
        backBtn.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        GoBtn.setOnAction((event) -> {
            Multiplayer = true;
            p1 = player1NameText.getText().toString();
            p2 = player2NameText.getText().toString();
            Parent newRoot = new GameBase(stage,false);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
    }
}
