package tictactoe;

import java.util.LinkedHashMap;
import java.util.Timer;
import java.util.stream.IntStream;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

public class GameBase extends AnchorPane {

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
    protected final Button backBtn;
    Timer timer;

    Stage stage;
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    int i;
    LinkedHashMap<String, String> linkedMap = new LinkedHashMap<>();
    boolean isGameEnds;
    int XOCounter;
    boolean LastItem;
    boolean isX;

    public void mm(int c, Runnable action) {
        IntStream.range(0, c).forEach(i -> action.run());

    }

    public GameBase(Stage s, Boolean RecordedGame) {
        stage = s;
        XOCounter = 0;

        LastItem = false;

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
        backBtn = new Button();
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

        backBtn.setLayoutX(24.0);
        backBtn.setLayoutY(24.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

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
        label3.setText("O");
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
        label9.setText("O");
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
        getChildren().add(backBtn);
        getChildren().add(text0);

        if (RecordedGame) {
            XOCounter = 0;
            for (i = 0; i < HistoryBase2.arrList.size(); i++) {
                System.out.println("ana fe GameBase:\n" + HistoryBase2.arrList.get(i));
                String newLine = HistoryBase2.arrList.get(i);
                String[] value = newLine.split(",");
                player1Text.setText(value[0]);
                player2Text.setText(value[1]);
                int x = 0;
                switch (value[3]) {
                    case "label1":
                        label1.setOpacity(1);
                        label1.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label1.setText("X");
                            label1.setTextFill(xForeground);
                        } else {
                            label1.setText("O");
                            label1.setTextFill(oForeground);

                        }
                        break;
                    case "label2":

                        label2.setOpacity(1);
                        label2.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label2.setText("X");
                            label2.setTextFill(xForeground);
                        } else {
                            label2.setText("O");
                            label2.setTextFill(oForeground);
                        }
                        break;
                    case "label3":
                        label3.setOpacity(1);
                        label3.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label3.setText("X");
                            label3.setTextFill(xForeground);
                        } else {
                            label3.setText("O");
                            label3.setTextFill(oForeground);
                        }
                        break;
                    case "label4":

                        label4.setOpacity(1);
                        label4.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label4.setText("X");
                            label4.setTextFill(xForeground);
                        } else {
                            label4.setText("O");
                            label4.setTextFill(oForeground);
                        }
                        break;
                    case "label5":
                        label5.setOpacity(1);
                        label5.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label5.setText("X");
                            label5.setTextFill(xForeground);
                        } else {
                            label5.setText("O");
                            label5.setTextFill(oForeground);
                        }
                        break;
                    case "label6":

