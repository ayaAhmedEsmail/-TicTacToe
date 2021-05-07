package tictactoe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SingleGame extends AnchorPane {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final Label label5;
    protected final Label label6;
    protected final Label label7;
    protected final Label label8;
    protected final Label label9;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Text player1Text;
    protected final Text player2Text;
    protected final Text text;
    protected final Text text0;
    Stage stage;
    boolean l1;
    boolean l2;
    boolean l3;
    boolean l4;
    boolean l5;
    boolean l6;
    boolean l7;
    boolean l8;
    boolean l9;
    int XOCounter = 0;
    ArrayList<Integer> randomized = new ArrayList<>();
    static boolean isBestToWin = true;
    static LinkedHashMap<String, Label> recordMap = new LinkedHashMap<String, Label>();
    String winner;
    static int countText;

    public SingleGame(Stage s, String Difficulty) {
        getStylesheets().add("/Fxmlscreens/FristScreen.css");
        setId("root");
        stage = s;
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();
        label8 = new Label();
        label9 = new Label();
        line = new Line();
        line0 = new Line();
        line1 = new Line();
        line2 = new Line();
        player1Text = new Text();
        player2Text = new Text();
        text = new Text();
        text0 = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        AnchorPane.setBottomAnchor(gridPane, 28.0);
        AnchorPane.setLeftAnchor(gridPane, 43.0);
        AnchorPane.setRightAnchor(gridPane, 42.0);
        AnchorPane.setTopAnchor(gridPane, 120.0);
        gridPane.setLayoutX(43.0);
        gridPane.setLayoutY(127.0);
        gridPane.setPrefHeight(252.0);
        gridPane.setPrefWidth(515.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(217.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(188.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(119.0);
        columnConstraints0.setMinWidth(0.0);
        columnConstraints0.setPrefWidth(0.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(305.0);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(156.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(269.0);
        columnConstraints2.setMinWidth(0.0);
        columnConstraints2.setPrefWidth(0.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(228.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(178.0);

        rowConstraints.setMaxHeight(89.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(89.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(43.0);
        rowConstraints0.setMinHeight(0.0);
        rowConstraints0.setPrefHeight(0.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(83.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(83.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(55.0);
        rowConstraints2.setMinHeight(0.0);
        rowConstraints2.setPrefHeight(5.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(64.0);
        rowConstraints3.setMinHeight(9.0);
        rowConstraints3.setPrefHeight(59.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        label1.setOpacity(0.0);
        label1.setPrefHeight(89.0);
        label1.setPrefWidth(212.0);
        GridPane.setMargin(label1, new Insets(0.0));
        label1.setPadding(new Insets(0.0, 0.0, 0.0, 90.0));

        GridPane.setColumnIndex(label2, 2);
        label2.setOpacity(0.0);
        label2.setPrefHeight(111.0);
        label2.setPrefWidth(215.0);
        label2.setPadding(new Insets(0.0, 0.0, 0.0, 60.0));

        GridPane.setColumnIndex(label3, 4);
        label3.setOpacity(0.0);
        label3.setPrefHeight(88.0);
        label3.setPrefWidth(204.0);
        label3.setOpaqueInsets(new Insets(0.0));
        label3.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        GridPane.setRowIndex(label4, 2);
        label4.setOpacity(0.0);
        label4.setPrefHeight(92.0);
        label4.setPrefWidth(210.0);
        label4.setPadding(new Insets(0.0, 0.0, 0.0, 90.0));

        GridPane.setColumnIndex(label5, 2);
        GridPane.setRowIndex(label5, 2);
        label5.setOpacity(0.0);
        label5.setPrefHeight(87.0);
        label5.setPrefWidth(210.0);
        label5.setPadding(new Insets(0.0, 0.0, 0.0, 60.0));

        GridPane.setColumnIndex(label6, 4);
        GridPane.setRowIndex(label6, 2);
        label6.setOpacity(0.0);
        label6.setPrefHeight(83.0);
        label6.setPrefWidth(177.0);
        label6.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        GridPane.setRowIndex(label7, 4);
        label7.setOpacity(0.0);
        label7.setPrefHeight(53.0);
        label7.setPrefWidth(217.0);
        label7.setPadding(new Insets(10.0, 0.0, 0.0, 90.0));

        GridPane.setColumnIndex(label8, 2);
        GridPane.setRowIndex(label8, 4);
        label8.setOpacity(0.0);
        label8.setPrefHeight(76.0);
        label8.setPrefWidth(151.0);
        label8.setPadding(new Insets(10.0, 0.0, 0.0, 60.0));

        GridPane.setColumnIndex(label9, 4);
        GridPane.setRowIndex(label9, 4);
        label9.setOpacity(0.0);
        label9.setPrefHeight(49.0);
        label9.setPrefWidth(169.0);
        label9.setPadding(new Insets(10.0, 0.0, 0.0, 80.0));
        label9.setOpaqueInsets(new Insets(0.0));

        GridPane.setRowIndex(line, 1);
        line.setEndX(457.29290771484375);
        line.setEndY(-1.0003780126571655);
        line.setStartX(985.5858154296875);
        line.setStartY(-0.9995685815811157);

        GridPane.setRowIndex(line0, 3);
        line0.setEndX(584.5);
        line0.setStartX(58.0);

        GridPane.setColumnIndex(line1, 1);
        GridPane.setRowIndex(line1, 2);
        line1.setEndX(-108.72947692871094);
        line1.setEndY(150.13589477539062);
        line1.setStartX(-108.72846984863281);
        line1.setStartY(-124.93257141113281);

        GridPane.setColumnIndex(line2, 3);
        GridPane.setRowIndex(line2, 2);
        line2.setEndX(-111.0);
        line2.setEndY(304.0);
        line2.setStartX(-111.0);
        line2.setStartY(27.0);

        AnchorPane.setBottomAnchor(player1Text, 340.2275390625);
        AnchorPane.setLeftAnchor(player1Text, 129.0);
        AnchorPane.setRightAnchor(player1Text, 390.994140625);
        AnchorPane.setTopAnchor(player1Text, 29.1806640625);
        player1Text.setLayoutX(129.0);
        player1Text.setLayoutY(54.0);
        player1Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player1Text.setStrokeWidth(0.0);
        player1Text.setText("Player 1");
        player1Text.setFont(new Font(23.0));

        AnchorPane.setLeftAnchor(player2Text, 444.0);
        AnchorPane.setRightAnchor(player2Text, 75.994140625);
        AnchorPane.setTopAnchor(player2Text, 27.0);
        player2Text.setLayoutX(444.0);
        player2Text.setLayoutY(52.0);
        player2Text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        player2Text.setStrokeWidth(0.0);
        player2Text.setText("Player 2");
        player2Text.setFont(new Font(23.0));

        AnchorPane.setLeftAnchor(text, 161.0);
        AnchorPane.setRightAnchor(text, 425.43359375);
        AnchorPane.setTopAnchor(text, 60.1806640625);
        text.setFill(javafx.scene.paint.Color.valueOf("#3700ff"));
        text.setLayoutX(161.0);
        text.setLayoutY(85.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("X");
        text.setFont(new Font(30.0));

        AnchorPane.setBottomAnchor(text0, 305.2275390625);
        AnchorPane.setLeftAnchor(text0, 475.0);
        AnchorPane.setRightAnchor(text0, 107.66015625);
        AnchorPane.setTopAnchor(text0, 64.1806640625);
        text0.setFill(javafx.scene.paint.Color.valueOf("#e80101"));
        text0.setLayoutX(475.0);
        text0.setLayoutY(89.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("O");
        text0.setFont(new Font(23.0));

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getChildren().add(label1);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(label3);
        gridPane.getChildren().add(label4);
        gridPane.getChildren().add(label5);
        gridPane.getChildren().add(label6);
        gridPane.getChildren().add(label7);
        gridPane.getChildren().add(label8);
        gridPane.getChildren().add(label9);
        gridPane.getChildren().add(line);
        gridPane.getChildren().add(line0);
        gridPane.getChildren().add(line1);
        gridPane.getChildren().add(line2);
        getChildren().add(gridPane);
        getChildren().add(player1Text);
        getChildren().add(player2Text);
        getChildren().add(text);
        getChildren().add(text0);

        label1.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label1", label1);
                }
                l1 = true;
                label1.setOpacity(1);
                label1.setFont(Font.font(50));
                label1.setText("X");
                label1.setTextFill(Color.BLUE);
                label1.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /* case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }

                }
            }
        }
        );

        label2.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label2", label2);
                }
                l2 = true;
                label2.setOpacity(1);
                label2.setFont(Font.font(50));
                label2.setText("X");
                label2.setTextFill(Color.BLUE);
                label2.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /*  case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }

        }
        );
        label3.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label3", label3);
                }
                l3 = true;
                label3.setOpacity(1);
                label3.setFont(Font.font(50));
                label3.setText("X");
                label3.setTextFill(Color.BLUE);
                label3.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /*case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }
        }
        );
        label4.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label4", label4);
                }
                l4 = true;
                label4.setOpacity(1);
                label4.setFont(Font.font(50));
                label4.setText("X");
                label4.setTextFill(Color.BLUE);
                label4.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /*case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }
        }
        );

        label5.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label5", label5);
                }
                l5 = true;
                label5.setOpacity(1);
                label5.setFont(Font.font(50));
                label5.setText("X");
                label5.setTextFill(Color.BLUE);
                label5.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /*case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }

        }
        );
        label6.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label6", label6);
                }
                l6 = true;
                label6.setOpacity(1);
                label6.setFont(Font.font(50));
                label6.setText("X");
                label6.setTextFill(Color.BLUE);
                label6.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /* case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }
        }
        );
        label7.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label7", label7);
                }
                l7 = true;
                label7.setOpacity(1);
                label7.setFont(Font.font(50));
                label7.setText("X");
                label7.setTextFill(Color.BLUE);
                label7.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /*case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }
        }
        );
        label8.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label8", label8);
                }
                l8 = true;
                label8.setOpacity(1);
                label8.setFont(Font.font(50));
                label8.setText("X");
                label8.setTextFill(Color.BLUE);
                label8.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /*case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }
        }
        );
        label9.setOnMousePressed(
                new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event
            ) {
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label9", label9);
                }
                l9 = true;
                label9.setOpacity(1);
                label9.setFont(Font.font(50));
                label9.setText("X");
                label9.setTextFill(Color.BLUE);
                label9.setDisable(true);
                XOCounter++;
                if (checkIfGameEnds() == false) {
                    switch (Difficulty) {
                        case "easy":
                            botMoveEasy(makeAvailableSpotsArray());
                            break;
                        case "medium":
                            botMoveMedium(makeAvailableSpotsArray());
                            break;
                        /*case "hard":
                            botMoveHard(makeAvailableSpotsArray());*/
                    }
                }
            }
        }
        );

    }

    private ArrayList<Integer> makeAvailableSpotsArray() {

        ArrayList<Integer> availableSpots = new ArrayList<>(9);
        if (l1 == false) {
            availableSpots.add(1);
            System.out.println("L1");
        }
        if (l2 == false) {
            availableSpots.add(2);
            System.out.println("L2");
        }
        if (l3 == false) {
            availableSpots.add(3);
            System.out.println("L3");
        }
        if (l4 == false) {
            availableSpots.add(4);
            System.out.println("L4");
        }
        if (l5 == false) {
            availableSpots.add(5);
            System.out.println("L5");
        }
        if (l6 == false) {
            availableSpots.add(6);
            System.out.println("L6");
        }
        if (l7 == false) {
            availableSpots.add(7);
            System.out.println("L7");
        }
        if (l8 == false) {
            availableSpots.add(8);
            System.out.println("L8");
        }
        if (l9 == false) {
            availableSpots.add(9);
            System.out.println("L9");
        }

        return availableSpots;
    }

    private void botMoveEasy(ArrayList<Integer> availableSpots) {

        Random rand = new Random();
        int randSpot = rand.nextInt(availableSpots.size());
        while (randomized.contains(randSpot)) {
            randSpot = rand.nextInt(availableSpots.size());
        }
        randomized.add(randSpot);
        System.out.println("random " + availableSpots.get(randSpot));
        switch (availableSpots.get(randSpot)) {
            case 1:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label1", label1);
                }
                l1 = true;
                label1.setOpacity(1);
                label1.setFont(Font.font(50));
                label1.setText("O");
                label1.setTextFill(Color.RED);
                label1.setDisable(true);
                XOCounter++;
                break;
            case 2:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label2", label2);
                }
                l2 = true;
                label2.setOpacity(1);
                label2.setFont(Font.font(50));
                label2.setText("O");
                label2.setTextFill(Color.RED);
                label2.setDisable(true);
                XOCounter++;
                break;
            case 3:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label3", label3);
                }
                l3 = true;
                label3.setOpacity(1);
                label3.setFont(Font.font(50));
                label3.setText("O");
                label3.setTextFill(Color.RED);
                label3.setDisable(true);
                XOCounter++;
                break;
            case 4:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label4", label4);
                }
                l4 = true;
                label4.setOpacity(1);
                label4.setFont(Font.font(50));
                label4.setText("O");
                label4.setTextFill(Color.RED);
                label4.setDisable(true);
                XOCounter++;
                break;
            case 5:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label5", label5);
                }
                l5 = true;
                label5.setOpacity(1);
                label5.setFont(Font.font(50));
                label5.setText("O");
                label5.setTextFill(Color.RED);
                label5.setDisable(true);
                XOCounter++;
                break;
            case 6:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label6", label6);
                }
                l6 = true;
                label6.setOpacity(1);
                label6.setFont(Font.font(50));
                label6.setText("O");
                label6.setTextFill(Color.RED);
                label6.setDisable(true);
                XOCounter++;
                break;
            case 7:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label7", label7);
                }
                l7 = true;
                label7.setOpacity(1);
                label7.setFont(Font.font(50));
                label7.setText("O");
                label7.setTextFill(Color.RED);
                label7.setDisable(true);
                XOCounter++;
                break;
            case 8:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label8", label8);
                }
                l8 = true;
                label8.setOpacity(1);
                label8.setFont(Font.font(50));
                label8.setText("O");
                label8.setTextFill(Color.RED);
                label8.setDisable(true);
                XOCounter++;
                break;
            case 9:
                if (levelsPaneBase.isRecorded == true) {
                    recordMap.put("label9", label9);
                }
                l9 = true;
                label9.setOpacity(1);
                label9.setFont(Font.font(50));
                label9.setText("O");
                label9.setTextFill(Color.RED);
                label9.setDisable(true);
                XOCounter++;
                break;

        }
        checkIfGameEnds();
    }

    private void botMoveMedium(ArrayList<Integer> emptyPlaces) {
        boolean win = false;
        String mark_to_draw = "O";
        for (int i : emptyPlaces) {
            switch (i) {
                case 1:
                         ;
                    l1 = true;
                    label1.setOpacity(1);
                    label1.setFont(Font.font(50));
                    label1.setText(mark_to_draw);
                    label1.setTextFill(Color.RED);
                    label1.setDisable(true);
                    XOCounter++;
                    break;
                case 2:

                    l2 = true;
                    label2.setOpacity(1);
                    label2.setFont(Font.font(50));
                    label2.setText(mark_to_draw);
                    label2.setTextFill(Color.RED);
                    label2.setDisable(true);
                    XOCounter++;
                    break;
                case 3:

                    l3 = true;
                    label3.setOpacity(1);
                    label3.setFont(Font.font(50));
                    label3.setText(mark_to_draw);
                    label3.setTextFill(Color.RED);
                    label3.setDisable(true);
                    XOCounter++;
                    break;
                case 4:
                         ;
                    l4 = true;
                    label4.setOpacity(1);
                    label4.setFont(Font.font(50));
                    label4.setText(mark_to_draw);
                    label4.setTextFill(Color.RED);
                    label4.setDisable(true);
                    XOCounter++;
                    break;
                case 5:

                    l5 = true;
                    label5.setOpacity(1);
                    label5.setFont(Font.font(50));
                    label5.setText(mark_to_draw);
                    label5.setTextFill(Color.RED);
                    label5.setDisable(true);
                    XOCounter++;
                    break;
                case 6:

                    l6 = true;
                    label6.setOpacity(1);
                    label6.setFont(Font.font(50));
                    label6.setText(mark_to_draw);
                    label6.setTextFill(Color.RED);
                    label6.setDisable(true);
                    XOCounter++;
                    break;
                case 7:
                    l7 = true;

                    label7.setOpacity(1);
                    label7.setFont(Font.font(50));
                    label7.setText(mark_to_draw);
                    label7.setTextFill(Color.RED);
                    label7.setDisable(true);
                    XOCounter++;
                    break;
                case 8:
                    l8 = true;

                    label8.setOpacity(1);
                    label8.setFont(Font.font(50));
                    label8.setText(mark_to_draw);
                    label8.setTextFill(Color.RED);
                    label8.setDisable(true);
                    XOCounter++;
                    break;
                case 9:

                    l9 = true;
                    label9.setOpacity(1);
                    label9.setFont(Font.font(50));
                    label9.setText(mark_to_draw);
                    label9.setTextFill(Color.RED);
                    label9.setDisable(true);
                    XOCounter++;
                    break;
            }
            win = checkIfGameEnds();
            if (!win) {
                switch (i) {
                    case 1:
                        l1 = false;
                        label1.setText("");
                        label1.setDisable(false);
                        XOCounter--;
                        break;
                    case 2:
                        l2 = false;
                        label2.setText("");
                        label2.setDisable(false);
                        XOCounter--;
                        break;
                    case 3:
                        l3 = false;
                        label3.setText("");
                        label3.setDisable(false);
                        XOCounter--;
                        break;
                    case 4:
                        l4 = false;
                        label4.setText("");
                        label4.setDisable(false);
                        XOCounter--;
                        break;
                    case 5:
                        l5 = false;
                        label5.setText("");
                        label5.setDisable(false);
                        XOCounter--;
                        break;
                    case 6:
                        l6 = false;
                        label6.setText("");
                        label6.setDisable(false);
                        XOCounter--;
                        break;
                    case 7:
                        l7 = false;
                        label7.setText("");
                        label7.setDisable(false);
                        XOCounter--;
                        break;
                    case 8:
                        l8 = false;
                        label8.setText("");
                        label8.setDisable(false);
                        XOCounter--;
                        break;
                    case 9:
                        l9 = false;
                        label9.setText("");
                        label9.setDisable(false);
                        XOCounter--;
                        break;
                }
            } else {
                break;
            }
        }

        if (!win) {
            for (int i : emptyPlaces) {
                switch (i) {
                    case 1:
                             ;
                        l1 = true;
                        label1.setOpacity(1);
                        label1.setFont(Font.font(50));
                        label1.setText("O");
                        label1.setTextFill(Color.RED);
                        label1.setDisable(true);
                        XOCounter++;
                        break;
                    case 2:

                        l2 = true;
                        label2.setOpacity(1);
                        label2.setFont(Font.font(50));
                        label2.setText("O");
                        label2.setTextFill(Color.RED);
                        label2.setDisable(true);
                        XOCounter++;
                        break;
                    case 3:

                        l3 = true;
                        label3.setOpacity(1);
                        label3.setFont(Font.font(50));
                        label3.setText("O");
                        label3.setTextFill(Color.RED);
                        label3.setDisable(true);
                        XOCounter++;
                        break;
                    case 4:
                             ;
                        l4 = true;
                        label4.setOpacity(1);
                        label4.setFont(Font.font(50));
                        label4.setText("O");
                        label4.setTextFill(Color.RED);
                        label4.setDisable(true);
                        XOCounter++;
                        break;
                    case 5:

                        l5 = true;
                        label5.setOpacity(1);
                        label5.setFont(Font.font(50));
                        label5.setText("O");
                        label5.setTextFill(Color.RED);
                        label5.setDisable(true);
                        XOCounter++;
                        break;
                    case 6:

                        l6 = true;
                        label6.setOpacity(1);
                        label6.setFont(Font.font(50));
                        label6.setText("O");
                        label6.setTextFill(Color.RED);
                        label6.setDisable(true);
                        XOCounter++;
                        break;
                    case 7:
                        l7 = true;

                        label7.setOpacity(1);
                        label7.setFont(Font.font(50));
                        label7.setText("O");
                        label7.setTextFill(Color.RED);
                        label7.setDisable(true);
                        XOCounter++;
                        break;
                    case 8:
                        l8 = true;

                        label8.setOpacity(1);
                        label8.setFont(Font.font(50));
                        label8.setText("O");
                        label8.setTextFill(Color.RED);
                        label8.setDisable(true);
                        XOCounter++;
                        break;
                    case 9:

                        l9 = true;
                        label9.setOpacity(1);
                        label9.setFont(Font.font(50));
                        label9.setText("O");
                        label9.setTextFill(Color.RED);
                        label9.setDisable(true);
                        XOCounter++;
                        break;
                }
                win = checkIfGameEnds();
                if (win) {
                    if (mark_to_draw == "X") {
                        mark_to_draw = "O";
                    } else {
                        mark_to_draw = "X";
                    }
                    switch (i) {
                        case 1:
                                 ;
                            l1 = true;
                            label1.setOpacity(1);
                            label1.setFont(Font.font(50));
                            label1.setText(mark_to_draw);
                            label1.setTextFill(Color.RED);
                            label1.setDisable(true);
                            XOCounter++;
                            break;
                        case 2:

                            l2 = true;
                            label2.setOpacity(1);
                            label2.setFont(Font.font(50));
                            label2.setText(mark_to_draw);
                            label2.setTextFill(Color.RED);
                            label2.setDisable(true);
                            XOCounter++;
                            break;
                        case 3:

                            l3 = true;
                            label3.setOpacity(1);
                            label3.setFont(Font.font(50));
                            label3.setText(mark_to_draw);
                            label3.setTextFill(Color.RED);
                            label3.setDisable(true);
                            XOCounter++;
                            break;
                        case 4:
                                 ;
                            l4 = true;
                            label4.setOpacity(1);
                            label4.setFont(Font.font(50));
                            label4.setText(mark_to_draw);
                            label4.setTextFill(Color.RED);
                            label4.setDisable(true);
                            XOCounter++;
                            break;
                        case 5:

                            l5 = true;
                            label5.setOpacity(1);
                            label5.setFont(Font.font(50));
                            label5.setText(mark_to_draw);
                            label5.setTextFill(Color.RED);
                            label5.setDisable(true);
                            XOCounter++;
                            break;
                        case 6:

                            l6 = true;
                            label6.setOpacity(1);
                            label6.setFont(Font.font(50));
                            label6.setText(mark_to_draw);
                            label6.setTextFill(Color.RED);
                            label6.setDisable(true);
                            XOCounter++;
                            break;
                        case 7:
                            l7 = true;

                            label7.setOpacity(1);
                            label7.setFont(Font.font(50));
                            label7.setText(mark_to_draw);
                            label7.setTextFill(Color.RED);
                            label7.setDisable(true);
                            XOCounter++;
                            break;
                        case 8:
                            l8 = true;

                            label8.setOpacity(1);
                            label8.setFont(Font.font(50));
                            label8.setText(mark_to_draw);
                            label8.setTextFill(Color.RED);
                            label8.setDisable(true);
                            XOCounter++;
                            break;
                        case 9:

                            l9 = true;
                            label9.setOpacity(1);
                            label9.setFont(Font.font(50));
                            label9.setText(mark_to_draw);
                            label9.setTextFill(Color.RED);
                            label9.setDisable(true);
                            XOCounter++;
                            break;
                    }
                    break;
                } else {
                    switch (i) {
                        case 1:
                            l1 = false;
                            label1.setText("");
                            label1.setDisable(false);
                            XOCounter--;
                            break;
                        case 2:
                            l2 = false;
                            label2.setText("");
                            label2.setDisable(false);
                            XOCounter--;
                            break;
                        case 3:
                            l3 = false;
                            label3.setText("");
                            label3.setDisable(false);
                            XOCounter--;
                            break;
                        case 4:
                            l4 = false;
                            label4.setText("");
                            label4.setDisable(false);
                            XOCounter--;
                            break;
                        case 5:
                            l5 = false;
                            label5.setText("");
                            label5.setDisable(false);
                            XOCounter--;
                            break;
                        case 6:
                            l6 = false;
                            label6.setText("");
                            label6.setDisable(false);
                            XOCounter--;
                            break;
                        case 7:
                            l7 = false;
                            label7.setText("");
                            label7.setDisable(false);
                            XOCounter--;
                            break;
                        case 8:
                            l8 = false;
                            label8.setText("");
                            label8.setDisable(false);
                            XOCounter--;
                            break;
                        case 9:
                            l9 = false;
                            label9.setText("");
                            label9.setDisable(false);
                            XOCounter--;
                            break;
                    }
                }
            }
        }

        if (!win) {
            //mark_to_draw = (mark_to_draw == 'X') ? 'O' : 'X';
            if (mark_to_draw == "X") {
                mark_to_draw = "O";
            } else {
                mark_to_draw = "X";
            }
            botMoveEasy(emptyPlaces);
        }
    }

    private boolean checkIfGameEnds() {
        boolean isGameEnds = false;
        String t00 = label1.getText();
        String t01 = label2.getText();
        String t02 = label3.getText();
        String t10 = label4.getText();
        String t11 = label5.getText();
        String t12 = label6.getText();
        String t20 = label7.getText();
        String t21 = label8.getText();
        String t22 = label9.getText();
        boolean isFirstPlayerTurn = false;
        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            if (t00.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label1, label2, label3);
        }
        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            if (t10.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label4, label5, label6);
        }
        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            if (t20.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label7, label8, label9);
        }
        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            if (t00.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label1, label4, label7);
        }
        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            if (t01.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label2, label5, label8);
        }
        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            if (t02.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label3, label6, label9);
        }
        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            if (t00.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label1, label5, label9);
        }
        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            if (t02.equals("X")) {
                isFirstPlayerTurn = true;
            }
            colorBackgroundWinner(label3, label5, label7);
        }

        if (isGameEnds == true) {
            if (isFirstPlayerTurn) {
                winner = "You";
                countText++;
                if (levelsPaneBase.isRecorded == true) {
                    isRecorded(recordMap);
                }
                Parent newRoot = new WinnerVideoPlayerBase(stage, "offline");
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
                return true;
            } else {
                winner = "Computer";
                countText++;
                if (levelsPaneBase.isRecorded == true) {
                    isRecorded(recordMap);
                }
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Computer Won !!", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    Parent newRoot = new FirstScreenBase(stage);
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);
                    return true;
                }
            }

        }
        if (XOCounter >= 9) {
            winner = "NoOne";
            countText++;
            if (levelsPaneBase.isRecorded == true) {
                isRecorded(recordMap);
            }
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No one Wins !!", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                Parent newRoot = new FirstScreenBase(stage);
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
                return true;
            }

        }
        return false;
    }

    private void colorBackgroundWinner(Label l1, Label l2, Label l3) {
        l1.setStyle("-fx-background-color: yellow;");
        l2.setStyle("-fx-background-color: yellow;");
        l3.setStyle("-fx-background-color: yellow;");
    }

    public void isRecorded(LinkedHashMap<String, Label> labelmap) {
        try {

            FileWriter myWriter = new FileWriter("recordedgame\\"+"You" + ",Computer," + winner + "," + "game " + countText + ",.txt");

            for (Map.Entry<String, Label> entry : labelmap.entrySet()) {
                String labelname = entry.getKey();
                String label = entry.getValue().getText();
                if (label.isEmpty()) {
                    continue;
                } else {
                    myWriter.write("You" + ",Computer," + winner + "," + labelname + "," + label + "\n");
                }
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

}
