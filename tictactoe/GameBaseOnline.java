package tictactoe;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameBaseOnline extends AnchorPane {

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
    protected static Label label1;
    protected static Label label2;
    protected static Label label3;
    protected static Label label4;
    protected static Label label5;
    protected static Label label6;
    protected static Label label7;
    protected static Label label8;
    protected static Label label9;
    protected final Line line;
    protected final Line line0;
    protected final Line line1;
    protected final Line line2;
    protected final Text player1Text;
    protected final Text player2Text;
    protected final Text text;
    protected final Text text0;

    static Stage stage;
    String playerTurn;
    static String theplayer;
    String thelabel;
    boolean isfirstplayer;
    static String winner = "noone";
    static String winnermatch;
    static boolean yourturn;
    static boolean isclosed = false;
     static String returnname;
    public GameBaseOnline(Stage s, String name, String thefirstplayer,String other) {
        getStylesheets().add("/Fxmlscreens/FristScreen.css");
        setId("root");
        stage = s;
        theplayer = name;
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
        ClientController cc = ClientController.getInstance();
       
        if (name.equals(thefirstplayer)) {
            player1Text.setText(name);
            isfirstplayer = true;
            playerTurn = "player1,";
            yourturn = true;
            player2Text.setText(other);
        } else {
            player2Text.setText(name);
            isfirstplayer = false;
            playerTurn = "player2,";
            yourturn = false;
              player1Text.setText(thefirstplayer);
        }
        GameControllerOnline game = new GameControllerOnline(s, isfirstplayer);
        

        stage.setOnCloseRequest((event) -> {
            if (isclosed == false) {
                cc.SuddenlyClosed(playerTurn, name);//send to controller that client named X has closed and which player it was
            }
        });

        label1.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label1, "label1", stage);
                cc.sendplayer(playerTurn + name + ",label1");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);//ex: player1,name
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);//ex: player2,name
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label2.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label2, "label2", stage);
                cc.sendplayer(playerTurn + name + ",label2");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label3.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label3, "label3", stage);
                cc.sendplayer(playerTurn + name + ",label3");
                if (winner.equals("player1")) {
                    System.out.println("ade l winner wl name " + winner + "," + name);
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label4.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label4, "label4", stage);
                cc.sendplayer(playerTurn + name + ",label4");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label5.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label5, "label5", stage);
                cc.sendplayer(playerTurn + name + ",label5");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label6.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label6, "label6", stage);
                cc.sendplayer(playerTurn + name + ",label6");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label7.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label7, "label7", stage);
                cc.sendplayer(playerTurn + name + ",label7");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label8.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label8, "label8", stage);
                cc.sendplayer(playerTurn + name + ",label8");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });
        label9.setOnMousePressed((event) -> {
            if (yourturn) {
                yourturn = false;
                winner = game.setCurrentPlayerSymbol(label9, "label9", stage);
                cc.sendplayer(playerTurn + name + ",label9");
                if (winner.equals("player1")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("player2")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                } else if (winner.equals("noone")) {
                    cc.sendwin(winner + "," + name + "," + winnermatch);
                }
            }
        });

    }

    public static void RecieveWinner(String winner) {
        isclosed = true;
        String[] values = winner.split(",");
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    if (values[0].equals("not a tie")) {
                        String[] winnerlabels = values[2].split(" ");
                        for (int i = 0; i < 3; i++) {
                            switch (winnerlabels[i]) {
                                case "label1":
                                    label1.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label2":
                                    label2.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label3":
                                    label3.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label4":
                                    label4.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label5":
                                    label5.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label6":
                                    label6.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label7":
                                    label7.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label8":
                                    label8.setStyle("-fx-background-color: yellow;");
                                    break;
                                case "label9":
                                    label9.setStyle("-fx-background-color: yellow;");
                                    break;
                            }

                        }
                    }
                    if (values[0].equals("not a tie")) {
                        String[] winnerName = values[1].split(" ");
                        if (winnerName[0].equals("You")) {
                            Parent newRoot = new WinnerVideoPlayerBase(stage, theplayer);
                            Scene scene = new Scene(newRoot);
                            stage.setScene(scene);
                        } else {
                            Alert alert = new Alert(AlertType.INFORMATION, values[1], ButtonType.OK);
                            alert.showAndWait();
                            if (alert.getResult() == ButtonType.OK) {
                                Parent newRoot = new OnlineUsersBase(stage, theplayer);
                                Scene scene = new Scene(newRoot);
                                stage.setScene(scene);
                            }

                        }
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION, values[0], ButtonType.OK);
                        alert.showAndWait();
                        if (alert.getResult() == ButtonType.OK) {
                            Parent newRoot = new OnlineUsersBase(stage, theplayer);
                            Scene scene = new Scene(newRoot);
                            stage.setScene(scene);
                        }
                    }
                }
        );

    }

    public static void ClientClosed(String closedclient) {

        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    Alert alert = new Alert(AlertType.INFORMATION, closedclient + " surrendered!! You Won !!!", ButtonType.OK);
                    alert.showAndWait();
                    if (alert.getResult() == ButtonType.OK) {
                        Parent newRoot = new OnlineUsersBase(stage, theplayer);
                        Scene scene = new Scene(newRoot);
                        stage.setScene(scene);
                    }
                });
    }

    public static void Recievetheplay(String play) {
        yourturn = true;
        String[] values = play.split(",");
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    if (values[0].equals("player1")) {
                        System.out.println("Client player1 switch");
                        switch (values[1]) {
                            case "label1":
                                label1.setText("X");
                                label1.setTextFill(Color.BLUE);
                                label1.setOpacity(1);
                                label1.setFont(Font.font(50));
                                label1.setDisable(true);
                                break;
                            case "label2":
                                label2.setText("X");
                                label2.setTextFill(Color.BLUE);
                                label2.setOpacity(1);
                                label2.setFont(Font.font(50));
                                label2.setDisable(true);
                                break;
                            case "label3":
                                label3.setText("X");
                                label3.setTextFill(Color.BLUE);
                                label3.setOpacity(1);
                                label3.setFont(Font.font(50));
                                label3.setDisable(true);
                                break;
                            case "label4":
                                label4.setText("X");
                                label4.setTextFill(Color.BLUE);
                                label4.setOpacity(1);
                                label4.setFont(Font.font(50));
                                label4.setDisable(true);
                                break;
                            case "label5":
                                label5.setText("X");
                                label5.setTextFill(Color.BLUE);
                                label5.setOpacity(1);
                                label5.setFont(Font.font(50));
                                label5.setDisable(true);
                                break;
                            case "label6":
                                label6.setText("X");
                                label6.setTextFill(Color.BLUE);
                                label6.setOpacity(1);
                                label6.setFont(Font.font(50));
                                label6.setDisable(true);
                                break;
                            case "label7":
                                label7.setText("X");
                                label7.setTextFill(Color.BLUE);
                                label7.setOpacity(1);
                                label7.setFont(Font.font(50));
                                label7.setDisable(true);
                                break;
                            case "label8":
                                label8.setText("X");
                                label8.setTextFill(Color.BLUE);
                                label8.setOpacity(1);
                                label8.setFont(Font.font(50));
                                label8.setDisable(true);
                                break;
                            case "label9":
                                label9.setText("X");
                                label9.setTextFill(Color.BLUE);
                                label9.setOpacity(1);
                                label9.setFont(Font.font(50));
                                label9.setDisable(true);
                                break;
                            default:
                                System.out.println("Default");
                        }

                    } else if (values[0].equals("player2")) {
                        switch (values[1]) {
                            case "label1":
                                label1.setText("O");
                                label1.setTextFill(Color.RED);
                                label1.setOpacity(1);
                                label1.setFont(Font.font(50));
                                label1.setDisable(true);
                                break;
                            case "label2":
                                label2.setText("O");
                                label2.setTextFill(Color.RED);
                                label2.setOpacity(1);
                                label2.setFont(Font.font(50));
                                label2.setDisable(true);
                                break;
                            case "label3":
                                label3.setText("O");
                                label3.setTextFill(Color.RED);
                                label3.setOpacity(1);
                                label3.setFont(Font.font(50));
                                label3.setDisable(true);
                                break;
                            case "label4":
                                label4.setText("O");
                                label4.setTextFill(Color.RED);
                                label4.setOpacity(1);
                                label4.setFont(Font.font(50));
                                label4.setDisable(true);
                                break;
                            case "label5":
                                label5.setText("O");
                                label5.setTextFill(Color.RED);
                                label5.setOpacity(1);
                                label5.setFont(Font.font(50));
                                label5.setDisable(true);
                                break;
                            case "label6":
                                label6.setText("O");
                                label6.setTextFill(Color.RED);
                                label6.setOpacity(1);
                                label6.setFont(Font.font(50));
                                label6.setDisable(true);
                                break;
                            case "label7":
                                label7.setText("O");
                                label7.setTextFill(Color.RED);
                                label7.setOpacity(1);
                                label7.setFont(Font.font(50));
                                label7.setDisable(true);
                                break;
                            case "label8":
                                label8.setText("O");
                                label8.setTextFill(Color.RED);
                                label8.setOpacity(1);
                                label8.setFont(Font.font(50));
                                label8.setDisable(true);
                                break;
                            case "label9":
                                label9.setText("O");
                                label9.setTextFill(Color.RED);
                                label9.setOpacity(1);
                                label9.setFont(Font.font(50));
                                label9.setDisable(true);
                                break;
                        }

                    }

                }
        );

    }
   
}