                        label6.setOpacity(1);
                        label6.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label6.setText("X");
                            label6.setTextFill(xForeground);
                        } else {
                            label6.setText("O");
                            label6.setTextFill(oForeground);
                        }
                        break;
                    case "label7":
                        label7.setOpacity(1);
                        label7.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label7.setText("X");
                            label7.setTextFill(xForeground);
                        } else {
                            label7.setText("O");
                            label7.setTextFill(oForeground);
                        }
                        break;
                    case "label8":
                        label8.setOpacity(1);
                        label8.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label8.setText("X");
                            label8.setTextFill(xForeground);
                        } else {
                            label8.setText("O");
                            label8.setTextFill(oForeground);
                        }
                        break;
                    case "label9":

                        label9.setOpacity(1);
                        label9.setFont(Font.font(50));
                        XOCounter++;
                        if (value[4].equals("X")) {
                            label9.setText("X");
                            label9.setTextFill(xForeground);
                        } else {
                            label9.setText("O");
                            label9.setTextFill(oForeground);
                        }
                        break;

                }
                System.out.println("value of 3 and 4 " + value[3] + value[4]);
                linkedMap.put(value[3], value[4]);

                //  int s=HistoryBase2.arrList.size();
                //  System.out.println("number of arrlist: "+ s);
                if (i == HistoryBase2.arrList.size() - 1) {
                    LastItem = true;
                    if (value[4].equals("X")) {
                        System.out.println("ana 5let isX = true");
                        isX = true;
                    } else {
                        System.out.println("ana 5let isX = false");
                        isX = false;
                    }

                }

            }
            //   checkIfGameEnds(linkedMap);
            checkIfGameEndsWithOutAlert(linkedMap);

            backBtn.setOnAction((event) -> {
                Parent newRoot = new HistoryBase2(stage);
                Scene scene = new Scene(newRoot);
                stage.setScene(scene);
            });

        } else {

            backBtn.setOpacity(0);
            GameController game = new GameController(stage);
            MultiOfflineBase multioffline = new MultiOfflineBase(stage);

            if (MultiOfflineBase.Multiplayer == true) {
                player1Text.setText(MultiOfflineBase.p1);
                player2Text.setText(MultiOfflineBase.p2);
            }

            label1.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label1, "label1");

                }
            });

            label2.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label2, "label2");

                }
            });
            label3.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label3, "label3");

                }
            });
            label4.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label4, "label4");

                }
            });

            label5.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label5, "label5");

                }
            });
            label6.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label6, "label6");

                }
            });
            label7.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label7, "label7");

                }
            });
            label8.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label8, "label8");

                }
            });
            label9.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    game.setCurrentPlayerSymbol(label9, "label9");

                }
            });

        }

    }

    private void colorBackgroundWinner(Label l1, Label l2, Label l3) {
        l1.setStyle("-fx-background-color: yellow;");
        l2.setStyle("-fx-background-color: yellow;");
        l3.setStyle("-fx-background-color: yellow;");
    }

    public void checkIfGameEnds(LinkedHashMap<String, String> labelmap) {

        String t00 = labelmap.get("label1");
        if (t00 == null) {
            t00 = "";
        }
        System.out.println("ana fe checkGame t00 : " + t00);
        String t01 = labelmap.get("label2");
        if (t01 == null) {
            t01 = "";
        }
        System.out.println("ana fe checkGame t01 : " + t01);
        String t02 = labelmap.get("label3");
        if (t02 == null) {
            t02 = "";
        }
        System.out.println("ana fe checkGame t02 : " + t02);
        String t10 = labelmap.get("label4");
        if (t10 == null) {
            t10 = "";
        }
        System.out.println("ana fe checkGame t10 : " + t10);
        String t11 = labelmap.get("label5");
        if (t11 == null) {
            t11 = "";
        }
        System.out.println("ana fe checkGame t11 : " + t11);
        String t12 = labelmap.get("label6");
        if (t12 == null) {
            t12 = "";
        }
        System.out.println("ana fe checkGame t12 : " + t12);
        String t20 = labelmap.get("label7");
        if (t20 == null) {
            t20 = "";
        }
        System.out.println("ana fe checkGame t20 : " + t20);
        String t21 = labelmap.get("label8");
        if (t21 == null) {
            t21 = "";
        }
        System.out.println("ana fe checkGame t21 : " + t21);
        String t22 = labelmap.get("label9");
        if (t22 == null) {
            t22 = "";
        }
        System.out.println("ana fe checkGame t22 : " + t22);
        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label1, label2, label3);
        }
        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label4, label5, label6);
        }

        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label7, label8, label9);
        }

        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label1, label4, label7);
        }

        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label2, label5, label8);
        }

        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label3, label6, label9);
        }

        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label1, label5, label9);
        }

        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label3, label5, label7);
        }

        if (XOCounter >= 9 && isGameEnds != true) {

            XOCounter = 0;
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "No one Wins !!", ButtonType.OK);
            alert.showAndWait();

            System.out.println("ALert in GameBase For NO one win ");
            if (alert.getResult() == ButtonType.OK) {
                /* Parent newRoot = new HistoryBase2(stage);
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);*/
            }

        }

        if (isGameEnds) {

            if (isX) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Player 1 Wins !!", ButtonType.OK);
                alert.showAndWait();
                isGameEnds = false;
                isX = false;
                System.out.println("ALert in GameBase For player1 winner ");
                if (alert.getResult() == ButtonType.OK) {
                    /*  Parent newRoot = new HistoryBase2(stage);
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);*/
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Player 2 Wins !!", ButtonType.OK);
                alert.showAndWait();
                isGameEnds = false;
                isX = true;
                System.out.println("ALert in GameBase For player2 winner ");
                if (alert.getResult() == ButtonType.OK) {
                    /*Parent newRoot = new HistoryBase2(stage);
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);*/
                }
            }

        }

    }

    public void checkIfGameEndsWithOutAlert(LinkedHashMap<String, String> labelmap) {

        String t00 = labelmap.get("label1");
        if (t00 == null) {
            t00 = "";
        }
        System.out.println("ana fe checkGame t00 : " + t00);
        String t01 = labelmap.get("label2");
        if (t01 == null) {
            t01 = "";
        }
        System.out.println("ana fe checkGame t01 : " + t01);
        String t02 = labelmap.get("label3");
        if (t02 == null) {
            t02 = "";
        }
        System.out.println("ana fe checkGame t02 : " + t02);
        String t10 = labelmap.get("label4");
        if (t10 == null) {
            t10 = "";
        }
        System.out.println("ana fe checkGame t10 : " + t10);
        String t11 = labelmap.get("label5");
        if (t11 == null) {
            t11 = "";
        }
        System.out.println("ana fe checkGame t11 : " + t11);
        String t12 = labelmap.get("label6");
        if (t12 == null) {
            t12 = "";
        }
        System.out.println("ana fe checkGame t12 : " + t12);
        String t20 = labelmap.get("label7");
        if (t20 == null) {
            t20 = "";
        }
        System.out.println("ana fe checkGame t20 : " + t20);
        String t21 = labelmap.get("label8");
        if (t21 == null) {
            t21 = "";
        }
        System.out.println("ana fe checkGame t21 : " + t21);
        String t22 = labelmap.get("label9");
        if (t22 == null) {
            t22 = "";
        }
        System.out.println("ana fe checkGame t22 : " + t22);
        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label1, label2, label3);
        }
        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label4, label5, label6);
        }

        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label7, label8, label9);
        }

        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label1, label4, label7);
        }

        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label2, label5, label8);
        }

        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label3, label6, label9);
        }

        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label1, label5, label9);
        }

        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            System.out.println("game is end");
            colorBackgroundWinner(label3, label5, label7);
        }

        if (XOCounter >= 9 && isGameEnds != true) {

            XOCounter = 0;

            System.out.println("ALert in GameBase For NO one win ");

        }

        if (isGameEnds) {

            if (isX) {
                isGameEnds = false;
                isX = false;
                System.out.println("ALert in GameBase For player1 winner ");

            } else {

                isGameEnds = false;
                isX = true;
                System.out.println("ALert in GameBase For player2 winner ");
            }

        }

    }

}
