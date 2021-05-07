package theserver;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.MultiOnlineLoginBase;

public class ServerGUIBase extends Pane {

    protected final Button serverStartBtn;
    protected final Button serverStopBtn;
    protected final Label label;
    protected final Label label0;
    protected static ListView serverUsersList;
    protected static ListView opensessionslist;
    protected final Button graphsBtn;
    Stage stage;
    static boolean exit=false;
    Thread t1;
    public ServerGUIBase(Stage s) {
        stage = s;
        serverStartBtn = new Button();
        serverStopBtn = new Button();
        label = new Label();
        serverUsersList = new ListView();
        graphsBtn = new Button();
        opensessionslist = new ListView();
        label0 = new Label();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        serverStartBtn.setLayoutX(198.0);
        serverStartBtn.setLayoutY(41.0);
        serverStartBtn.setMnemonicParsing(false);
        serverStartBtn.setPrefHeight(31.0);
        serverStartBtn.setPrefWidth(93.0);
        serverStartBtn.setText("Start");

        serverStopBtn.setLayoutX(291.0);
        serverStopBtn.setLayoutY(41.0);
        serverStopBtn.setMnemonicParsing(false);
        serverStopBtn.setPrefHeight(31.0);
        serverStopBtn.setPrefWidth(93.0);
        serverStopBtn.setText("Stop");

        label.setLayoutX(36.0);
        label.setLayoutY(110.0);
        label.setText("Online users:");
        label.setFont(new Font(17.0));

        serverUsersList.setLayoutX(33.0);
        serverUsersList.setLayoutY(148.0);
        serverUsersList.setPrefHeight(200.0);
        serverUsersList.setPrefWidth(200.0);

        graphsBtn.setLayoutX(198.0);
        graphsBtn.setLayoutY(355.0);
        graphsBtn.setMnemonicParsing(false);
        graphsBtn.setPrefHeight(31.0);
        graphsBtn.setPrefWidth(200.0);
        graphsBtn.setText("Graphs");


        opensessionslist.setLayoutX(352.0);
        opensessionslist.setLayoutY(148.0);
        opensessionslist.setPrefHeight(200.0);
        opensessionslist.setPrefWidth(200.0);

        label0.setLayoutX(350.0);
        label0.setLayoutY(110.0);
        label0.setText("Currently playing");
        label0.setFont(new Font(17.0));

        getChildren().add(serverStartBtn);
        getChildren().add(serverStopBtn);
        getChildren().add(label);
        getChildren().add(serverUsersList);
        getChildren().add(graphsBtn);
        getChildren().add(opensessionslist);
        getChildren().add(label0);

        serverStartBtn.setOnAction((event) -> {
            exit=true;
            if (t1==null){
             t1 = new Thread(new Runnable() {
                public void run() {
                    myserver m = new myserver();
                }
            });
            t1.start();}
        });
        serverStopBtn.setOnAction((event) -> {
            //   AcceptUsers.dis=null;
            exit=false;
            System.out.println("Stopeed");
        });
        graphsBtn.setOnAction((event) -> {
            Parent newRoot = new GraphsBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
    }

    public static void UpdateOnlineUsers(String onlineusers) {
        System.out.println("online "+onlineusers);
        onlineusers = onlineusers.substring(1);
        onlineusers = onlineusers.substring(0, onlineusers.length() - 1);
        onlineusers = onlineusers.replaceAll("\\s+", "");
        String[] values = onlineusers.split(",");
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    serverUsersList.getItems().clear();
                    for (int i = 0; i < values.length; i++) {
                        serverUsersList.getItems().add(values[i]);
                    }
                }
        );

    }

    public static void UpdateSessions(LinkedHashMap<String, String> openSessions) {
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    opensessionslist.getItems().clear();
                    Iterator<Map.Entry<String, String>> myiterator = openSessions.entrySet().iterator();
                    while (myiterator.hasNext()) {
                        Map.Entry<String, String> entry = myiterator.next();
                        opensessionslist.getItems().add(entry.getKey().toString() + " and " + entry.getValue().toString());
                    }
                }
        );

    }
}
