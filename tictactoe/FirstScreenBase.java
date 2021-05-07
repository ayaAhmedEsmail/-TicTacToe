package tictactoe;



import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FirstScreenBase extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final Label Tictactoe;
    protected final Button SingleBtn;
    protected final Button multiplayerBtn;
    protected final Button offlineBtn;
    protected final Button exitBtn;
    protected final Button historyBtn;
    Stage stage ;
    public FirstScreenBase(Stage s) {
        stage = s;
        getStylesheets().add("/Fxmlscreens/FristScreen.css");
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        Tictactoe = new Label();
        Tictactoe.setId("tictactoe");
        SingleBtn = new Button();
        SingleBtn.setId("back");
        multiplayerBtn = new Button();
        multiplayerBtn.setId("back");
        offlineBtn = new Button();
        offlineBtn.setId("back");
        exitBtn = new Button();
        exitBtn.setId("back");
        historyBtn = new Button();
        historyBtn.setId("back");
        setId("root");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        
        

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnIndex(Tictactoe, 1);
        Tictactoe.setAlignment(javafx.geometry.Pos.CENTER);
        Tictactoe.setPrefHeight(50.0);
        Tictactoe.setPrefWidth(200.0);
        Tictactoe.setText("Tic Tac Toe");
        Tictactoe.setFont(new Font(40.0));

        GridPane.setColumnIndex(SingleBtn, 1);
        GridPane.setRowIndex(SingleBtn, 1);
        SingleBtn.setAlignment(javafx.geometry.Pos.CENTER);
        SingleBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        SingleBtn.setMnemonicParsing(false);
        SingleBtn.setPrefHeight(50.0);
        SingleBtn.setPrefWidth(200.0);
        SingleBtn.setText("Single Player");
        SingleBtn.setFont(new Font(24.0));

        GridPane.setColumnIndex(multiplayerBtn, 1);
        GridPane.setRowIndex(multiplayerBtn, 2);
        multiplayerBtn.setAlignment(javafx.geometry.Pos.CENTER);
        multiplayerBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        multiplayerBtn.setMnemonicParsing(false);
        multiplayerBtn.setPrefHeight(50.0);
        multiplayerBtn.setPrefWidth(200.0);
        multiplayerBtn.setText("Online Multi-Player");
        multiplayerBtn.setTextAlignment(javafx.scene.text.TextAlignment.RIGHT);
        multiplayerBtn.setFont(new Font(20.0));

        GridPane.setColumnIndex(offlineBtn, 1);
        GridPane.setRowIndex(offlineBtn, 3);
        offlineBtn.setAlignment(javafx.geometry.Pos.CENTER);
        offlineBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        offlineBtn.setMnemonicParsing(false);
        offlineBtn.setPrefHeight(50.0);
        offlineBtn.setPrefWidth(200.0);
        offlineBtn.setText("Offline Multi-Player");
        offlineBtn.setFont(new Font(20.0));

        GridPane.setColumnIndex(exitBtn, 1);
        GridPane.setRowIndex(exitBtn, 5);
        exitBtn.setAlignment(javafx.geometry.Pos.CENTER);
        exitBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(50.0);
        exitBtn.setPrefWidth(200.0);
        exitBtn.setText("Exit");
        exitBtn.setFont(new Font(24.0));

        GridPane.setColumnIndex(historyBtn, 1);
        GridPane.setRowIndex(historyBtn, 4);
        historyBtn.setAlignment(javafx.geometry.Pos.CENTER);
        historyBtn.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        historyBtn.setMnemonicParsing(false);
        historyBtn.setPrefHeight(50.0);
        historyBtn.setPrefWidth(200.0);
        historyBtn.setText("History");
        historyBtn.setFont(new Font(24.0));
        setCursor(Cursor.SW_RESIZE);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getColumnConstraints().add(columnConstraints1);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getRowConstraints().add(rowConstraints2);
        getRowConstraints().add(rowConstraints3);
        getRowConstraints().add(rowConstraints4);
        getChildren().add(Tictactoe);
        getChildren().add(SingleBtn);
        getChildren().add(multiplayerBtn);
        getChildren().add(offlineBtn);
        getChildren().add(exitBtn);
        getChildren().add(historyBtn);
        // First Screen Single Btn:
        
        multiplayerBtn.setOnAction((event) -> {

            Parent newRoot = new MultiOnlineLoginBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        SingleBtn.setOnAction((event) -> {

            Parent newRoot = new levelsPaneBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        offlineBtn.setOnAction((event) -> {
            Parent newRoot = new MultiOfflineBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
       historyBtn.setOnAction((event) -> {
            Parent newRoot = new HistoryBase2(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        exitBtn.setOnAction((event) -> {
            Platform.exit();
        });
    }
}
