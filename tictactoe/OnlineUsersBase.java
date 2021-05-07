package tictactoe;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OnlineUsersBase extends Pane {

    protected final Text text;
    protected final Button historyBtn;
    protected static ListView onlineListView;
    protected final Label label;
    protected final Button logoutBtn;
    static Stage stage;
    static String name;
    // static boolean listisfull = false;
    static String otherplayer;
    public OnlineUsersBase(Stage s, String name) {
        getStylesheets().add("/Fxmlscreens/FristScreen.css");
        setId("root");

        stage = s;
        text = new Text();
        historyBtn = new Button();
        onlineListView = new ListView();
        label = new Label();
        logoutBtn = new Button();
        this.name = name;

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        text.setLayoutX(38.0);
        text.setLayoutY(120.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("online users :");
        text.setFont(new Font(26.0));

        historyBtn.setLayoutX(503.0);
        historyBtn.setLayoutY(353.0);
        historyBtn.setMnemonicParsing(false);
        historyBtn.setOpacity(0.93);
        historyBtn.setPrefHeight(32.0);
        historyBtn.setPrefWidth(81.0);
        historyBtn.setText("History");

        onlineListView.setLayoutX(73.0);
        onlineListView.setLayoutY(143.0);
        onlineListView.setPrefHeight(200.0);
        onlineListView.setPrefWidth(432.0);

        label.setLayoutX(206.0);
        label.setLayoutY(23.0);
        label.setText("Tic Tac Toe");
        label.setFont(new Font(34.0));

        logoutBtn.setLayoutX(497.0);
        logoutBtn.setLayoutY(23.0);
        logoutBtn.setMnemonicParsing(false);
        logoutBtn.setText("LogOut");
        
        label.setId("tictactoe");
        getChildren().add(text);
        getChildren().add(historyBtn);
        getChildren().add(onlineListView);
        getChildren().add(label);
        getChildren().add(logoutBtn);

        ClientController cc = ClientController.getInstance();

        logoutBtn.setOnAction((event) -> {
            cc.sendlogoutnames(name);
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        historyBtn.setOnAction((event) -> {

            Parent newRoot = new HistoryBase(stage, name);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

        onlineListView.setOnMouseClicked((event) -> {
            cc.SendPlayRequest(onlineListView.getSelectionModel().getSelectedItem().toString(), name);
            otherplayer=onlineListView.getSelectionModel().getSelectedItem().toString();
        });

        cc.sendloginnames(name);

    }

    public static void StartTheGame() {
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    Parent newRoot = new GameBaseOnline(stage, name, name,otherplayer);
                    Scene scene = new Scene(newRoot);
                    stage.setScene(scene);
                }
        );

    }

    public static void recievelistofname(String thelistofnames) {
        String[] values = thelistofnames.split(",");
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    onlineListView.getItems().clear();
                    for (int i = 0; i < values.length; i++) {
                        if (!values[i].equals(name)) {
                            onlineListView.getItems().add(values[i]);
                        }

                    }
                }
        );
    }

    public static void RequestDenied(String player) {
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION, player + " refused to play ", ButtonType.OK);
                    alert.show();
                }
        );
    }

    public static void recieveplayrequest(String player1) {
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION, player1 + " wants to play with you", ButtonType.NO, ButtonType.OK);
                    alert.showAndWait();
                    ClientController cc = ClientController.getInstance();
                    if (alert.getResult() == ButtonType.OK) {
                        Parent newRoot = new GameBaseOnline(stage, name, player1,"");
                        System.out.println("Name in play " + name);
                        Scene scene = new Scene(newRoot);
                        stage.setScene(scene);
                        cc.RecievePlayConfirmation(name, player1);
                    } else {
                        cc.RecieveDenial(name, player1);
                    }
                }
        );
    }
}
