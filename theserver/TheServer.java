/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theserver;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoe.DataAccessLayer;
import tictactoe.FirstScreenBase;

/**
 *
 * @author Nada
 */
public class TheServer extends Application {
    
    @Override
    public void start(Stage stage) {
        Parent root = new ServerGUIBase(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
    }
    
}
