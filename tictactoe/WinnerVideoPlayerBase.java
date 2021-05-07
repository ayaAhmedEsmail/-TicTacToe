package tictactoe;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;

import javafx.stage.Stage;

public class WinnerVideoPlayerBase extends Pane {

    protected MediaView mediaView;
    protected final Label label;
    protected final Button skipBtn;
    static String URL = "file:/C:/Users/Nada/Desktop/winner.mp4";
    Stage stage;

    public WinnerVideoPlayerBase(Stage s, String player) {
        stage = s;
        Media media = new Media(URL);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        label = new Label();
        skipBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        mediaView.setFitHeight(350.0);
        mediaView.setFitWidth(600.0);
        mediaView.setLayoutY(50.0);
        /*mediaView.fitWidthProperty().bind(stage.widthProperty());
        mediaView.fitHeightProperty().bind(stage.heightProperty());
        Rectangle rectangle = new Rectangle();
        rectangle.setX(USE_PREF_SIZE);
        rectangle.setY(50);
        rectangle.setWidth(600);
        rectangle.setFill(Color.BLACK);
         */
        label.setLayoutX(177.0);
        label.setLayoutY(14.0);
        label.setText("Congratulations! You won!");
        label.setFont(new Font(21.0));

        skipBtn.setLayoutX(21.0);
        skipBtn.setLayoutY(14.0);
        skipBtn.setMnemonicParsing(false);
        skipBtn.setText("Skip video");

        getChildren().add(mediaView);
        getChildren().add(label);
        getChildren().add(skipBtn);
        //mediaView.fitWidthProperty().bind(stage.widthProperty());

        mediaPlayer.play();
        mediaPlayer.setOnEndOfMedia(() -> {
            if (player.equals("offline")) {
                Parent newRoot = new FirstScreenBase(stage);
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
            } else {
                Parent newRoot = new OnlineUsersBase(stage, player);
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
            }
        });

        skipBtn.setOnAction((event) -> {
            mediaPlayer.stop();
            if (player.equals("offline")) {
                Parent newRoot = new FirstScreenBase(stage);
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
            } else {
                Parent newRoot = new OnlineUsersBase(stage, player);
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
            }
        });
    }
}
