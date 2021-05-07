/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import static tictactoe.SingleGame.countText;

/**
 *
 * @author Nada
 */
public class GameController {

    boolean isGameEnds;
    boolean isFirstPlayerTurn = true;
    int XOCounter = 0;
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    static LinkedHashMap<String, Label> labelMap = new LinkedHashMap<String, Label>();
     static LinkedHashMap<String, Label> recordMap = new LinkedHashMap<String, Label>();
    Stage s;
    static int countText;
    String winner;

    GameController(Stage stage) {
        for (int i = 1; i <= 9; i++) {
            String thelabel = "label" + i;
            Label l = new Label();
            l.setText("");
            labelMap.put(thelabel, l);
            s = stage;
        }

    }

    public void setCurrentPlayerSymbol(Label label, String labelname) {
        label.setOpacity(1);
        label.setFont(Font.font(50));
        if (isFirstPlayerTurn == true) {
            label.setText("X");
            label.setTextFill(xForeground);
            System.out.println(label);
            isFirstPlayerTurn = false;
            XOCounter++;
        } else {
            label.setText("O");
            label.setTextFill(oForeground);
            isFirstPlayerTurn = true;
            XOCounter++;
        }
        if (MultiOfflineBase.isRecorded == true) {
            readNumberOfText();
            recordMap.put(labelname, label);
        }
        labelMap.put(labelname, label);
        checkIfGameEnds(labelMap);
        label.setDisable(true);

    }

    private void colorBackgroundWinner(Label l1, Label l2, Label l3) {
        l1.setStyle("-fx-background-color: yellow;");
        l2.setStyle("-fx-background-color: yellow;");
        l3.setStyle("-fx-background-color: yellow;");
    }

    public void checkIfGameEnds(LinkedHashMap<String, Label> labelmap) {

        String t00 = labelmap.get("label1").getText();
        String t01 = labelmap.get("label2").getText();
        String t02 = labelmap.get("label3").getText();
        String t10 = labelmap.get("label4").getText();
        String t11 = labelmap.get("label5").getText();
        String t12 = labelmap.get("label6").getText();
        String t20 = labelmap.get("label7").getText();
        String t21 = labelmap.get("label8").getText();
        String t22 = labelmap.get("label9").getText();

        if (t00.equals(t01) && t00.equals(t02) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label2"), labelmap.get("label3"));
        }

        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label4"), labelmap.get("label5"), labelmap.get("label6"));
        }

        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label7"), labelmap.get("label8"), labelmap.get("label9"));
        }

        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label4"), labelmap.get("label7"));
        }

        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label2"), labelmap.get("label5"), labelmap.get("label8"));
        }

        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label3"), labelmap.get("label6"), labelmap.get("label9"));
        }

        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label5"), labelmap.get("label9"));
        }

        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            colorBackgroundWinner(labelmap.get("label3"), labelmap.get("label5"), labelmap.get("label7"));
        }

        if (XOCounter >= 9) {
            isFirstPlayerTurn = true;
            XOCounter = 0;
            countText++;
            if (MultiOfflineBase.isRecorded == true) 
                isRecorded(recordMap);
            Alert alert = new Alert(AlertType.INFORMATION, "No one Wins !!", ButtonType.OK);
            alert.showAndWait();
            if (alert.getResult() == ButtonType.OK) {
                Parent newRoot = new MultiOfflineBase(s);
                Scene scene = new Scene(newRoot);
                s.setScene(scene);
            }

        }

        if (isGameEnds == true) {
            if (!isFirstPlayerTurn) {
                winner = MultiOfflineBase.p1;
                countText++;
                 if (MultiOfflineBase.isRecorded == true) 
                isRecorded(recordMap);
                Alert alert = new Alert(AlertType.INFORMATION, MultiOfflineBase.p1 + " Wins !!", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    Parent newRoot = new MultiOfflineBase(s);
                    Scene scene = new Scene(newRoot);
                    s.setScene(scene);
                }
            } else {
                
                winner = MultiOfflineBase.p2;
                countText++;
                if (MultiOfflineBase.isRecorded == true) 
                isRecorded(recordMap);
                Alert alert = new Alert(AlertType.INFORMATION, MultiOfflineBase.p2 + " Wins !!", ButtonType.OK);
                alert.showAndWait();
                if (alert.getResult() == ButtonType.OK) {
                    Parent newRoot = new MultiOfflineBase(s);
                    Scene scene = new Scene(newRoot);
                    s.setScene(scene);
                }
            }

        }

    }

    public static void writeNumberOfText() {

        try {
            FileWriter myWriter = new FileWriter("numberOfText.txt");
            myWriter.write("" + countText);

            System.out.println("/************wirte in numberOfText values is : " + countText);
            myWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("/**************Didn't write in numberOfText ");
        }

    }

    public static void readNumberOfText() {
        File myObj = new File("C:\\Users\\Nada\\Documents\\NetBeansProjects\\TicTacToe\\src\\tictactoe\\numberOfText.txt");
        Scanner myReader;
        try {
            myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                countText = Integer.parseInt(myReader.nextLine());

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
