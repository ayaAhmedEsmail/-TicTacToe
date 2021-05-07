package tictactoe;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MultiOnlineLoginBase extends Pane {

    protected final Label wellcomLabel;
    protected final Label titleLabel;
    protected static TextField userNameTxtField;
    protected static PasswordField passwordTxtField;
    protected final Button loginBtn;
    protected final Button signupBtn;
    protected static Text text1;
    protected final Button backBtn;
    protected final Label label;
    protected final Label label0;
   static Stage stage;

    public MultiOnlineLoginBase(Stage s) {
        getStylesheets().add("/Fxmlscreens/FristScreen.css");
        stage = s;
        titleLabel = new Label();
        
        wellcomLabel = new Label();
        userNameTxtField = new TextField();
        passwordTxtField = new PasswordField();
        loginBtn = new Button();
        loginBtn.setId("BackToMain");
        signupBtn = new Button();
        text1 = new Text();
        backBtn = new Button();
        backBtn.setId("BackToMain");

        label = new Label();
        label0 = new Label();
        
        setId("root");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(371.0);
        setPrefWidth(583.0);

        
        wellcomLabel.setLayoutX(210.0);
        wellcomLabel.setLayoutY(53.0);
        wellcomLabel.setPrefHeight(52.0);
        wellcomLabel.setPrefWidth(195.0);
        wellcomLabel.setId("tictactoe");
        wellcomLabel.setText("Tic Tac Toe");
        wellcomLabel.setFont(new Font("Arabic Typesetting", 38.0));
         
        
        titleLabel.setLayoutX(230.0);
        titleLabel.setLayoutY(100.0);
        titleLabel.setPrefHeight(52.0);
        titleLabel.setPrefWidth(135.0);
        titleLabel.setId("tictactoe2");
        titleLabel.setText("Welcome");
        titleLabel.setFont(new Font("Arabic Typesetting", 38.0));
        


        label.setId("tictactoe2");
        label0.setId("tictactoe2");
        userNameTxtField.setLayoutX(230.0);
        userNameTxtField.setLayoutY(154.0);
         
        passwordTxtField.setLayoutX(230.0);
        passwordTxtField.setLayoutY(209.0);

        loginBtn.setLayoutX(164.0);
        loginBtn.setLayoutY(299.0);
        loginBtn.setMnemonicParsing(false);
        loginBtn.setPrefHeight(31.0);
        loginBtn.setPrefWidth(95.0);
        loginBtn.setText("Login");
        loginBtn.setPrefWidth(100.0);


        signupBtn.setId("BackToMain");
        signupBtn.setLayoutX(309.0);
        signupBtn.setLayoutY(299.0);
        signupBtn.setMnemonicParsing(false);
        signupBtn.setPrefHeight(31.0);
        signupBtn.setPrefWidth(95.0);
        signupBtn.setText("Sign Up");
        signupBtn.setPrefWidth(100.0);


        text1.setFill(javafx.scene.paint.Color.valueOf("#c93f3f"));
        text1.setLayoutX(176.0);
        text1.setLayoutY(271.0);
        text1.setLineSpacing(2.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("sorry ,invalid email or password");
        text1.setVisible(false);
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(215.00000216066837);
        text1.setFont(new Font(12.0));

        backBtn.setLayoutX(29.0);
        backBtn.setLayoutY(26.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(100.0);
        label.setLayoutY(156.0);
        label.setPrefHeight(29.0);
        label.setPrefWidth(102.0);
        label.setText("UserName");
        label.setFont(new Font(21.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(100.0);
        label0.setLayoutY(209.0);
        label0.setPrefHeight(29.0);
        label0.setPrefWidth(102.0);
        label0.setText("Password");
        label0.setFont(new Font(21.0));

        getChildren().add(titleLabel);
        getChildren().add(wellcomLabel);
        getChildren().add(userNameTxtField);
        getChildren().add(passwordTxtField);
        getChildren().add(loginBtn);
        getChildren().add(signupBtn);
        getChildren().add(text1);
        getChildren().add(backBtn);
        getChildren().add(label);
        getChildren().add(label0);
        backBtn.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

        signupBtn.setOnAction((event) -> {
            Parent newRoot = new RegisterationOnlineBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

        loginBtn.setOnAction((event) -> {
            ClientController cc = ClientController.getInstance();
            cc.loginPlayer(userNameTxtField.getText().toString(), passwordTxtField.getText().toString());
        });

    }

    public static void Loginrecieved(String found) {
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    if (found.equals("true")) {
                        Parent newRoot = new OnlineUsersBase(stage, userNameTxtField.getText().toString());
                        Scene scene = new Scene(newRoot);
                        stage.setScene(scene);
                    } else {
                        text1.setVisible(true);
                        userNameTxtField.clear();
                        passwordTxtField.clear();
                    }
                }
        );

    }
}
