package tictactoe;

import javafx.application.Platform;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class RegisterationOnlineBase extends Pane {

    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected static TextField userNameTxtField;
    protected final TextField emailTxtField;
    protected final TextField passwordTxtField;
    protected final Text text;
    protected final Text text0;
    protected static Text text1;
    protected final Button cancleBtn;
    protected final Button registerBtn;
    protected final Button backBtn;
    static Stage stage;

    public RegisterationOnlineBase(Stage s) {
        getStylesheets().add("/Fxmlscreens/FristScreen.css");
        setId("root");
        stage = s;
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        userNameTxtField = new TextField();
        emailTxtField = new TextField();
        passwordTxtField = new TextField();
        text = new Text();
        text0 = new Text();
        text1 = new Text();
        cancleBtn = new Button();
        registerBtn = new Button();
        backBtn = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(565.0);

        label.setLayoutX(149.0);
        label.setLayoutY(150.0);
        label.setText("User name");

        label0.setLayoutX(149.0);
        label0.setLayoutY(195.0);
        label0.setText("Email");

        label1.setLayoutX(149.0);
        label1.setLayoutY(241.0);
        label1.setText("Password");

        userNameTxtField.setLayoutX(271.0);
        userNameTxtField.setLayoutY(145.0);
        userNameTxtField.setPromptText("user name");

        emailTxtField.setLayoutX(271.0);
        emailTxtField.setLayoutY(190.0);
        emailTxtField.setPromptText("email");

        passwordTxtField.setLayoutX(271.0);
        passwordTxtField.setLayoutY(236.0);
        passwordTxtField.setPromptText("password");

        text.setLayoutX(207.0);
        text.setLayoutY(73.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Tic Tac Toe");
        text.setWrappingWidth(177.9999941587448);
        text.setFont(new Font("Bodoni MT", 34.0));

        text0.setLayoutX(217.0);
        text0.setLayoutY(118.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText(" Create account");
        text0.setWrappingWidth(177.99999657273293);
        text0.setFont(new Font(20.0));

        text1.setFill(javafx.scene.paint.Color.valueOf("#c93f3f"));
        text1.setLayoutX(172.0);
        text1.setLayoutY(299.0);
        text1.setLineSpacing(2.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("sorry , this name is registered");
        text1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        text1.setWrappingWidth(229.00000216066837);
        text1.setFont(new Font(12.0));
        text1.setCursor(Cursor.NONE);
        text1.setVisible(false);

        cancleBtn.setLayoutX(172.0);
        cancleBtn.setLayoutY(333.0);
        cancleBtn.setMnemonicParsing(false);
        cancleBtn.setPrefHeight(31.0);
        cancleBtn.setPrefWidth(95.0);
        cancleBtn.setText("cancel");
        
        cancleBtn.setId("BackToMain");
        
        registerBtn.setLayoutX(317.0);
        registerBtn.setLayoutY(333.0);
        registerBtn.setMnemonicParsing(false);
        registerBtn.setPrefHeight(40.0);
        registerBtn.setPrefWidth(130.0);
        registerBtn.setText("Register");
        registerBtn.setWrapText(true);
        registerBtn.setId("BackToMain");

        backBtn.setLayoutX(24.0);
        backBtn.setLayoutY(25.0);
        backBtn.setMnemonicParsing(false);
        backBtn.setText("Back");
         backBtn.setId("back");
         
        getChildren().add(label);
        getChildren().add(label0);
        getChildren().add(label1);
        getChildren().add(userNameTxtField);
        getChildren().add(emailTxtField);
        getChildren().add(passwordTxtField);
        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(text1);
        getChildren().add(cancleBtn);
        getChildren().add(registerBtn);
        getChildren().add(backBtn);

        backBtn.setOnAction((event) -> {
            Parent newRoot = new MultiOnlineLoginBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });
        cancleBtn.setOnAction((event) -> {
            Parent newRoot = new FirstScreenBase(stage);
            Scene scene = new Scene(newRoot);
            stage.setScene(scene);
        });

        registerBtn.setOnAction((event) -> {
            ClientController cc = ClientController.getInstance();
            cc.registerPlayer(userNameTxtField.getText(), passwordTxtField.getText(), emailTxtField.getText());
        });
    }

    public static void Registerrecieved(String found) {
        Platform.runLater(// Avoid throwing IllegalStateException by running from a non-JavaFX thread.
                () -> {
                    if (found.equals("false")) {
                        text1.setVisible(true);
                    } else {
                        Parent newRoot = new OnlineUsersBase(stage, userNameTxtField.getText().toString());
                        Scene scene = new Scene(newRoot);
                        stage.setScene(scene);
                    }
                }
        );

    }
}
