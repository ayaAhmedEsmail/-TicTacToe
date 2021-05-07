/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.LinkedHashMap;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Nada
 */
public class GameControllerOnline {

    boolean isGameEnds;
    boolean isFirstPlayerTurn;
    int XOCounter = 0;
    Color xForeground = Color.BLUE;
    Color oForeground = Color.RED;
    LinkedHashMap<String, Label> labelMap = new LinkedHashMap<String, Label>();
    String winner;

    public GameControllerOnline(Stage s, boolean themode) {
        isFirstPlayerTurn = themode;
        if (themode) {
            winner = "player1";
        } else {
            winner = "player2";
        }
        for (int i = 1; i <= 9; i++) {
            String thelabel = "label" + i;
            Label l = new Label();
            l.setText("");
            labelMap.put(thelabel, l);
        }
    }

    public String setCurrentPlayerSymbol(Label label, String labelname, Stage s) {
        label.setOpacity(1);
        label.setFont(Font.font(50));
        if (isFirstPlayerTurn == true) {
            label.setText("X");
            label.setTextFill(xForeground);
            XOCounter++;
        } else {
            label.setText("O");
            label.setTextFill(oForeground);
            XOCounter++;
        }

        labelMap.put(labelname, label);
        label.setDisable(true);
        return checkIfGameEnds(labelMap, s);
    }

    private void colorBackgroundWinner(Label l1, Label l2, Label l3) {
        l1.setStyle("-fx-background-color: yellow;");
        l2.setStyle("-fx-background-color: yellow;");
        l3.setStyle("-fx-background-color: yellow;");
    }

    public String checkIfGameEnds(LinkedHashMap<String, Label> labelmap, Stage s) {

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
            GameBaseOnline.winnermatch = "label1 label2 label3";
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label2"), labelmap.get("label3"));
        }

        if (t10.equals(t11) && t10.equals(t12) && !t10.equals("")) {
            isGameEnds = true;
            GameBaseOnline.winnermatch = "label4 label5 label6";
            colorBackgroundWinner(labelmap.get("label4"), labelmap.get("label5"), labelmap.get("label6"));
        }

        if (t20.equals(t21) && t20.equals(t22) && !t20.equals("")) {
            isGameEnds = true;
            GameBaseOnline.winnermatch = "label7 label8 label9";
            colorBackgroundWinner(labelmap.get("label7"), labelmap.get("label8"), labelmap.get("label9"));
        }

        if (t00.equals(t10) && t00.equals(t20) && !t00.equals("")) {
            isGameEnds = true;
            GameBaseOnline.winnermatch = "label1 label4 label7";
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label4"), labelmap.get("label7"));
        }

        if (t01.equals(t11) && t01.equals(t21) && !t01.equals("")) {
            isGameEnds = true;
            GameBaseOnline.winnermatch = "label2 label5 label8";
            colorBackgroundWinner(labelmap.get("label2"), labelmap.get("label5"), labelmap.get("label8"));
        }

        if (t02.equals(t12) && t02.equals(t22) && !t02.equals("")) {
            isGameEnds = true;
            GameBaseOnline.winnermatch = "label3 label6 label9";
            colorBackgroundWinner(labelmap.get("label3"), labelmap.get("label6"), labelmap.get("label9"));
        }

        if (t00.equals(t11) && t00.equals(t22) && !t00.equals("")) {
            isGameEnds = true;
            GameBaseOnline.winnermatch = "label1 label5 label9";
            colorBackgroundWinner(labelmap.get("label1"), labelmap.get("label5"), labelmap.get("label9"));
        }

        if (t02.equals(t11) && t02.equals(t20) && !t02.equals("")) {
            isGameEnds = true;
            GameBaseOnline.winnermatch = "label3 label5 label7";
            colorBackgroundWinner(labelmap.get("label3"), labelmap.get("label5"), labelmap.get("label7"));
        }

        if (isGameEnds) {
            return winner;
        } 
        else  if (XOCounter >= 5) {
            isGameEnds = true;
            return "noone";
        }
        else {
            return "NO";
        }
         
    }

}
