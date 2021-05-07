package theserver;

import java.util.LinkedHashMap;
import java.util.Map;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.DataAccessLayer;
import java.util.Map.Entry;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.StackedBarChart;

public class GraphsBase extends Pane {

    protected final CategoryAxis y;
    protected final NumberAxis x;
    protected static StackedBarChart winsChart;
    protected final Label label;
    protected final Button backBtn;
    LinkedHashMap<String, Integer> winsMap;
    Stage stage;

    public GraphsBase(Stage s) {
        stage = s;
        y = new CategoryAxis();
        x = new NumberAxis();
        winsChart = new StackedBarChart(y, x);
        label = new Label();
        backBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        y.setLabel("Username");
        y.setSide(javafx.geometry.Side.BOTTOM);

        x.setLabel("wins");
        x.setSide(javafx.geometry.Side.LEFT);
        winsChart.setLayoutX(0.0);
        winsChart.setLayoutY(70.0);
        winsChart.setPrefHeight(400.0);
        winsChart.setPrefWidth(600.0);

        label.setLayoutX(231.0);
        label.setLayoutY(19.0);
        label.setText("Number of wins");
        label.setFont(new Font(20.0));

        backBtn.setLayoutX(39.0);
        backBtn.setLayoutY(18.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        getChildren().add(winsChart);
        getChildren().add(label);
        getChildren().add(backBtn);
        winsMap = DataAccessLayer.getWins();
        for (Map.Entry<String, Integer> entry : winsMap.entrySet()) {
            String name = entry.getKey();
            Integer wins = entry.getValue();
            XYChart.Series set1 = new XYChart.Series<>();
            set1.getData().add(new XYChart.Data(name, wins));
            winsChart.getData().add(set1);
        }
        backBtn.setOnAction((event) -> {
            Parent newRoot = new ServerGUIBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);

        });

    }
}
